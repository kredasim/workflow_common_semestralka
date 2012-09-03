package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the appuser database table.
 * 
 */
@Entity
public class Appuser implements Serializable {
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

	//bi-directional many-to-one association to AppuserContact
	@OneToMany(mappedBy="appuser")
	private List<AppuserContact> appuserContacts;

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

	//bi-directional many-to-one association to AppuserTaskrole
	@OneToMany(mappedBy="appuser")
	private List<AppuserTaskrole> appuserTaskroles;

	//bi-directional many-to-one association to StudentSubject
	@OneToMany(mappedBy="appuser")
	private List<StudentSubject> studentSubjects;

	//bi-directional many-to-one association to Studyprogram
	@OneToMany(mappedBy="appuser")
	private List<Studyprogram> studyprograms;

	//bi-directional many-to-one association to Task
	@OneToMany(mappedBy="appuser")
	private List<Task> tasks;

	//bi-directional many-to-one association to TeacherSubject
	@OneToMany(mappedBy="appuser")
	private List<TeacherSubject> teacherSubjects;

	public Appuser() {
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

	public List<AppuserContact> getAppuserContacts() {
		return this.appuserContacts;
	}

	public void setAppuserContacts(List<AppuserContact> appuserContacts) {
		this.appuserContacts = appuserContacts;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<AppuserTaskrole> getAppuserTaskroles() {
		return this.appuserTaskroles;
	}

	public void setAppuserTaskroles(List<AppuserTaskrole> appuserTaskroles) {
		this.appuserTaskroles = appuserTaskroles;
	}

	public List<StudentSubject> getStudentSubjects() {
		return this.studentSubjects;
	}

	public void setStudentSubjects(List<StudentSubject> studentSubjects) {
		this.studentSubjects = studentSubjects;
	}

	public List<Studyprogram> getStudyprograms() {
		return this.studyprograms;
	}

	public void setStudyprograms(List<Studyprogram> studyprograms) {
		this.studyprograms = studyprograms;
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