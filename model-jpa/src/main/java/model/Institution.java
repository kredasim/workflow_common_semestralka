package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the institution database table.
 * 
 */
@Entity
public class Institution implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer institutionid;

	private String description;

	private Timestamp inserttimestamp;

	private String name;

	private Timestamp updatetimestamp;

	//bi-directional many-to-one association to AppUser
	@OneToMany(mappedBy="institution")
	private List<AppUser> appUsers;

	//bi-directional many-to-one association to InstitutionType
	@ManyToOne
	@JoinColumn(name="institutiontypeid")
	private InstitutionType institutionType;

	//bi-directional many-to-one association to InstitutionAddress
	@ManyToMany
	@JoinTable(
			name = "institution_StudyProgram",
			joinColumns = @JoinColumn(name = "institutionID"),
			inverseJoinColumns = @JoinColumn(name = "addressID")
	)
	private List<Address> addresses;

	//bi-directional many-to-one association to Contact
	@ManyToMany
	@JoinTable(
			name = "institution_StudyProgram",
			joinColumns = @JoinColumn(name = "institutionID"),
			inverseJoinColumns = @JoinColumn(name = "contactID")
	)
	private List<Contact> contacts;

	//bi-directional many-to-one association to InstitutionFieldOfActivity
	@ManyToMany
	@JoinTable(
			name = "institution_StudyProgram",
			joinColumns = @JoinColumn(name = "institutionID"),
			inverseJoinColumns = @JoinColumn(name = "fieldOfActivityID")
	)
	private List<FieldOfActivity> fieldOfActivities;

	//bi-directional many-to-one association to InstitutionStudyProgram
	@ManyToMany
	@JoinTable(
			name = "institution_StudyProgram",
			joinColumns = @JoinColumn(name = "institutionID"),
			inverseJoinColumns = @JoinColumn(name = "studyProgramID")
	)
	private List<StudyProgram> studyPrograms;

	//bi-directional many-to-one association to InstitutionSubject
	@ManyToMany
	@JoinTable(
			name = "institution_Subject",
			joinColumns = @JoinColumn(name = "institutionID"),
			inverseJoinColumns = @JoinColumn(name = "subjectID")
			)
	private List<Subject> subjects;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="institution")
	private List<Project> projects;

	public Institution() {
	}

	public Integer getInstitutionid() {
		return this.institutionid;
	}

	public void setInstitutionid(Integer institutionid) {
		this.institutionid = institutionid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getInserttimestamp() {
		return this.inserttimestamp;
	}

	public void setInserttimestamp(Timestamp inserttimestamp) {
		this.inserttimestamp = inserttimestamp;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getUpdatetimestamp() {
		return this.updatetimestamp;
	}

	public void setUpdatetimestamp(Timestamp updatetimestamp) {
		this.updatetimestamp = updatetimestamp;
	}

	public List<AppUser> getAppUsers() {
		return this.appUsers;
	}

	public void setAppUsers(List<AppUser> appUsers) {
		this.appUsers = appUsers;
	}

	public InstitutionType getInstitutionType() {
		return this.institutionType;
	}

	public void setInstitutionType(InstitutionType institutionType) {
		this.institutionType = institutionType;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(List<Contact> Contacts) {
		this.contacts = Contacts;
	}

	public List<FieldOfActivity> getFieldofActivities() {
		return this.fieldOfActivities;
	}

	public void setFieldofActivities(List<FieldOfActivity> fieldOfActivities) {
		this.fieldOfActivities = fieldOfActivities;
	}

	public List<StudyProgram> getStudyPrograms() {
		return this.studyPrograms;
	}

	public void setStudyPrograms(List<StudyProgram> studyPrograms) {
		this.studyPrograms = studyPrograms;
	}

	public List<Subject> getSubjects() {
		return this.subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}