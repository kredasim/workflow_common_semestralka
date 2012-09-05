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

	//bi-directional many-to-one association to AppUserContact
	@OneToMany(mappedBy="contact")
	private List<AppUserContact> appUserContacts;

	//bi-directional many-to-one association to ContactType
	@ManyToOne
	@JoinColumn(name="contacttypeid")
	private ContactType contactType;

	//bi-directional many-to-one association to InstitutionContact
	@OneToMany(mappedBy="contact")
	private List<InstitutionContact> institutionContacts;

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

	public List<AppUserContact> getAppuserContacts() {
		return this.appUserContacts;
	}

	public void setAppuserContacts(List<AppUserContact> appUserContacts) {
		this.appUserContacts = appUserContacts;
	}

	public ContactType getContacttype() {
		return this.contactType;
	}

	public void setContacttype(ContactType contactType) {
		this.contactType = contactType;
	}

	public List<InstitutionContact> getInstitutionContacts() {
		return this.institutionContacts;
	}

	public void setInstitutionContacts(List<InstitutionContact> institutionContacts) {
		this.institutionContacts = institutionContacts;
	}

}