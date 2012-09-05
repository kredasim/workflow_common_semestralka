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

	//bi-directional many-to-one association to Appuser
	@OneToMany(mappedBy="institution")
	private List<AppUser> appUsers;

	//bi-directional many-to-one association to InstitutionType
	@ManyToOne
	@JoinColumn(name="institutiontypeid")
	private InstitutionType institutionType;

	//bi-directional many-to-one association to InstitutionAddress
	@OneToMany(mappedBy="institution")
	private List<InstitutionAddress> institutionAddresses;

	//bi-directional many-to-one association to InstitutionContact
	@OneToMany(mappedBy="institution")
	private List<InstitutionContact> institutionContacts;

	//bi-directional many-to-one association to InstitutionFieldOfActivity
	@OneToMany(mappedBy="institution")
	private List<InstitutionFieldOfActivity> institutionFieldOfActivities;

	//bi-directional many-to-one association to InstitutionStudyProgram
	@OneToMany(mappedBy="institution")
	private List<InstitutionStudyProgram> institutionStudyPrograms;

	//bi-directional many-to-one association to InstitutionSubject
	@OneToMany(mappedBy="institution")
	private List<InstitutionSubject> institutionSubjects;

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

	public List<AppUser> getAppusers() {
		return this.appUsers;
	}

	public void setAppusers(List<AppUser> appUsers) {
		this.appUsers = appUsers;
	}

	public InstitutionType getInstitutiontype() {
		return this.institutionType;
	}

	public void setInstitutiontype(InstitutionType institutionType) {
		this.institutionType = institutionType;
	}

	public List<InstitutionAddress> getInstitutionAddresses() {
		return this.institutionAddresses;
	}

	public void setInstitutionAddresses(List<InstitutionAddress> institutionAddresses) {
		this.institutionAddresses = institutionAddresses;
	}

	public List<InstitutionContact> getInstitutionContacts() {
		return this.institutionContacts;
	}

	public void setInstitutionContacts(List<InstitutionContact> institutionContacts) {
		this.institutionContacts = institutionContacts;
	}

	public List<InstitutionFieldOfActivity> getInstitutionFieldofactivities() {
		return this.institutionFieldOfActivities;
	}

	public void setInstitutionFieldofactivities(List<InstitutionFieldOfActivity> institutionFieldOfActivities) {
		this.institutionFieldOfActivities = institutionFieldOfActivities;
	}

	public List<InstitutionStudyProgram> getInstitutionStudyprograms() {
		return this.institutionStudyPrograms;
	}

	public void setInstitutionStudyprograms(List<InstitutionStudyProgram> institutionStudyPrograms) {
		this.institutionStudyPrograms = institutionStudyPrograms;
	}

	public List<InstitutionSubject> getInstitutionSubjects() {
		return this.institutionSubjects;
	}

	public void setInstitutionSubjects(List<InstitutionSubject> institutionSubjects) {
		this.institutionSubjects = institutionSubjects;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}