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
	@ManyToMany(mappedBy="studyPrograms")
	private List<Institution> institutions;

	//bi-directional many-to-one association to AppUser
	@ManyToOne
	@JoinColumn(name="userid")
	private AppUser appUser;

	//bi-directional many-to-one association to SubjectStudyProgram
	@ManyToMany
	@JoinTable(
			name = "Subject_StudyProgram",
			joinColumns = @JoinColumn(name = "studyProgramId"),
			inverseJoinColumns = @JoinColumn(name = "subjectID")
			)
	private List<Subject> subjects;

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

	public List<Institution> getInstitutions() {
		return this.institutions;
	}

	public void setInstitutions(List<Institution> institutions) {
		this.institutions = institutions;
	}

	public AppUser getAppuser() {
		return this.appUser;
	}

	public void setAppuser(AppUser appUser) {
		this.appUser = appUser;
	}

	public List<Subject> getSubjects() {
		return this.subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

}