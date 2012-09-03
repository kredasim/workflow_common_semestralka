package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the teacher_subject database table.
 * 
 */
@Entity
@Table(name="teacher_subject")
public class TeacherSubject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="teacher_subjectid")
	private Integer teacherSubjectid;

	private String semester;

	//bi-directional many-to-one association to Appuser
	@ManyToOne
	@JoinColumn(name="appuserid")
	private Appuser appuser;

	//bi-directional many-to-one association to Subject
	@ManyToOne
	@JoinColumn(name="subjectid")
	private Subject subject;

	public TeacherSubject() {
	}

	public Integer getTeacherSubjectid() {
		return this.teacherSubjectid;
	}

	public void setTeacherSubjectid(Integer teacherSubjectid) {
		this.teacherSubjectid = teacherSubjectid;
	}

	public String getSemester() {
		return this.semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public Appuser getAppuser() {
		return this.appuser;
	}

	public void setAppuser(Appuser appuser) {
		this.appuser = appuser;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}