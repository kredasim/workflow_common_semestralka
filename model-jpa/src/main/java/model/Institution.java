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
	private List<Appuser> appusers;

	//bi-directional many-to-one association to Institutiontype
	@ManyToOne
	@JoinColumn(name="institutiontypeid")
	private Institutiontype institutiontype;

	//bi-directional many-to-one association to InstitutionAddress
	@OneToMany(mappedBy="institution")
	private List<InstitutionAddress> institutionAddresses;

	//bi-directional many-to-one association to InstitutionContact
	@OneToMany(mappedBy="institution")
	private List<InstitutionContact> institutionContacts;

	//bi-directional many-to-one association to InstitutionFieldofactivity
	@OneToMany(mappedBy="institution")
	private List<InstitutionFieldofactivity> institutionFieldofactivities;

	//bi-directional many-to-one association to InstitutionStudyprogram
	@OneToMany(mappedBy="institution")
	private List<InstitutionStudyprogram> institutionStudyprograms;

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

	public List<Appuser> getAppusers() {
		return this.appusers;
	}

	public void setAppusers(List<Appuser> appusers) {
		this.appusers = appusers;
	}

	public Institutiontype getInstitutiontype() {
		return this.institutiontype;
	}

	public void setInstitutiontype(Institutiontype institutiontype) {
		this.institutiontype = institutiontype;
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

	public List<InstitutionFieldofactivity> getInstitutionFieldofactivities() {
		return this.institutionFieldofactivities;
	}

	public void setInstitutionFieldofactivities(List<InstitutionFieldofactivity> institutionFieldofactivities) {
		this.institutionFieldofactivities = institutionFieldofactivities;
	}

	public List<InstitutionStudyprogram> getInstitutionStudyprograms() {
		return this.institutionStudyprograms;
	}

	public void setInstitutionStudyprograms(List<InstitutionStudyprogram> institutionStudyprograms) {
		this.institutionStudyprograms = institutionStudyprograms;
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