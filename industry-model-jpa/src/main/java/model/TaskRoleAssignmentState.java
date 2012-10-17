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
	private Integer taskRoleAssignmentStateID;

	private String name;

	//bi-directional many-to-one association to AppUserTaskRole
	@OneToMany(mappedBy="taskRoleAssignmentState")
	private List<AppUserTaskRole> appUserTaskRoles;

	public TaskRoleAssignmentState() {
	}

	public Integer getTaskroleAssignmentStateID() {
		return this.taskRoleAssignmentStateID;
	}

	public void setTaskRoleAssignmentStateID(Integer taskRoleAssignmentStateID) {
		this.taskRoleAssignmentStateID = taskRoleAssignmentStateID;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AppUserTaskRole> getAppUserTaskRoles() {
		return this.appUserTaskRoles;
	}

	public void setAppUserTaskRoles(List<AppUserTaskRole> appUserTaskRoles) {
		this.appUserTaskRoles = appUserTaskRoles;
	}

}