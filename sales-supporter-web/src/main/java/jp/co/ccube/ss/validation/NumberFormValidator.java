package jp.co.ccube.ss.validation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumberFormValidator implements ConstraintValidator<NumberFormValid,String> {

    private NumberFormValid my;
    @Override
    public void initialize(NumberFormValid annotation) {
        this.my = annotation;

    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
    	if(value == null)
    	{
    		return true;
    	}else{
    	return Pattern.compile("^[0-9]+$").matcher(value).find();
    }
    }
}
