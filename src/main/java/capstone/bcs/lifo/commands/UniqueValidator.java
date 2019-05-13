package capstone.bcs.lifo.commands;


import capstone.bcs.lifo.model.CustomerV2;
import capstone.bcs.lifo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<ValidateTest,String>{


    // this is a annotation validator this returns the test cases for email and user name uniqueness
    // this imo is the coolest thing in the project because it extends the language 

    private ValidState validState;
    private CustomerService customerService;

    @Autowired // this is for intention only
    public UniqueValidator(CustomerService customerService){
        this.customerService = customerService;
    }

    @Override
    public void initialize(ValidateTest constraintAnnotation){
        this.validState = constraintAnnotation.value();

    }

    @Override
    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
        if (object == null) {
            return true;
        }

        boolean isValid = true;
        String username = "";

        if(validState == ValidState.USERNAME && object != null)
        {

            try{
                CustomerV2 local = customerService.getByUserName(object);
                if(local.getAccount().getUsername() != null)
                {
                    username = local.getAccount().getUsername();
                }

                if(object.equals(username))
                {
                    isValid = false;
                }
            } catch (Exception e)
            {
                isValid = true;
            }

        }

        if(validState == ValidState.EMAIL && object != null) {

            try {
                CustomerV2 local = customerService.getByEmail(object);
                String email = local.getpEmail();
                System.out.println("value of email is " + email);
                if (object.equals(email)) {
                    isValid = false;
                }
            } catch (Exception e) {
                isValid = true;
            }
        }


        if (!isValid && validState == ValidState.USERNAME ) {
            constraintContext.disableDefaultConstraintViolation();
            constraintContext.buildConstraintViolationWithTemplate(
                    "The username already exists please pic another user name"
            )
                    .addConstraintViolation();
        }

        if (!isValid && validState == ValidState.EMAIL ) {
            constraintContext.disableDefaultConstraintViolation();
            constraintContext.buildConstraintViolationWithTemplate(
                    "The email already exists please register under another email"
            )
                    .addConstraintViolation();
        }

        return isValid;
    }


}
