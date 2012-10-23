package cz.cvut.fit.industry;

public class ActivitiPortletLibraryFactory {

	private ActivitiPortletLibraryFactory() {
	}

	public static ActivitiLibrary getActivitiLibrary() {
		return new ActivitLibraryImpl();
	}

}
