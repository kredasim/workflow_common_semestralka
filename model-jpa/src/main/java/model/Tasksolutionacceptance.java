package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the taskSolutionAcceptance database table.
 * 
 */
@Entity
public class TaskSolutionAcceptance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer taskSolutionAcceptanceID;

	private String comment;

	//bi-directional many-to-one association to AcceptanceResult
	@ManyToOne
	@JoinColumn(name="acceptanceResultID")
	private AcceptanceResult acceptanceResult;

	//bi-directional many-to-one association to TaskSolution
	@ManyToOne
	@JoinColumn(name="taskSolutionID")
	private TaskSolution taskSolution;

	public TaskSolutionAcceptance() {
	}

	public Integer getTasksolutionacceptanceid() {
		return this.taskSolutionAcceptanceID;
	}

	public void setTaskSolutionAcceptanceID(Integer taskSolutionAcceptanceID) {
		this.taskSolutionAcceptanceID = taskSolutionAcceptanceID;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public AcceptanceResult getAcceptanceResult() {
		return this.acceptanceResult;
	}

	public void setAcceptanceResult(AcceptanceResult acceptanceResult) {
		this.acceptanceResult = acceptanceResult;
	}

	public TaskSolution getTaskSolution() {
		return this.taskSolution;
	}

	public void setTaskSolution(TaskSolution taskSolution) {
		this.taskSolution = taskSolution;
	}

}