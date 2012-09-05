package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the student_subject database table.
 * 
 */
@Entity
@Table(name="student_subject")
public class StudentSubject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_subjectid")
	private Integer studentSubjectid;

	private Boolean completed;

	private String grade;

	private String semester;

	//bi-directional many-to-one association to Appuser
	@ManyToOne
	@JoinColumn(name="appuserid")
	private AppUser appUser;

	//bi-directional many-to-one association to Subject
	@ManyToOne
	@JoinColumn(name="subjectid")
	private Subject subject;

	public StudentSubject() {
	}

	public Integer getStudentSubjectid() {
		return this.studentSubjectid;
	}

	public void setStudentSubjectid(Integer studentSubjectid) {
		this.studentSubjectid = studentSubjectid;
	}

	public Boolean getCompleted() {
		return this.completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSemester() {
		return this.semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public AppUser getAppuser() {
		return this.appUser;
	}

	public void setAppuser(AppUser appUser) {
		this.appUser = appUser;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}