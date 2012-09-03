package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the institution_subject database table.
 * 
 */
@Entity
@Table(name="institution_subject")
public class InstitutionSubject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="institution_subjectid")
	private Integer institutionSubjectid;

	//bi-directional many-to-one association to Institution
	@ManyToOne
	@JoinColumn(name="institutionid")
	private Institution institution;

	//bi-directional many-to-one association to Subject
	@ManyToOne
	@JoinColumn(name="subjectid")
	private Subject subject;

	public InstitutionSubject() {
	}

	public Integer getInstitutionSubjectid() {
		return this.institutionSubjectid;
	}

	public void setInstitutionSubjectid(Integer institutionSubjectid) {
		this.institutionSubjectid = institutionSubjectid;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}