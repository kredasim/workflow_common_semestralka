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
public class TaskTaskState implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="task_TaskStateID")
	private Integer taskTaskStateID;

	private String comment;

	private Timestamp insertTimestamp;

	//bi-directional many-to-one association to Task
	@ManyToOne
	@JoinColumn(name="taskID")
	private Task task;

	//bi-directional many-to-one association to TaskState
	@ManyToOne
	@JoinColumn(name="taskStateID")
	private TaskState taskState;

	public TaskTaskState() {
	}

	public Integer getTaskTaskStateID() {
		return this.taskTaskStateID;
	}

	public void setTaskTaskStateID(Integer taskTaskStateID) {
		this.taskTaskStateID = taskTaskStateID;
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

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public TaskState getTaskState() {
		return this.taskState;
	}

	public void setTaskState(TaskState taskState) {
		this.taskState = taskState;
	}

}