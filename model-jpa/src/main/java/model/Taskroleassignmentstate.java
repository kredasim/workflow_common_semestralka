package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the taskRoleAssignmentState database table.
 * 
 */
@Entity
public class TaskRoleAssignmentState implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer taskroleassignmentstateid;

	private String name;

	//bi-directional many-to-one association to AppUserTaskrole
	@OneToMany(mappedBy="taskRoleAssignmentState")
	private List<AppUserTaskRole> appUserTaskRoles;

	public TaskRoleAssignmentState() {
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

	public List<AppUserTaskRole> getAppuserTaskRoles() {
		return this.appUserTaskRoles;
	}

	public void setAppuserTaskRoles(List<AppUserTaskRole> appUserTaskRoles) {
		this.appUserTaskRoles = appUserTaskRoles;
	}

}