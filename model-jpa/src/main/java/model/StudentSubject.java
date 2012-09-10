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
	private Integer studentSubjectID;

	private Boolean completed;

	private String grade;

	private String semester;

	//bi-directional many-to-one association to Appuser
	@ManyToOne
	@JoinColumn(name="appUserID")
	private AppUser appUser;

	//bi-directional many-to-one association to Subject
	@ManyToOne
	@JoinColumn(name="subjectID")
	private Subject subject;

	public StudentSubject() {
	}

	public Integer getStudentSubjectID() {
		return this.studentSubjectID;
	}

	public void setStudentSubjectID(Integer studentSubjectID) {
		this.studentSubjectID = studentSubjectID;
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

	public AppUser getAppUser() {
		return this.appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}