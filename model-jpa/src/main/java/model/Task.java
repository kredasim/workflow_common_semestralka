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
	private Integer taskid;

	private String description;

	private String goals;

	private float hoursestimated;

	private Timestamp inserttimestamp;

	private String name;

	private String requiredoutput;

	private Timestamp updatetimestamp;

	private Timestamp validfrom;

	private Timestamp validto;

	//bi-directional many-to-one association to SubjectTask
	@OneToMany(mappedBy="task")
	private List<SubjectTask> subjectTasks;

	//bi-directional many-to-one association to Appuser
	@ManyToOne
	@JoinColumn(name="appuserid")
	private AppUser appUser;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="projectid")
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

	public Integer getTaskid() {
		return this.taskid;
	}

	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
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

	public float getHoursestimated() {
		return this.hoursestimated;
	}

	public void setHoursestimated(float hoursestimated) {
		this.hoursestimated = hoursestimated;
	}

	public Timestamp getInserttimestamp() {
		return this.inserttimestamp;
	}

	public void setInserttimestamp(Timestamp inserttimestamp) {
		this.inserttimestamp = inserttimestamp;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRequiredoutput() {
		return this.requiredoutput;
	}

	public void setRequiredoutput(String requiredoutput) {
		this.requiredoutput = requiredoutput;
	}

	public Timestamp getUpdatetimestamp() {
		return this.updatetimestamp;
	}

	public void setUpdatetimestamp(Timestamp updatetimestamp) {
		this.updatetimestamp = updatetimestamp;
	}

	public Timestamp getValidfrom() {
		return this.validfrom;
	}

	public void setValidfrom(Timestamp validfrom) {
		this.validfrom = validfrom;
	}

	public Timestamp getValidto() {
		return this.validto;
	}

	public void setValidto(Timestamp validto) {
		this.validto = validto;
	}

	public List<SubjectTask> getSubjectTasks() {
		return this.subjectTasks;
	}

	public void setSubjectTasks(List<SubjectTask> subjectTasks) {
		this.subjectTasks = subjectTasks;
	}

	public AppUser getAppuser() {
		return this.appUser;
	}

	public void setAppuser(AppUser appUser) {
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

	public List<TaskTaskRole> getTaskTaskroles() {
		return this.taskTaskRoles;
	}

	public void setTaskTaskroles(List<TaskTaskRole> taskTaskRoles) {
		this.taskTaskRoles = taskTaskRoles;
	}

	public List<TaskTaskState> getTaskTaskStates() {
		return this.taskTaskStates;
	}

	public void setTaskTaskStates(List<TaskTaskState> taskTaskStates) {
		this.taskTaskStates = taskTaskStates;
	}

	public List<TaskPhase> getTaskphases() {
		return this.taskPhases;
	}

	public void setTaskphases(List<TaskPhase> taskPhases) {
		this.taskPhases = taskPhases;
	}

}