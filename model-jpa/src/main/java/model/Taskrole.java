package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the taskrole database table.
 * 
 */
@Entity
public class Taskrole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer taskroleid;

	private String name;

	//bi-directional many-to-one association to AppuserTaskrole
	@OneToMany(mappedBy="taskrole")
	private List<AppuserTaskrole> appuserTaskroles;

	//bi-directional many-to-one association to TaskTaskrole
	@OneToMany(mappedBy="taskrole")
	private List<TaskTaskrole> taskTaskroles;

	public Taskrole() {
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

	public List<AppuserTaskrole> getAppuserTaskroles() {
		return this.appuserTaskroles;
	}

	public void setAppuserTaskroles(List<AppuserTaskrole> appuserTaskroles) {
		this.appuserTaskroles = appuserTaskroles;
	}

	public List<TaskTaskrole> getTaskTaskroles() {
		return this.taskTaskroles;
	}

	public void setTaskTaskroles(List<TaskTaskrole> taskTaskroles) {
		this.taskTaskroles = taskTaskroles;
	}

}