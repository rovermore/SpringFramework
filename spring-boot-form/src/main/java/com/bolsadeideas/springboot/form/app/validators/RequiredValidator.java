package com.bolsadeideas.springboot.form.app.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RequiredValidator implements ConstraintValidator<Required, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (!value.isEmpty() && value != null && !value.isBlank()) {
			return true;
		}
		return false;
	}

}
