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
public class AppUserTaskRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_taskroleid")
	private Integer userTaskRoleID;

	private String comment;

	private Timestamp insertTimestamp;

	//bi-directional many-to-one association to AppUser
	@ManyToOne
	@JoinColumn(name="appUserID")
	private AppUser appUser;

	//bi-directional many-to-one association to TaskRole
	@ManyToOne
	@JoinColumn(name="taskRoleID")
	private TaskRole taskRole;

	//bi-directional many-to-one association to TaskRoleAssignmentState
	@ManyToOne
	@JoinColumn(name="taskRoleAssignmentStateID")
	private TaskRoleAssignmentState taskRoleAssignmentState;

	public AppUserTaskRole() {
	}

	public Integer getUserTaskroleID() {
		return this.userTaskRoleID;
	}

	public void setUserTaskRoleID(Integer userTaskroleid) {
		this.userTaskRoleID = userTaskroleid;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getInsertTimestamp() {
		return this.insertTimestamp;
	}

	public void setInsertTimestamp(Timestamp insertTimestamp) {
		this.insertTimestamp = insertTimestamp;
	}

	public AppUser getAppUser() {
		return this.appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public TaskRole getTaskRole() {
		return this.taskRole;
	}

	public void setTaskRole(TaskRole taskRole) {
		this.taskRole = taskRole;
	}

	public TaskRoleAssignmentState getTaskRoleAssignmentState() {
		return this.taskRoleAssignmentState;
	}

	public void setTaskRoleAssignmentState(TaskRoleAssignmentState taskRoleAssignmentState) {
		this.taskRoleAssignmentState = taskRoleAssignmentState;
	}

}