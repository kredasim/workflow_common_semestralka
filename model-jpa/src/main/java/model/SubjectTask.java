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
	private Integer subjectTaskid;

	private String comment;

	private Timestamp inserttimestamp;

	//bi-directional many-to-one association to Subject
	@ManyToOne
	@JoinColumn(name="subjectid")
	private Subject subject;

	//bi-directional many-to-one association to Subjecttaskassignmentstate
	@ManyToOne
	@JoinColumn(name="subjecttaskassignmentstateid")
	private Subjecttaskassignmentstate subjecttaskassignmentstate;

	//bi-directional many-to-one association to Task
	@ManyToOne
	@JoinColumn(name="taskid")
	private Task task;

	public SubjectTask() {
	}

	public Integer getSubjectTaskid() {
		return this.subjectTaskid;
	}

	public void setSubjectTaskid(Integer subjectTaskid) {
		this.subjectTaskid = subjectTaskid;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getInserttimestamp() {
		return this.inserttimestamp;
	}

	public void setInserttimestamp(Timestamp inserttimestamp) {
		this.inserttimestamp = inserttimestamp;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Subjecttaskassignmentstate getSubjecttaskassignmentstate() {
		return this.subjecttaskassignmentstate;
	}

	public void setSubjecttaskassignmentstate(Subjecttaskassignmentstate subjecttaskassignmentstate) {
		this.subjecttaskassignmentstate = subjecttaskassignmentstate;
	}

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

}