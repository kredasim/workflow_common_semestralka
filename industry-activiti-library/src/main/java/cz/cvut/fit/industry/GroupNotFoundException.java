package cz.cvut.fit.industry;

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

	public GroupNotFoundException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
