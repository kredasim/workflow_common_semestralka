package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the project database table.
 * 
 */
@Entity
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer projectID;

	private String description;

	private Timestamp insertTimeStamp;

	private String name;

	private Timestamp updateTimestamp;

	//bi-directional many-to-one association to Institution
	@ManyToOne
	@JoinColumn(name="institutionID")
	private Institution institution;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="parentProjectID")
	private Project project;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="project")
	private List<Project> projects;

	//bi-directional many-to-one association to Task
	@OneToMany(mappedBy="project")
	private List<Task> tasks;

	public Project() {
	}

	public Integer getProjectID() {
		return this.projectID;
	}

	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getInsertTimestamp() {
		return this.insertTimeStamp;
	}

	public void setInsertTimestamp(Timestamp insertTimestamp) {
		this.insertTimeStamp = insertTimestamp;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getUpdateTimestamp() {
		return this.updateTimestamp;
	}

	public void setUpdateTimestamp(Timestamp updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}