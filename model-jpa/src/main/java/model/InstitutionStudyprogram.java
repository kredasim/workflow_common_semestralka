package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the institution_studyprogram database table.
 * 
 */
@Entity
@Table(name="institution_studyprogram")
public class InstitutionStudyProgram implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="institution_studyprogramid")
	private Integer institutionStudyprogramid;

	//bi-directional many-to-one association to Institution
	@ManyToOne
	@JoinColumn(name="institutionid")
	private Institution institution;

	//bi-directional many-to-one association to StudyProgram
	@ManyToOne
	@JoinColumn(name="studyprogramid")
	private StudyProgram studyProgram;

	public InstitutionStudyProgram() {
	}

	public Integer getInstitutionStudyprogramid() {
		return this.institutionStudyprogramid;
	}

	public void setInstitutionStudyprogramid(Integer institutionStudyprogramid) {
		this.institutionStudyprogramid = institutionStudyprogramid;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public StudyProgram getStudyprogram() {
		return this.studyProgram;
	}

	public void setStudyprogram(StudyProgram studyProgram) {
		this.studyProgram = studyProgram;
	}

}