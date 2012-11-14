package cz.cvut.fit.industry;

import java.util.List;


public interface LdapConnector {
	LdapUser getUser(String uid);
	List<LdapUser> getUsersInGroup(String gid);
	public void initialize(String hostName);
}
