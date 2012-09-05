package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the subject_studyprogram database table.
 * 
 */
@Entity
@Table(name="subject_studyprogram")
public class SubjectStudyProgram implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="subject_studyprogramid")
	private Integer subjectStudyprogramid;

	//bi-directional many-to-one association to StudyProgram
	@ManyToOne
	@JoinColumn(name="studyprogramid")
	private StudyProgram studyProgram;

	//bi-directional many-to-one association to Subject
	@ManyToOne
	@JoinColumn(name="subjectid")
	private Subject subject;

	public SubjectStudyProgram() {
	}

	public Integer getSubjectStudyprogramid() {
		return this.subjectStudyprogramid;
	}

	public void setSubjectStudyprogramid(Integer subjectStudyprogramid) {
		this.subjectStudyprogramid = subjectStudyprogramid;
	}

	public StudyProgram getStudyprogram() {
		return this.studyProgram;
	}

	public void setStudyprogram(StudyProgram studyProgram) {
		this.studyProgram = studyProgram;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}