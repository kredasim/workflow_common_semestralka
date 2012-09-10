package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the contact database table.
 * 
 */
@Entity
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer contactID;

	private Timestamp insertTimestamp;

	private Boolean isPrimary;

	private String name;

	private Timestamp updateTimestamp;

	private String value;

	//bi-directional many-to-one association to AppUser
	@ManyToMany(mappedBy="contacts")
	private List<AppUser> appUsers;

	//bi-directional many-to-one association to ContactType
	@ManyToOne
	@JoinColumn(name="contacttypeid")
	private ContactType contactType;

	//bi-directional many-to-one association to Institution
	@ManyToMany(mappedBy="contacts")
	private List<Institution> institutions;

	public Contact() {
	}

	public Integer getContactid() {
		return this.contactID;
	}

	public void setContactID(Integer contactID) {
		this.contactID = contactID;
	}

	public Timestamp getInsertTimestamp() {
		return this.insertTimestamp;
	}

	public void setInsertTimestamp(Timestamp insertTimestamp) {
		this.insertTimestamp = insertTimestamp;
	}

	public Boolean getIsPrimary() {
		return this.isPrimary;
	}

	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getUpdateTimestamp() {
		return this.updateTimestamp;
	}

	public void setUpdateTimestamp(Timestamp updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<AppUser> getAppUser() {
		return this.appUsers;
	}

	public void setAppUser(List<AppUser> appUser) {
		this.appUsers = appUser;
	}

	public ContactType getContactType() {
		return this.contactType;
	}

	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}

	public List<Institution> getInstitutionContacts() {
		return this.institutions;
	}

	public void setInstitutionContacts(List<Institution> institutions) {
		this.institutions = institutions;
	}

}