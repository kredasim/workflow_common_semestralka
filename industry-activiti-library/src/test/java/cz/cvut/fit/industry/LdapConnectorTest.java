package cz.cvut.fit.industry;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

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
		assertEquals("Veselý", david.getSurname());
		assertEquals("veselda7", david.getuID());
		assertEquals("David Veselý", david.getCommonName());

	}
	
	@Test(expected = UserNotFoundException.class)
	public void testGetUserNotFoundException(){
		LdapConnector connector = new LdapConnectorImpl();
		connector.initialize("fit.cvut.cz");
		connector.getUser("takovetoIdBytamBytinemelo65464654JenProSicher");
		
	}
	
	@Test
	@Ignore
	public void testGetGroup(){
		LdapConnector connector = new LdapConnectorImpl();
		connector.initialize(hostName);
		connector.getUsersInGroup("guvnor");
		
	}
	

}
