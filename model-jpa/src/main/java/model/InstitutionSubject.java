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
	@Column(name="institution_SubjectID")
	private Integer institutionSubjectID;

	//bi-directional many-to-one association to Institution
	@ManyToOne
	@JoinColumn(name="institutionID")
	private Institution institution;

	//bi-directional many-to-one association to Subject
	@ManyToOne
	@JoinColumn(name="subjectID")
	private Subject subject;

	public InstitutionSubject() {
	}

	public Integer getInstitutionSubjectID() {
		return this.institutionSubjectID;
	}

	public void setInstitutionSubjectID(Integer institutionSubjectID) {
		this.institutionSubjectID = institutionSubjectID;
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