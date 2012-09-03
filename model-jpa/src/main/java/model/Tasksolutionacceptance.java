package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tasksolutionacceptance database table.
 * 
 */
@Entity
public class Tasksolutionacceptance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tasksolutionacceptanceid;

	private String comment;

	//bi-directional many-to-one association to Acceptanceresult
	@ManyToOne
	@JoinColumn(name="acceptanceresultid")
	private Acceptanceresult acceptanceresult;

	//bi-directional many-to-one association to Tasksolution
	@ManyToOne
	@JoinColumn(name="tasksolutionid")
	private TaskSolution tasksolution;

	public Tasksolutionacceptance() {
	}

	public Integer getTasksolutionacceptanceid() {
		return this.tasksolutionacceptanceid;
	}

	public void setTasksolutionacceptanceid(Integer tasksolutionacceptanceid) {
		this.tasksolutionacceptanceid = tasksolutionacceptanceid;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Acceptanceresult getAcceptanceresult() {
		return this.acceptanceresult;
	}

	public void setAcceptanceresult(Acceptanceresult acceptanceresult) {
		this.acceptanceresult = acceptanceresult;
	}

	public TaskSolution getTasksolution() {
		return this.tasksolution;
	}

	public void setTasksolution(TaskSolution tasksolution) {
		this.tasksolution = tasksolution;
	}

}