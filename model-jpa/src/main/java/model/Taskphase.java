package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the taskphase database table.
 * 
 */
@Entity
public class TaskPhase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer taskphaseid;

	private Boolean accomplished;

	private Timestamp deadline;

	private String description;

	private String name;

	private String requirements;

	//bi-directional many-to-one association to Task
	@ManyToOne
	@JoinColumn(name="taskid")
	private Task task;

	public TaskPhase() {
	}

	public Integer getTaskphaseid() {
		return this.taskphaseid;
	}

	public void setTaskphaseid(Integer taskphaseid) {
		this.taskphaseid = taskphaseid;
	}

	public Boolean getAccomplished() {
		return this.accomplished;
	}

	public void setAccomplished(Boolean accomplished) {
		this.accomplished = accomplished;
	}

	public Timestamp getDeadline() {
		return this.deadline;
	}

	public void setDeadline(Timestamp deadline) {
		this.deadline = deadline;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRequirements() {
		return this.requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

}