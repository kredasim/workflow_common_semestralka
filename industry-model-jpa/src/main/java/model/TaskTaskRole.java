package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the task_TaskRole database table.
 * 
 */
@Entity
@Table(name="task_TaskRole")
public class TaskTaskRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="task_TaskRoleID")
	private Integer taskTaskRoleID;

	private String comment;

	private float hoursEstimated;

	//bi-directional many-to-one association to Task
	@ManyToOne
	@JoinColumn(name="taskID")
	private Task task;

	//bi-directional many-to-one association to TaskRole
	@ManyToOne
	@JoinColumn(name="taskRoleID")
	private TaskRole taskRole;

	public TaskTaskRole() {
	}

	public Integer getTaskTaskRoleID() {
		return this.taskTaskRoleID;
	}

	public void setTaskTaskRoleID(Integer taskTaskRoleID) {
		this.taskTaskRoleID = taskTaskRoleID;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public float getHoursEstimated() {
		return this.hoursEstimated;
	}

	public void setHoursEstimated(float hoursEstimated) {
		this.hoursEstimated = hoursEstimated;
	}

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public TaskRole getTaskRole() {
		return this.taskRole;
	}

	public void setTaskRole(TaskRole taskRole) {
		this.taskRole = taskRole;
	}

}