package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the taskState database table.
 * 
 */
@Entity
public class TaskState implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer taskStateID;

	private String name;

	//bi-directional many-to-one association to Task_TaskState
	@OneToMany
	private List<TaskTaskState> tasksTaskState;

	public TaskState() {
	}

	public Integer getTaskStateID() {
		return this.taskStateID;
	}

	public void setTaskStateID(Integer taskStateID) {
		this.taskStateID = taskStateID;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TaskTaskState> getTaskTaskStates() {
		return this.tasksTaskState;
	}

	public void setTaskTaskStates(List<TaskTaskState> taskTaskStates) {
		this.tasksTaskState = taskTaskStates;
	}

}