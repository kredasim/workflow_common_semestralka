package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the taskroleassignmentstate database table.
 * 
 */
@Entity
public class Taskroleassignmentstate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer taskroleassignmentstateid;

	private String name;

	//bi-directional many-to-one association to AppuserTaskrole
	@OneToMany(mappedBy="taskroleassignmentstate")
	private List<AppuserTaskrole> appuserTaskroles;

	public Taskroleassignmentstate() {
	}

	public Integer getTaskroleassignmentstateid() {
		return this.taskroleassignmentstateid;
	}

	public void setTaskroleassignmentstateid(Integer taskroleassignmentstateid) {
		this.taskroleassignmentstateid = taskroleassignmentstateid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AppuserTaskrole> getAppuserTaskroles() {
		return this.appuserTaskroles;
	}

	public void setAppuserTaskroles(List<AppuserTaskrole> appuserTaskroles) {
		this.appuserTaskroles = appuserTaskroles;
	}

}