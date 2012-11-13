package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the institutionType database table.
 * 
 */
@Entity
public class InstitutionType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer institutionTypeID;

	private String description;
	
	private String name;

	//bi-directional many-to-one association to Institution
	@OneToMany(mappedBy="institutionType")
	private List<Institution> institutions;

	public InstitutionType() {
	}

	public Integer getInstitutionTypeID() {
		return this.institutionTypeID;
	}

	public void setInstitutionTypeID(Integer institutionTypeID) {
		this.institutionTypeID = institutionTypeID;
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

}