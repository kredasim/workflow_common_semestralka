package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the studyprogram database table.
 * 
 */
@Entity
public class Studyprogram implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer studyprogramid;

	private String description;

	private String name;

	//bi-directional many-to-one association to InstitutionStudyprogram
	@OneToMany(mappedBy="studyprogram")
	private List<InstitutionStudyprogram> institutionStudyprograms;

	//bi-directional many-to-one association to Appuser
	@ManyToOne
	@JoinColumn(name="userid")
	private Appuser appuser;

	//bi-directional many-to-one association to SubjectStudyprogram
	@OneToMany(mappedBy="studyprogram")
	private List<SubjectStudyprogram> subjectStudyprograms;

	public Studyprogram() {
	}

	public Integer getStudyprogramid() {
		return this.studyprogramid;
	}

	public void setStudyprogramid(Integer studyprogramid) {
		this.studyprogramid = studyprogramid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<InstitutionStudyprogram> getInstitutionStudyprograms() {
		return this.institutionStudyprograms;
	}

	public void setInstitutionStudyprograms(List<InstitutionStudyprogram> institutionStudyprograms) {
		this.institutionStudyprograms = institutionStudyprograms;
	}

	public Appuser getAppuser() {
		return this.appuser;
	}

	public void setAppuser(Appuser appuser) {
		this.appuser = appuser;
	}

	public List<SubjectStudyprogram> getSubjectStudyprograms() {
		return this.subjectStudyprograms;
	}

	public void setSubjectStudyprograms(List<SubjectStudyprogram> subjectStudyprograms) {
		this.subjectStudyprograms = subjectStudyprograms;
	}

}