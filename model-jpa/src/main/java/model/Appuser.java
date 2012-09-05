package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the appUser database table.
 * 
 */
@Entity
public class AppUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer appuserid;

	private String firstname;

	private String middlename;

	private String surname;

	//bi-directional many-to-one association to Institution
	@ManyToOne
	@JoinColumn(name="institutionid")
	private Institution institution;

	//bi-directional many-to-one association to AppUserContact
	@OneToMany(mappedBy="appUser")
	private List<AppUserContact> appUserContacts;

	//bi-directional many-to-many association to Role
	@ManyToMany
	@JoinTable(
		name="appuser_role"
		, joinColumns={
			@JoinColumn(name="appuserid")
			}
		, inverseJoinColumns={
			@JoinColumn(name="roleid")
			}
		)
	private List<Role> roles;

	//bi-directional many-to-one association to AppUserTaskrole
	@OneToMany(mappedBy="appUser")
	private List<AppUserTaskrole> appUserTaskroles;

	//bi-directional many-to-one association to StudentSubject
	@OneToMany(mappedBy="appUser")
	private List<StudentSubject> studentSubjects;

	//bi-directional many-to-one association to StudyProgram
	@OneToMany(mappedBy="appUser")
	private List<StudyProgram> studyPrograms;

	//bi-directional many-to-one association to Task
	@OneToMany(mappedBy="appUser")
	private List<Task> tasks;

	//bi-directional many-to-one association to TeacherSubject
	@OneToMany(mappedBy="appUser")
	private List<TeacherSubject> teacherSubjects;

	public AppUser() {
	}

	public Integer getAppuserid() {
		return this.appuserid;
	}

	public void setAppuserid(Integer appuserid) {
		this.appuserid = appuserid;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return this.middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public List<AppUserContact> getAppuserContacts() {
		return this.appUserContacts;
	}

	public void setAppuserContacts(List<AppUserContact> appUserContacts) {
		this.appUserContacts = appUserContacts;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<AppUserTaskrole> getAppuserTaskroles() {
		return this.appUserTaskroles;
	}

	public void setAppuserTaskroles(List<AppUserTaskrole> appUserTaskroles) {
		this.appUserTaskroles = appUserTaskroles;
	}

	public List<StudentSubject> getStudentSubjects() {
		return this.studentSubjects;
	}

	public void setStudentSubjects(List<StudentSubject> studentSubjects) {
		this.studentSubjects = studentSubjects;
	}

	public List<StudyProgram> getStudyprograms() {
		return this.studyPrograms;
	}

	public void setStudyprograms(List<StudyProgram> studyPrograms) {
		this.studyPrograms = studyPrograms;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<TeacherSubject> getTeacherSubjects() {
		return this.teacherSubjects;
	}

	public void setTeacherSubjects(List<TeacherSubject> teacherSubjects) {
		this.teacherSubjects = teacherSubjects;
	}

}