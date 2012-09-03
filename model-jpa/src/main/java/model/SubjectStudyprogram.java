package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the subject_studyprogram database table.
 * 
 */
@Entity
@Table(name="subject_studyprogram")
public class SubjectStudyprogram implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="subject_studyprogramid")
	private Integer subjectStudyprogramid;

	//bi-directional many-to-one association to Studyprogram
	@ManyToOne
	@JoinColumn(name="studyprogramid")
	private Studyprogram studyprogram;

	//bi-directional many-to-one association to Subject
	@ManyToOne
	@JoinColumn(name="subjectid")
	private Subject subject;

	public SubjectStudyprogram() {
	}

	public Integer getSubjectStudyprogramid() {
		return this.subjectStudyprogramid;
	}

	public void setSubjectStudyprogramid(Integer subjectStudyprogramid) {
		this.subjectStudyprogramid = subjectStudyprogramid;
	}

	public Studyprogram getStudyprogram() {
		return this.studyprogram;
	}

	public void setStudyprogram(Studyprogram studyprogram) {
		this.studyprogram = studyprogram;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}