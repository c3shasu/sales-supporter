package jp.co.ccube.ss.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD,
		java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.CONSTRUCTOR,
		java.lang.annotation.ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { AccountIdValidator.class })
public @interface AccountIdCheck {

	String message() default "{jp.co.ccube.ss.validator.constraints.AccountId.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
