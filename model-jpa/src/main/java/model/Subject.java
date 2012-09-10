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
	private Integer subjectID;

	private String anotation;

	private String completion;

	private String courseOutline;

	private Integer credits;

	private String exercisesOutline;

	private String extentOfTeaching;

	private Timestamp insertTimestamp;

	private String name;

	private Boolean taskNominationAllowed;

	private Timestamp updateTimestamp;

	//bi-directional many-to-one association to Institution
	@ManyToMany(mappedBy="subjects")
	private List<Institution> institutions;

	//bi-directional many-to-one association to StudentSubject
	@OneToMany(mappedBy="subject")
	private List<StudentSubject> studentSubjects;

	//bi-directional many-to-one association to tStudyProgram
	@ManyToMany(mappedBy="subjects")
	private List<StudyProgram> studyPrograms;

	//bi-directional many-to-one association to SubjectTask
	@OneToMany(mappedBy="subject")
	private List<SubjectTask> subjectTasks;

	//bi-directional many-to-one association to TeacherSubject
	@OneToMany(mappedBy="subject")
	private List<TeacherSubject> teacherSubjects;

	public Subject() {
	}

	public Integer getSubjectID() {
		return this.subjectID;
	}

	public void setSubjectID(Integer subjectID) {
		this.subjectID = subjectID;
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

	public String getCourseOutline() {
		return this.courseOutline;
	}

	public void setCourseOutline(String courseOutline) {
		this.courseOutline = courseOutline;
	}

	public Integer getCredits() {
		return this.credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public String getExercisesOutline() {
		return this.exercisesOutline;
	}

	public void setExercisesOutline(String exercisesOutline) {
		this.exercisesOutline = exercisesOutline;
	}

	public String getExtentOfTeaching() {
		return this.extentOfTeaching;
	}

	public void setExtentOfTeaching(String extentOfTeaching) {
		this.extentOfTeaching = extentOfTeaching;
	}

	public Timestamp getInsertTimestamp() {
		return this.insertTimestamp;
	}

	public void setInsertTimestamp(Timestamp insertTimestamp) {
		this.insertTimestamp = insertTimestamp;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getTaskNominationAllowed() {
		return this.taskNominationAllowed;
	}

	public void setTaskNominationAllowed(Boolean taskNominationAllowed) {
		this.taskNominationAllowed = taskNominationAllowed;
	}

	public Timestamp getUpdateTimestamp() {
		return this.updateTimestamp;
	}

	public void setUpdateTimestamp(Timestamp updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}

	public List<Institution> getInstitutions() {
		return this.institutions;
	}

	public void setInstitutions(List<Institution> institutions) {
		this.institutions = institutions;
	}

	public List<StudentSubject> getStudentSubjects() {
		return this.studentSubjects;
	}

	public void setStudentSubjects(List<StudentSubject> studentSubjects) {
		this.studentSubjects = studentSubjects;
	}

	public List<StudyProgram> getStudyPrograms() {
		return this.studyPrograms;
	}

	public void setStudyPrograms(List<StudyProgram> studyPrograms) {
		this.studyPrograms = studyPrograms;
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