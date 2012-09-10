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

	//bi-directional many-to-one association to Task
	@ManyToMany
	@JoinTable(
			name = "Task_TaskState",
			joinColumns = @JoinColumn(name = "taskStateID"),
			inverseJoinColumns = @JoinColumn(name = "taskID")
			)
	private List<Task> tasks;

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

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}