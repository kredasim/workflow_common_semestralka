package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the subject_task database table.
 * 
 */
@Entity
@Table(name="subject_task")
public class SubjectTask implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="subject_taskid")
	private Integer subjectTaskID;

	private String comment;

	private Timestamp insertTimestamp;

	//bi-directional many-to-one association to Subject
	@ManyToOne
	@JoinColumn(name="subjectID")
	private Subject subject;

	//bi-directional many-to-one association to SubjectTaskAssignmentState
	@ManyToOne
	@JoinColumn(name="subjectTaskAssignmentStateID")
	private SubjectTaskAssignmentState subjectTaskAssignmentState;

	//bi-directional many-to-one association to Task
	@ManyToOne
	@JoinColumn(name="taskID")
	private Task task;

	public SubjectTask() {
	}

	public Integer getSubjectTaskID() {
		return this.subjectTaskID;
	}

	public void setSubjectTaskID(Integer subjectTaskID) {
		this.subjectTaskID = subjectTaskID;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getInsertTimestamp() {
		return this.insertTimestamp;
	}

	public void setInsertTimestamp(Timestamp insertTimestamp) {
		this.insertTimestamp = insertTimestamp;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public SubjectTaskAssignmentState getSubjectTaskAssignmentState() {
		return this.subjectTaskAssignmentState;
	}

	public void setSubjectTaskAssignmentState(SubjectTaskAssignmentState subjectTaskAssignmentState) {
		this.subjectTaskAssignmentState = subjectTaskAssignmentState;
	}

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

}