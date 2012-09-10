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
	private Integer studyProgramID;

	private String description;

	private String name;

	//bi-directional many-to-many association to Institution
	@ManyToMany(mappedBy="studyPrograms")
	private List<Institution> institutions;

	//bi-directional many-to-one association to AppUser
	@ManyToOne
	@JoinColumn(name="userid")
	private AppUser appUser;

	//bi-directional many-to-one association to Subject
	@ManyToMany
	@JoinTable(
			name = "Subject_StudyProgram",
			joinColumns = @JoinColumn(name = "studyProgramID"),
			inverseJoinColumns = @JoinColumn(name = "subjectID")
			)
	private List<Subject> subjects;

	public StudyProgram() {
	}

	public Integer getStudyProgramID() {
		return this.studyProgramID;
	}

	public void setStudyProgramID(Integer studyProgramID) {
		this.studyProgramID = studyProgramID;
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

	public AppUser getAppUser() {
		return this.appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public List<Subject> getSubjects() {
		return this.subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

}