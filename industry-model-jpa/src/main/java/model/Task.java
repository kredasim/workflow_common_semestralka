package model;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the task database table.
 * 
 */
@Entity
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer taskID;

	private String description;

	private String goals;

	private float hoursEstimated;

	private Timestamp insertTimestamp;

	private String name;

	private String requiredOutput;

	private Timestamp updateTimestamp;

	private Timestamp validFrom;

	private Timestamp validTo;

	//bi-directional many-to-one association to SubjectTask
	@OneToMany(mappedBy="task")
	private List<SubjectTask> subjectTasks;

	//bi-directional many-to-one association to AppUser
	@ManyToOne
	@JoinColumn(name="appUserID")
	private AppUser appUser;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="projectID")
	private Project project;

	//bi-directional many-to-one association to TaskSolution
	@ManyToMany
	@JoinTable(
			name = "Task_Solution",
			joinColumns = @JoinColumn(name = "taskID"),
			inverseJoinColumns = @JoinColumn(name = "taskSolutionID")
			)
	private List<TaskSolution> taskSolutions;

	//bi-directional many-to-one association to TaskTaskRole
	@OneToMany(mappedBy="task")
	private List<TaskTaskRole> taskTaskRoles;

	//bi-directional many-to-one association to TaskTaskState
	@OneToMany(mappedBy = "task")
	private List<TaskTaskState> taskTaskStates;

	//bi-directional many-to-one association to TaskPhase
	@OneToMany(mappedBy="task")
	private List<TaskPhase> taskPhases;

	public Task() {
	}

	public Integer getTaskId() {
		return this.taskID;
	}

	public void setTaskID(Integer taskID) {
		this.taskID = taskID;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGoals() {
		return this.goals;
	}

	public void setGoals(String goals) {
		this.goals = goals;
	}

	public float getHoursEstimated() {
		return this.hoursEstimated;
	}

	public void setHoursEstimated(float hoursEstimated) {
		this.hoursEstimated = hoursEstimated;
	}

	public Timestamp getInsertTimestamp() {
		return this.insertTimestamp;
	}

	public void setInsertTimestamp(Timestamp insertTimestamp) {
		this.insertTimestamp = insertTimestamp;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRequiredOutput() {
		return this.requiredOutput;
	}

	public void setRequiredOutput(String requiredOutput) {
		this.requiredOutput = requiredOutput;
	}

	public Timestamp getUpdateTimestamp() {
		return this.updateTimestamp;
	}

	public void setUpdateTimestamp(Timestamp updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}

	public Timestamp getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Timestamp validFrom) {
		this.validFrom = validFrom;
	}

	public Timestamp getValidTo() {
		return this.validTo;
	}

	public void setValidto(Timestamp validTo) {
		this.validTo = validTo;
	}

	public List<SubjectTask> getSubjectTasks() {
		return this.subjectTasks;
	}

	public void setSubjectTasks(List<SubjectTask> subjectTasks) {
		this.subjectTasks = subjectTasks;
	}

	public AppUser getAppUser() {
		return this.appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<TaskSolution> getTaskSolutions() {
		return this.taskSolutions;
	}

	public void setTaskSolutions(List<TaskSolution> taskSolutions) {
		this.taskSolutions = taskSolutions;
	}

	public List<TaskTaskRole> getTaskTaskRoles() {
		return this.taskTaskRoles;
	}

	public void setTaskTaskRoles(List<TaskTaskRole> taskTaskRoles) {
		this.taskTaskRoles = taskTaskRoles;
	}

	public List<TaskTaskState> getTaskTaskStates() {
		return this.taskTaskStates;
	}

	public void setTaskTaskStates(List<TaskTaskState> taskTaskStates) {
		this.taskTaskStates = taskTaskStates;
	}

	public List<TaskPhase> getTaskPhases() {
		return this.taskPhases;
	}

	public void setTaskPhases(List<TaskPhase> taskPhases) {
		this.taskPhases = taskPhases;
	}

}