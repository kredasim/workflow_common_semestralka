package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the task_solution database table.
 * 
 */
@Entity
@Table(name="task_solution")
public class TaskSolution implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="task_solutionid")
	private Integer taskSolutionid;

	//bi-directional many-to-one association to Task
	@ManyToOne
	@JoinColumn(name="taskid")
	private Task task;

	//bi-directional many-to-one association to Tasksolution
	@ManyToOne
	@JoinColumn(name="tasksolutionid")
	private TaskSolution tasksolution;

	public TaskSolution() {
	}

	public Integer getTaskSolutionid() {
		return this.taskSolutionid;
	}

	public void setTaskSolutionid(Integer taskSolutionid) {
		this.taskSolutionid = taskSolutionid;
	}

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public TaskSolution getTasksolution() {
		return this.tasksolution;
	}

	public void setTaskSolution(TaskSolution tasksolution) {
		this.tasksolution = tasksolution;
	}

}