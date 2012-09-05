package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer roleid;

	private String description;

	private String name;

	//bi-directional many-to-many association to Appuser
	@ManyToMany(mappedBy="roles")
	private List<AppUser> appUsers;

	public Role() {
	}

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
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

	public List<AppUser> getAppusers() {
		return this.appUsers;
	}

	public void setAppusers(List<AppUser> appUsers) {
		this.appUsers = appUsers;
	}

}