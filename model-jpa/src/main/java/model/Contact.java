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
	private Integer contactid;

	private Timestamp inserttimestamp;

	private Boolean isprimary;

	private String name;

	private Timestamp updatetimestamp;

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
		return this.contactid;
	}

	public void setContactid(Integer contactid) {
		this.contactid = contactid;
	}

	public Timestamp getInserttimestamp() {
		return this.inserttimestamp;
	}

	public void setInserttimestamp(Timestamp inserttimestamp) {
		this.inserttimestamp = inserttimestamp;
	}

	public Boolean getIsprimary() {
		return this.isprimary;
	}

	public void setIsprimary(Boolean isprimary) {
		this.isprimary = isprimary;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getUpdatetimestamp() {
		return this.updatetimestamp;
	}

	public void setUpdatetimestamp(Timestamp updatetimestamp) {
		this.updatetimestamp = updatetimestamp;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<AppUser> getAppuser() {
		return this.appUsers;
	}

	public void setAppuser(List<AppUser> appUser) {
		this.appUsers = appUser;
	}

	public ContactType getContacttype() {
		return this.contactType;
	}

	public void setContacttype(ContactType contactType) {
		this.contactType = contactType;
	}

	public List<Institution> getInstitutionContacts() {
		return this.institutions;
	}

	public void setInstitutionContacts(List<Institution> institutions) {
		this.institutions = institutions;
	}

}