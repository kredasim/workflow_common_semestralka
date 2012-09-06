package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.*;


/**
 * The persistent class for the taskSolution database table.
 * 
 */
@Entity
@Table(name="task_solution")
public class TaskSolution implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer taskSolutionID;
    private String description;
    private Timestamp timeStamp;
	
	//bi-directional many-to-one association to Task
	@ManyToOne()
	@JoinTable(
			name = "Task_Solution",
			joinColumns = @JoinColumn(name = "TaskSolutionID"),
			inverseJoinColumns = @JoinColumn(name = "TaskID")
			)
	private Task task;


	//bi-directional many-to-one association to TaskSolution
	@OneToMany
	@JoinColumn(name="taskSolutionID")
	private Set<TaskSolutionAcceptance> taskSolutionAcceptances;

	public TaskSolution() {
	}

	public Integer getTaskSolutionid() {
		return this.taskSolutionID;
	}

	public void setTaskSolutionid(Integer taskSolutionid) {
		this.taskSolutionID = taskSolutionid;
	}

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Set<TaskSolutionAcceptance> getTasksolutionAcceptances() {
		return this.taskSolutionAcceptances;
	}

	public void setTaskSolutionAcceptances(Set<TaskSolutionAcceptance> taskSolutionAcceptances) {
		this.taskSolutionAcceptances = taskSolutionAcceptances;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

}