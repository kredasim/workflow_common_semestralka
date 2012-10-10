package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the contactType database table.
 * 
 */
@Entity
public class ContactType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer contactTypeID;

	private String name;

	//bi-directional many-to-one association to Contact
	@OneToMany(mappedBy="contactType")
	private List<Contact> contacts;

	public ContactType() {
	}

	public Integer getContactTypeID() {
		return this.contactTypeID;
	}

	public void setContactTypeID(Integer contactTypeID) {
		this.contactTypeID = contactTypeID;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

}