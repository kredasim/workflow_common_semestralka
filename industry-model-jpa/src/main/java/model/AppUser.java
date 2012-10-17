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
	private Integer appUserID;

	private String firstName;

	private String middleName;

	private String surName;

	//bi-directional many-to-one association to Institution
	@ManyToOne
	@JoinColumn(name="institutionid")
	private Institution institution;

	//bi-directional many-to-one association to AppUserContact
	@ManyToMany
	@JoinTable(
			name = "appUser_Contacts",
			joinColumns = @JoinColumn(name = "appUserID"),
			inverseJoinColumns = @JoinColumn(name = "contactID")
			)
	private List<Contact> contacts;

	//bi-directional many-to-many association to Role
	@ManyToMany
	@JoinTable(
		name="appuser_role", 
		joinColumns= @JoinColumn(name="appuserid"), 
		inverseJoinColumns=@JoinColumn(name="roleid")
		)
	private List<Role> roles;

	//bi-directional many-to-one association to AppUserTaskrole
	@OneToMany(mappedBy="appUser")
	private List<AppUserTaskRole> appUserTaskRoles;

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

	public Integer getAppUserID() {
		return this.appUserID;
	}

	public void setAppuserID(Integer appUserID) {
		this.appUserID = appUserID;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getSurName() {
		return this.surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public List<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<AppUserTaskRole> getAppUserTaskRoles() {
		return this.appUserTaskRoles;
	}

	public void setAppUserTaskRoles(List<AppUserTaskRole> appUserTaskRoles) {
		this.appUserTaskRoles = appUserTaskRoles;
	}

	public List<StudentSubject> getStudentSubjects() {
		return this.studentSubjects;
	}

	public void setStudentSubjects(List<StudentSubject> studentSubjects) {
		this.studentSubjects = studentSubjects;
	}

	public List<StudyProgram> getStudyPrograms() {
		return this.studyPrograms;
	}

	public void setStudyPrograms(List<StudyProgram> studyPrograms) {
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