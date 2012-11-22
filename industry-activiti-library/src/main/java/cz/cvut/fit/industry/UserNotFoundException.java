package cz.cvut.fit.industry;

import cz.cvut.fit.industry.api.exception.IndustryException;

public class UserNotFoundException extends IndustryException {

	public UserNotFoundException() {
	}

	public UserNotFoundException(String arg0) {
		super(arg0);
	}

	public UserNotFoundException(Throwable arg0) {
		super(arg0);
	}

	public UserNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
}