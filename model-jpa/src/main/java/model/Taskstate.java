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
	@ManyToMany
	@JoinTable(
			name = "Task_TaskState",
			joinColumns = @JoinColumn(name = "taskStateID"),
			inverseJoinColumns = @JoinColumn(name = "taskID")
			)
	private List<Task> tasks;

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

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}