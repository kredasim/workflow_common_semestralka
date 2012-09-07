package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tasksolutionacceptance database table.
 * 
 */
@Entity
public class TaskSolutionAcceptance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tasksolutionacceptanceid;

	private String comment;

	//bi-directional many-to-one association to AcceptanceResult
	@ManyToOne
	@JoinColumn(name="acceptanceresultid")
	private AcceptanceResult acceptanceResult;

	//bi-directional many-to-one association to TaskSolution
	@ManyToOne
	@JoinColumn(name="tasksolutionid")
	private TaskSolution tasksolution;

	public TaskSolutionAcceptance() {
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

	public AcceptanceResult getAcceptanceresult() {
		return this.acceptanceResult;
	}

	public void setAcceptanceresult(AcceptanceResult acceptanceResult) {
		this.acceptanceResult = acceptanceResult;
	}

	public TaskSolution getTasksolution() {
		return this.tasksolution;
	}

	public void setTasksolution(TaskSolution tasksolution) {
		this.tasksolution = tasksolution;
	}

}