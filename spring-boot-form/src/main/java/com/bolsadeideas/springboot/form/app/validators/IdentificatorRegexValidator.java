package com.bolsadeideas.springboot.form.app.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdentificatorRegexValidator implements ConstraintValidator<IdentificatorRegex, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if (value.matches("[0-9]{2}[-.][0-9a-zA-Z]{3}[-.][0-9]{2}")) {
			return true;
		}
		return false;
	}

}
