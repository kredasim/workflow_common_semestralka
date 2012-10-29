package cz.cvut.fit.industry;

/**
 * Static factory class for creating new
 * ActivitiLibrary instances.
 * @author szolatib
 */
public class ActivitiLibraryFactory {

	/**
	 * Creates and retrieves new ActivitiLibrary instance.
	 * @return
	 */
	public static ActivitiLibrary createActivitiLibrary() {
		return new ActivitLibraryImpl();
	}
	
	private ActivitiLibraryFactory() {
	}

}
