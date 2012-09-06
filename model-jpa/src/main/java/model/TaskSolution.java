package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

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
	@ManyToMany(mappedBy = "taskSolutions")
	private List<Task> tasks;


	//bi-directional many-to-one association to TaskSolutionAcceptance
	@OneToMany
	@JoinColumn(name="taskSolutionID")
	private List<TaskSolutionAcceptance> taskSolutionAcceptances;

	public TaskSolution() {
	}

	public Integer getTaskSolutionid() {
		return this.taskSolutionID;
	}

	public void setTaskSolutionid(Integer taskSolutionid) {
		this.taskSolutionID = taskSolutionid;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<TaskSolutionAcceptance> getTasksolutionAcceptances() {
		return this.taskSolutionAcceptances;
	}

	public void setTaskSolutionAcceptances(List<TaskSolutionAcceptance> taskSolutionAcceptances) {
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