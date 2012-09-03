package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the institution_fieldofactivity database table.
 * 
 */
@Entity
@Table(name="institution_fieldofactivity")
public class InstitutionFieldofactivity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="institution_fieldofactivityid")
	private Integer institutionFieldofactivityid;

	//bi-directional many-to-one association to Fieldofactivity
	@ManyToOne
	@JoinColumn(name="fieldofactivityid")
	private Fieldofactivity fieldofactivity;

	//bi-directional many-to-one association to Institution
	@ManyToOne
	@JoinColumn(name="institutionid")
	private Institution institution;

	public InstitutionFieldofactivity() {
	}

	public Integer getInstitutionFieldofactivityid() {
		return this.institutionFieldofactivityid;
	}

	public void setInstitutionFieldofactivityid(Integer institutionFieldofactivityid) {
		this.institutionFieldofactivityid = institutionFieldofactivityid;
	}

	public Fieldofactivity getFieldofactivity() {
		return this.fieldofactivity;
	}

	public void setFieldofactivity(Fieldofactivity fieldofactivity) {
		this.fieldofactivity = fieldofactivity;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

}