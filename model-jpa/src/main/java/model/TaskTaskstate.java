package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the task_taskstate database table.
 * 
 */
@Entity
@Table(name="task_taskstate")
public class TaskTaskstate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="task_taskstateid")
	private Integer taskTaskstateid;

	private String comment;

	private Timestamp inserttimestamp;

	//bi-directional many-to-one association to Task
	@ManyToOne
	@JoinColumn(name="taskid")
	private Task task;

	//bi-directional many-to-one association to Taskstate
	@ManyToOne
	@JoinColumn(name="taskstateid")
	private Taskstate taskstate;

	public TaskTaskstate() {
	}

	public Integer getTaskTaskstateid() {
		return this.taskTaskstateid;
	}

	public void setTaskTaskstateid(Integer taskTaskstateid) {
		this.taskTaskstateid = taskTaskstateid;
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

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Taskstate getTaskstate() {
		return this.taskstate;
	}

	public void setTaskstate(Taskstate taskstate) {
		this.taskstate = taskstate;
	}

}