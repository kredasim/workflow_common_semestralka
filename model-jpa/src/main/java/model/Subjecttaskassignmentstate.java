package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the subjecttaskassignmentstate database table.
 * 
 */
@Entity
public class Subjecttaskassignmentstate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer subjecttaskassignmentstateid;

	private Integer name;

	//bi-directional many-to-one association to SubjectTask
	@OneToMany(mappedBy="subjecttaskassignmentstate")
	private List<SubjectTask> subjectTasks;

	public Subjecttaskassignmentstate() {
	}

	public Integer getSubjecttaskassignmentstateid() {
		return this.subjecttaskassignmentstateid;
	}

	public void setSubjecttaskassignmentstateid(Integer subjecttaskassignmentstateid) {
		this.subjecttaskassignmentstateid = subjecttaskassignmentstateid;
	}

	public Integer getName() {
		return this.name;
	}

	public void setName(Integer name) {
		this.name = name;
	}

	public List<SubjectTask> getSubjectTasks() {
		return this.subjectTasks;
	}

	public void setSubjectTasks(List<SubjectTask> subjectTasks) {
		this.subjectTasks = subjectTasks;
	}

}