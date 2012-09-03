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
	private Integer projectid;

	private String description;

	private Timestamp inserttimestamp;

	private String name;

	private Timestamp updatetimestamp;

	//bi-directional many-to-one association to Institution
	@ManyToOne
	@JoinColumn(name="institutionid")
	private Institution institution;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="parentprojectid")
	private Project project;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="project")
	private List<Project> projects;

	//bi-directional many-to-one association to Task
	@OneToMany(mappedBy="project")
	private List<Task> tasks;

	public Project() {
	}

	public Integer getProjectid() {
		return this.projectid;
	}

	public void setProjectid(Integer projectid) {
		this.projectid = projectid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Timestamp getUpdatetimestamp() {
		return this.updatetimestamp;
	}

	public void setUpdatetimestamp(Timestamp updatetimestamp) {
		this.updatetimestamp = updatetimestamp;
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