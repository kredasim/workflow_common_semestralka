package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the subject database table.
 * 
 */
@Entity
public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer subjectid;

	private String anotation;

	private String completion;

	private String courseoutline;

	private Integer credits;

	private String exercisesoutline;

	private String extentofteaching;

	private Timestamp inserttimestamp;

	private String name;

	private Boolean tasknominationallowed;

	private Timestamp updatetimestamp;

	//bi-directional many-to-one association to InstitutionSubject
	@OneToMany(mappedBy="subject")
	private List<InstitutionSubject> institutionSubjects;

	//bi-directional many-to-one association to StudentSubject
	@OneToMany(mappedBy="subject")
	private List<StudentSubject> studentSubjects;

	//bi-directional many-to-one association to SubjectStudyprogram
	@OneToMany(mappedBy="subject")
	private List<SubjectStudyprogram> subjectStudyprograms;

	//bi-directional many-to-one association to SubjectTask
	@OneToMany(mappedBy="subject")
	private List<SubjectTask> subjectTasks;

	//bi-directional many-to-one association to TeacherSubject
	@OneToMany(mappedBy="subject")
	private List<TeacherSubject> teacherSubjects;

	public Subject() {
	}

	public Integer getSubjectid() {
		return this.subjectid;
	}

	public void setSubjectid(Integer subjectid) {
		this.subjectid = subjectid;
	}

	public String getAnotation() {
		return this.anotation;
	}

	public void setAnotation(String anotation) {
		this.anotation = anotation;
	}

	public String getCompletion() {
		return this.completion;
	}

	public void setCompletion(String completion) {
		this.completion = completion;
	}

	public String getCourseoutline() {
		return this.courseoutline;
	}

	public void setCourseoutline(String courseoutline) {
		this.courseoutline = courseoutline;
	}

	public Integer getCredits() {
		return this.credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public String getExercisesoutline() {
		return this.exercisesoutline;
	}

	public void setExercisesoutline(String exercisesoutline) {
		this.exercisesoutline = exercisesoutline;
	}

	public String getExtentofteaching() {
		return this.extentofteaching;
	}

	public void setExtentofteaching(String extentofteaching) {
		this.extentofteaching = extentofteaching;
	}

	public Timestamp getInserttimestamp() {
		return this.inserttimestamp;
	}

	public void setInserttimestamp(Timestamp inserttimestamp) {
		this.inserttimestamp = inserttimestamp;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getTasknominationallowed() {
		return this.tasknominationallowed;
	}

	public void setTasknominationallowed(Boolean tasknominationallowed) {
		this.tasknominationallowed = tasknominationallowed;
	}

	public Timestamp getUpdatetimestamp() {
		return this.updatetimestamp;
	}

	public void setUpdatetimestamp(Timestamp updatetimestamp) {
		this.updatetimestamp = updatetimestamp;
	}

	public List<InstitutionSubject> getInstitutionSubjects() {
		return this.institutionSubjects;
	}

	public void setInstitutionSubjects(List<InstitutionSubject> institutionSubjects) {
		this.institutionSubjects = institutionSubjects;
	}

	public List<StudentSubject> getStudentSubjects() {
		return this.studentSubjects;
	}

	public void setStudentSubjects(List<StudentSubject> studentSubjects) {
		this.studentSubjects = studentSubjects;
	}

	public List<SubjectStudyprogram> getSubjectStudyprograms() {
		return this.subjectStudyprograms;
	}

	public void setSubjectStudyprograms(List<SubjectStudyprogram> subjectStudyprograms) {
		this.subjectStudyprograms = subjectStudyprograms;
	}

	public List<SubjectTask> getSubjectTasks() {
		return this.subjectTasks;
	}

	public void setSubjectTasks(List<SubjectTask> subjectTasks) {
		this.subjectTasks = subjectTasks;
	}

	public List<TeacherSubject> getTeacherSubjects() {
		return this.teacherSubjects;
	}

	public void setTeacherSubjects(List<TeacherSubject> teacherSubjects) {
		this.teacherSubjects = teacherSubjects;
	}

}