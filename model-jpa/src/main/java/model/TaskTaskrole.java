package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the task_taskrole database table.
 * 
 */
@Entity
@Table(name="task_taskrole")
public class TaskTaskrole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="task_taskroleid")
	private Integer taskTaskroleid;

	private String comment;

	private float hoursestimated;

	//bi-directional many-to-one association to Task
	@ManyToOne
	@JoinColumn(name="taskid")
	private Task task;

	//bi-directional many-to-one association to Taskrole
	@ManyToOne
	@JoinColumn(name="taskroleid")
	private Taskrole taskrole;

	public TaskTaskrole() {
	}

	public Integer getTaskTaskroleid() {
		return this.taskTaskroleid;
	}

	public void setTaskTaskroleid(Integer taskTaskroleid) {
		this.taskTaskroleid = taskTaskroleid;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public float getHoursestimated() {
		return this.hoursestimated;
	}

	public void setHoursestimated(float hoursestimated) {
		this.hoursestimated = hoursestimated;
	}

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Taskrole getTaskrole() {
		return this.taskrole;
	}

	public void setTaskrole(Taskrole taskrole) {
		this.taskrole = taskrole;
	}

}