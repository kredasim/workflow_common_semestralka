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
public class AppuserTaskrole implements Serializable {
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
	private Appuser appuser;

	//bi-directional many-to-one association to Taskrole
	@ManyToOne
	@JoinColumn(name="taskroleid")
	private Taskrole taskrole;

	//bi-directional many-to-one association to Taskroleassignmentstate
	@ManyToOne
	@JoinColumn(name="taskroleassignmentstateid")
	private Taskroleassignmentstate taskroleassignmentstate;

	public AppuserTaskrole() {
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

	public Appuser getAppuser() {
		return this.appuser;
	}

	public void setAppuser(Appuser appuser) {
		this.appuser = appuser;
	}

	public Taskrole getTaskrole() {
		return this.taskrole;
	}

	public void setTaskrole(Taskrole taskrole) {
		this.taskrole = taskrole;
	}

	public Taskroleassignmentstate getTaskroleassignmentstate() {
		return this.taskroleassignmentstate;
	}

	public void setTaskroleassignmentstate(Taskroleassignmentstate taskroleassignmentstate) {
		this.taskroleassignmentstate = taskroleassignmentstate;
	}

}