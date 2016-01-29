package com.roshankhatri.neccps.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.roshankhatri.neccps.model.Program;

public class ProgramValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Program.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Program program=(Program) obj;
		if(program.getProgramName().length()<5)
		{
			errors.rejectValue("programName", "program.programName", "Program Name must be greater than Five characters in length");
		}
		
	}

}
