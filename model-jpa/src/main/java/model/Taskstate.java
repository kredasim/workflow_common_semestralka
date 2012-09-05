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
	private Integer taskstateid;

	private String name;

	//bi-directional many-to-one association to TaskTaskState
	@OneToMany(mappedBy="taskState")
	private List<TaskTaskState> taskTaskStates;

	public TaskState() {
	}

	public Integer getTaskstateid() {
		return this.taskstateid;
	}

	public void setTaskstateid(Integer taskstateid) {
		this.taskstateid = taskstateid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TaskTaskState> getTaskTaskStates() {
		return this.taskTaskStates;
	}

	public void setTaskTaskStates(List<TaskTaskState> taskTaskStates) {
		this.taskTaskStates = taskTaskStates;
	}

}