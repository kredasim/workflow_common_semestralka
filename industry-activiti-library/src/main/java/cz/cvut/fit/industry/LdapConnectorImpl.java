package cz.cvut.fit.industry;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class LdapConnectorImpl implements LdapConnector {

	private boolean connected = false;
	private InitialDirContext ctx;
	private String hostname;

	private LdapUser getUserFromDn(String dn) throws NamingException {
		Attributes attrs = ctx.getAttributes(dn);
		LdapUser user = new LdapUser();
		user.setuID(attrs.get("uid").get().toString());
		user.setCommonName(attrs.get("cn").get().toString());
		user.setGivenName(attrs.get("givenName").get().toString());
		user.setSurname(attrs.get("sn").get().toString());
		user.setEmail(attrs.get("mail").get().toString());// attrs.get("mail").toString());
		return user;
	}

	@Override
	public LdapUser getUser(String uid) {
		if (!connected) {
			throw new IllegalStateException(
					"Not initialized. Call initialize() before getUser().");
		}
		try {
			String dn = "uid=" + uid + ", ou=People,o=fit.cvut.cz";
			return getUserFromDn(dn);
		} catch (NamingException e) {
			throw (new UserNotFoundException(e));
		}

	}

	public void initialize(String hostName) {
		// public void initialize(/*String user, String password, hostNAme*/) {
		if (connected) {
			return;
			// ASKTIBOR
		}
		hostname = hostName;
		Properties props = new Properties();
		props.put(DirContext.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.ldap.LdapCtxFactory");
		props.put(DirContext.PROVIDER_URL, "ldaps://ldap.fit.cvut.cz/");
		props.put(DirContext.SECURITY_AUTHENTICATION, "none");
		/*
		 * props.put(DirContext.SECURITY_PRINCIPAL, "uid=" + user +
		 * ",ou=People,o=fit.cvut.cz");
		 * props.put(DirContext.SECURITY_CREDENTIALS, password);
		 */
		try {
			/* InitialDirContext */
			ctx = new InitialDirContext(props);
			// TODO LOGOVANI
			connected = true;
			return;
		} catch (NamingException ex) {
			// TODO LOGOVANI
			return;

		}

	}

	@Override
	public List<LdapUser> getUsersInGroup(String gid) {
		if (!connected) {
			throw new IllegalStateException(
					"Not initialized. Call initialize() before getUser().");
		}
		try {
			Attributes attrs = ctx.getAttributes("cn=" + gid
					+ ", ou=is,ou=groups,o=" + hostname);
			ArrayList<LdapUser> group = new ArrayList<LdapUser>();
			Attribute members = attrs.get("uniqueMember");
			NamingEnumeration<String> namingEnumeration = (NamingEnumeration<String>) members
					.getAll();
			String memberDn;
			while (namingEnumeration.hasMore()) {
				// System.out.println(memberDn.toString());
				memberDn = namingEnumeration.next();
				group.add(getUserFromDn(memberDn));				
				
			}

			return group;
		} catch (NamingException e) {
			throw (new GroupNotFoundException(e));
		}

	}
}
