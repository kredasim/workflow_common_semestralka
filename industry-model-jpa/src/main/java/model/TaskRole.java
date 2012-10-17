package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the taskRole database table.
 * 
 */
@Entity
public class TaskRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer taskRoleID;

	private String name;

	//bi-directional many-to-one association to AppUserTaskrole
	@OneToMany(mappedBy="taskRole")
	private List<AppUserTaskRole> appUserTaskRoles;

	//bi-directional many-to-one association to TaskTaskRole
	@OneToMany(mappedBy="taskRole")
	private List<TaskTaskRole> taskTaskRoles;

	public TaskRole() {
	}

	public Integer getTaskroleID() {
		return this.taskRoleID;
	}

	public void setTaskroleID(Integer taskRoleID) {
		this.taskRoleID = taskRoleID;
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

	public List<TaskTaskRole> getTaskTaskRoles() {
		return this.taskTaskRoles;
	}

	public void setTaskTaskRoles(List<TaskTaskRole> taskTaskRoles) {
		this.taskTaskRoles = taskTaskRoles;
	}

}