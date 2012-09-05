package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the institution_fieldofactivity database table.
 * 
 */
@Entity
@Table(name="institution_fieldofactivity")
public class InstitutionFieldOfActivity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="institution_fieldofactivityid")
	private Integer institutionFieldofactivityid;

	//bi-directional many-to-one association to FieldOfActivity
	@ManyToOne
	@JoinColumn(name="fieldofactivityid")
	private FieldOfActivity fieldOfActivity;

	//bi-directional many-to-one association to Institution
	@ManyToOne
	@JoinColumn(name="institutionid")
	private Institution institution;

	public InstitutionFieldOfActivity() {
	}

	public Integer getInstitutionFieldofactivityid() {
		return this.institutionFieldofactivityid;
	}

	public void setInstitutionFieldofactivityid(Integer institutionFieldofactivityid) {
		this.institutionFieldofactivityid = institutionFieldofactivityid;
	}

	public FieldOfActivity getFieldofactivity() {
		return this.fieldOfActivity;
	}

	public void setFieldofactivity(FieldOfActivity fieldOfActivity) {
		this.fieldOfActivity = fieldOfActivity;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

}