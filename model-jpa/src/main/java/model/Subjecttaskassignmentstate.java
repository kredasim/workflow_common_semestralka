package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the subjectTaskAssignmentState database table.
 * 
 */
@Entity
public class SubjectTaskAssignmentState implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer subjectTaskAssignmentStateID;

	private Integer name;

	//bi-directional many-to-one association to SubjectTask
	@OneToMany(mappedBy="subjectTaskAssignmentState")
	private List<SubjectTask> subjectTasks;

	public SubjectTaskAssignmentState() {
	}

	public Integer getSubjectTaskAssignmentStateID() {
		return this.subjectTaskAssignmentStateID;
	}

	public void setSubjectTaskAssignmentStateID(Integer subjectTaskAssignmentStateID) {
		this.subjectTaskAssignmentStateID = subjectTaskAssignmentStateID;
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