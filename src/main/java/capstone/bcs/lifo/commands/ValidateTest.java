package capstone.bcs.lifo.commands;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = UniqueValidator.class)
@Documented
@Repeatable(ValidateTest.List.class)
public @interface ValidateTest {
    String message() default "dres custom error thrown";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    ValidState value();

    @Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        ValidateTest[] value();
    }
}

