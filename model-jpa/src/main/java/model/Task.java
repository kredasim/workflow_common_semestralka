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
	private Appuser appuser;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="projectid")
	private Project project;

	//bi-directional many-to-one association to TaskSolution
	@OneToMany(mappedBy="task")
	private List<TaskSolution> taskSolutions;

	//bi-directional many-to-one association to TaskTaskrole
	@OneToMany(mappedBy="task")
	private List<TaskTaskrole> taskTaskroles;

	//bi-directional many-to-one association to TaskTaskstate
	@OneToMany(mappedBy="task")
	private List<TaskTaskstate> taskTaskstates;

	//bi-directional many-to-one association to Taskphase
	@OneToMany(mappedBy="task")
	private List<Taskphase> taskphases;

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

	public Appuser getAppuser() {
		return this.appuser;
	}

	public void setAppuser(Appuser appuser) {
		this.appuser = appuser;
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

	public List<TaskTaskrole> getTaskTaskroles() {
		return this.taskTaskroles;
	}

	public void setTaskTaskroles(List<TaskTaskrole> taskTaskroles) {
		this.taskTaskroles = taskTaskroles;
	}

	public List<TaskTaskstate> getTaskTaskstates() {
		return this.taskTaskstates;
	}

	public void setTaskTaskstates(List<TaskTaskstate> taskTaskstates) {
		this.taskTaskstates = taskTaskstates;
	}

	public List<Taskphase> getTaskphases() {
		return this.taskphases;
	}

	public void setTaskphases(List<Taskphase> taskphases) {
		this.taskphases = taskphases;
	}

}