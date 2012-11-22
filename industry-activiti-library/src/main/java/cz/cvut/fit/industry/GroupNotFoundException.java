package cz.cvut.fit.industry;

import cz.cvut.fit.industry.api.exception.IndustryException;

public class GroupNotFoundException extends IndustryException {

	public GroupNotFoundException() {
	}

	public GroupNotFoundException(String arg0) {
		super(arg0);
	}

	public GroupNotFoundException(Throwable arg0) {
		super(arg0);
	}

	public GroupNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}