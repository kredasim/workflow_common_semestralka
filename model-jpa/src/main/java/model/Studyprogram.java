package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the studyProgram database table.
 * 
 */
@Entity
public class StudyProgram implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer studyprogramid;

	private String description;

	private String name;

	//bi-directional many-to-one association to InstitutionStudyProgram
	@OneToMany(mappedBy="studyProgram")
	private List<InstitutionStudyProgram> institutionStudyPrograms;

	//bi-directional many-to-one association to Appuser
	@ManyToOne
	@JoinColumn(name="userid")
	private AppUser appUser;

	//bi-directional many-to-one association to SubjectStudyProgram
	@OneToMany(mappedBy="studyProgram")
	private List<SubjectStudyProgram> subjectStudyPrograms;

	public StudyProgram() {
	}

	public Integer getStudyprogramid() {
		return this.studyprogramid;
	}

	public void setStudyprogramid(Integer studyprogramid) {
		this.studyprogramid = studyprogramid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<InstitutionStudyProgram> getInstitutionStudyprograms() {
		return this.institutionStudyPrograms;
	}

	public void setInstitutionStudyprograms(List<InstitutionStudyProgram> institutionStudyPrograms) {
		this.institutionStudyPrograms = institutionStudyPrograms;
	}

	public AppUser getAppuser() {
		return this.appUser;
	}

	public void setAppuser(AppUser appUser) {
		this.appUser = appUser;
	}

	public List<SubjectStudyProgram> getSubjectStudyprograms() {
		return this.subjectStudyPrograms;
	}

	public void setSubjectStudyprograms(List<SubjectStudyProgram> subjectStudyPrograms) {
		this.subjectStudyPrograms = subjectStudyPrograms;
	}

}