package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the appuser_taskrole database table.
 * 
 */
@Entity
@Table(name="appuser_taskrole")
public class AppUserTaskrole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_taskroleid")
	private Integer userTaskroleid;

	private String comment;

	private Timestamp inserttimestamp;

	//bi-directional many-to-one association to Appuser
	@ManyToOne
	@JoinColumn(name="appuserid")
	private AppUser appUser;

	//bi-directional many-to-one association to TaskRole
	@ManyToOne
	@JoinColumn(name="taskroleid")
	private TaskRole taskRole;

	//bi-directional many-to-one association to TaskRoleAssignmentState
	@ManyToOne
	@JoinColumn(name="taskroleassignmentstateid")
	private TaskRoleAssignmentState taskRoleAssignmentState;

	public AppUserTaskrole() {
	}

	public Integer getUserTaskroleid() {
		return this.userTaskroleid;
	}

	public void setUserTaskroleid(Integer userTaskroleid) {
		this.userTaskroleid = userTaskroleid;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getInserttimestamp() {
		return this.inserttimestamp;
	}

	public void setInserttimestamp(Timestamp inserttimestamp) {
		this.inserttimestamp = inserttimestamp;
	}

	public AppUser getAppuser() {
		return this.appUser;
	}

	public void setAppuser(AppUser appUser) {
		this.appUser = appUser;
	}

	public TaskRole getTaskrole() {
		return this.taskRole;
	}

	public void setTaskrole(TaskRole taskRole) {
		this.taskRole = taskRole;
	}

	public TaskRoleAssignmentState getTaskroleassignmentstate() {
		return this.taskRoleAssignmentState;
	}

	public void setTaskroleassignmentstate(TaskRoleAssignmentState taskRoleAssignmentState) {
		this.taskRoleAssignmentState = taskRoleAssignmentState;
	}

}