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
	@Column(name="Teacher_SubjectID")
	private Integer teacherSubjectID;

	private String semester;

	//bi-directional many-to-one association to Appuser
	@ManyToOne
	@JoinColumn(name="appUserID")
	private AppUser appUser;

	//bi-directional many-to-one association to Subject
	@ManyToOne
	@JoinColumn(name="subjectID")
	private Subject subject;

	public TeacherSubject() {
	}

	public Integer getTeacherSubjectID() {
		return this.teacherSubjectID;
	}

	public void setTeacherSubjectID(Integer teacherSubjectID) {
		this.teacherSubjectID = teacherSubjectID;
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