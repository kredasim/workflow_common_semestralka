package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the institution_address database table.
 * 
 */
@Entity
@Table(name="institution_address")
public class InstitutionAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="institution_addressid")
	private Integer institutionAddressid;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="addressid")
	private Address address;

	//bi-directional many-to-one association to Institution
	@ManyToOne
	@JoinColumn(name="institutionid")
	private Institution institution;

	public InstitutionAddress() {
	}

	public Integer getInstitutionAddressid() {
		return this.institutionAddressid;
	}

	public void setInstitutionAddressid(Integer institutionAddressid) {
		this.institutionAddressid = institutionAddressid;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

}