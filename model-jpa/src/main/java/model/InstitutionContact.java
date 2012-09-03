package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the institution_contact database table.
 * 
 */
@Entity
@Table(name="institution_contact")
public class InstitutionContact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="institution_contactid")
	private Integer institutionContactid;

	//bi-directional many-to-one association to Contact
	@ManyToOne
	@JoinColumn(name="contactid")
	private Contact contact;

	//bi-directional many-to-one association to Institution
	@ManyToOne
	@JoinColumn(name="institutionid")
	private Institution institution;

	public InstitutionContact() {
	}

	public Integer getInstitutionContactid() {
		return this.institutionContactid;
	}

	public void setInstitutionContactid(Integer institutionContactid) {
		this.institutionContactid = institutionContactid;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

}