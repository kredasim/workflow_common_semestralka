package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the fieldofactivity database table.
 * 
 */
@Entity
public class FieldOfActivity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer fieldofactivityid;

	private String ident;

	private String name;

	//bi-directional many-to-one association to InstitutionFieldOfActivity
	@OneToMany(mappedBy="fieldOfActivity")
	private List<InstitutionFieldOfActivity> institutionFieldOfActivities;

	public FieldOfActivity() {
	}

	public Integer getFieldofactivityid() {
		return this.fieldofactivityid;
	}

	public void setFieldofactivityid(Integer fieldofactivityid) {
		this.fieldofactivityid = fieldofactivityid;
	}

	public String getIdent() {
		return this.ident;
	}

	public void setIdent(String ident) {
		this.ident = ident;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<InstitutionFieldOfActivity> getInstitutionFieldofactivities() {
		return this.institutionFieldOfActivities;
	}

	public void setInstitutionFieldofactivities(List<InstitutionFieldOfActivity> institutionFieldOfActivities) {
		this.institutionFieldOfActivities = institutionFieldOfActivities;
	}

}