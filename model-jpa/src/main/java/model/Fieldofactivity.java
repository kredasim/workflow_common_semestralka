package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the fieldOfActivity database table.
 * 
 */
@Entity
public class FieldOfActivity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer fieldOfActivityID;

	private String ident;

	private String name;

	//bi-directional many-to-one association to InstitutionFieldOfActivity
	@ManyToMany(mappedBy="fieldOfActivities")
	private List<Institution> institutions;

	public FieldOfActivity() {
	}

	public Integer getFieldOfActivityID() {
		return this.fieldOfActivityID;
	}

	public void setFieldOfActivityID(Integer fieldOfActivityId) {
		this.fieldOfActivityID = fieldOfActivityId;
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

	public List<Institution> getInstitution() {
		return this.institutions;
	}

	public void setInstitutions(List<Institution> institutions) {
		this.institutions = institutions;
	}

}