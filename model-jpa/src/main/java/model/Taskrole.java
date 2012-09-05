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
	private Integer taskroleid;

	private String name;

	//bi-directional many-to-one association to AppUserTaskrole
	@OneToMany(mappedBy="taskRole")
	private List<AppUserTaskrole> appUserTaskroles;

	//bi-directional many-to-one association to TaskTaskRole
	@OneToMany(mappedBy="taskRole")
	private List<TaskTaskRole> taskTaskRoles;

	public TaskRole() {
	}

	public Integer getTaskroleid() {
		return this.taskroleid;
	}

	public void setTaskroleid(Integer taskroleid) {
		this.taskroleid = taskroleid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AppUserTaskrole> getAppuserTaskroles() {
		return this.appUserTaskroles;
	}

	public void setAppuserTaskroles(List<AppUserTaskrole> appUserTaskroles) {
		this.appUserTaskroles = appUserTaskroles;
	}

	public List<TaskTaskRole> getTaskTaskroles() {
		return this.taskTaskRoles;
	}

	public void setTaskTaskroles(List<TaskTaskRole> taskTaskRoles) {
		this.taskTaskRoles = taskTaskRoles;
	}

}