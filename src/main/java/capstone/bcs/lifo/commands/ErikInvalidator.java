package capstone.bcs.lifo.commands;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ErikInvalidator implements ConstraintValidator<InvalidateErik,String> {

    private PreventErikStates preventErikStates;

    @Override
    public void initialize(InvalidateErik constraintAnnotation) {
        this.preventErikStates = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return true;
        }
        boolean isValid = true;

        if (preventErikStates == PreventErikStates.PREVENT_USERNAME && s != null) {
            if (s.equals("Erik")) {
                return isValid = false;
            }

            if (s.equals("erik")) {
                return isValid = false;
            }

            if (s.equals("defNOTErik")) {
                return isValid = false;
            }
        }

        if (preventErikStates == PreventErikStates.PREVENT_CITY && s != null) {
            if (s.equals("Somewhere Erik might live")) {
                return isValid = false;
            }

            if (s.equals("Where Erik would live")) {
                return isValid = false;
            }

            if (s.equals("Erik's city")) {
                return isValid = false;
            }
        }

        if (preventErikStates == PreventErikStates.PREVENT_EMAIL && s != null) {
            if (s.equals("ERIKSEmail@gmail.com")) {
                return isValid = false;
            }

            if (s.equals("ERIKSOtherEmail@gmail.com")) {
                return isValid = false;
            }

            if (s.equals("ERIKSHIDDENEMail@gmail.com")) {
                return isValid = false;
            }
        }

        if (preventErikStates == PreventErikStates.PREVENT_PASSWORD && s != null) {
            if (s.equals("APasswordErik would use ")) {
                return isValid = false;
            }

            if (s.equals("ERIKSPassword")) {
                return isValid = false;
            }

            if (s.equals("DEFNOTERIKSPASSWORD")) {
                return isValid = false;
            }
        }

        if (preventErikStates == PreventErikStates.PREVENT_PHONENUMBER && s != null) {
            if (s.equals("EriksPhoneNum ")) {
                return isValid = false;
            }
        }

        if (preventErikStates == PreventErikStates.PREVENT_ZIP && s != null) {
            if (s.equals("ErikZIP ")) {
                return isValid = false;
            }
        }

        if (preventErikStates == PreventErikStates.PREVENT_ADDRESS && s != null) {
            if (s.equals("Where Erik resides")) {
                return isValid = false;
            }
        }

        if (!isValid && preventErikStates == PreventErikStates.PREVENT_USERNAME) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(
                    "Erik don't try to log in"
            ).addConstraintViolation();
        }

        if (!isValid && preventErikStates == PreventErikStates.PREVENT_CITY) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(
                    "Erik don't try to log in"
            ).addConstraintViolation();
        }

        if (!isValid && preventErikStates == PreventErikStates.PREVENT_PASSWORD) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(
                    "Erik don't try to log in"
            ).addConstraintViolation();
        }

        if (!isValid && preventErikStates == PreventErikStates.PREVENT_PHONENUMBER) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(
                    "Erik don't try to log in"
            ).addConstraintViolation();
        }

        if (!isValid && preventErikStates == PreventErikStates.PREVENT_ADDRESS) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(
                    "Erik don't try to log in"
            ).addConstraintViolation();
        }
        if (!isValid && preventErikStates == PreventErikStates.PREVENT_ZIP) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(
                    "Erik don't try to log in"
            ).addConstraintViolation();
        }

        return isValid;
    }
}

