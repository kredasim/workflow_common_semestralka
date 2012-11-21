package cz.cvut.fit.industry;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
@Ignore
public class LdapConnectorTest {
	private String hostName="fit.cvut.cz";
	
	
	
	@Test
	public void testGetUser() {
		LdapConnector connector = new LdapConnectorImpl();
		connector.initialize(hostName);
		// this test is portable and eternal :)
		LdapUser david = connector.getUser("veselda7");	
		/*
		System.out.println(david.getEmail());
		System.out.println(david.getGivenName());
		System.out.println(david.getSurname());
		System.out.println(david.getuID());
		System.out.println(david.getCommonName());
		*/
		assertEquals("veselda7@fit.cvut.cz", david.getEmail());
		assertEquals("David", david.getGivenName());
		assertEquals("Vesel�", david.getSurname());
		assertEquals("veselda7", david.getuID());
		assertEquals("David Vesel�", david.getCommonName());

	}
	
	@Test(expected = UserNotFoundException.class)
	public void testGetUserNotFoundException(){
		LdapConnector connector = new LdapConnectorImpl();
		connector.initialize("fit.cvut.cz");
		connector.getUser("takovetoIdBytamBytinemelo65464654JenProSicher");
		
	}
	
	@Test	
	public void testGetGroup(){
		LdapConnector connector = new LdapConnectorImpl();
		connector.initialize(hostName);
		LdapUser david= new LdapUser();
		david.setCommonName("David Vesel�");
		david.setEmail("veselda7@fit.cvut.cz");
		david.setGivenName("David");
		david.setSurname("Vesel�");
		david.setuID("veselda7");
		List<LdapUser> usersInGroup = connector.getUsersInGroup("guvnor");	
		assertNotNull(usersInGroup);
		assertTrue(usersInGroup.contains(david));
		
	}
	

}
