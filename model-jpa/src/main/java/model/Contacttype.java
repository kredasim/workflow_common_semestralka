package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the contacttype database table.
 * 
 */
@Entity
public class Contacttype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer contacttypeid;

	private String name;

	//bi-directional many-to-one association to Contact
	@OneToMany(mappedBy="contacttype")
	private List<Contact> contacts;

	public Contacttype() {
	}

	public Integer getContacttypeid() {
		return this.contacttypeid;
	}

	public void setContacttypeid(Integer contacttypeid) {
		this.contacttypeid = contacttypeid;
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