package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the institution_studyprogram database table.
 * 
 */
@Entity
@Table(name="institution_studyprogram")
public class InstitutionStudyprogram implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="institution_studyprogramid")
	private Integer institutionStudyprogramid;

	//bi-directional many-to-one association to Institution
	@ManyToOne
	@JoinColumn(name="institutionid")
	private Institution institution;

	//bi-directional many-to-one association to Studyprogram
	@ManyToOne
	@JoinColumn(name="studyprogramid")
	private Studyprogram studyprogram;

	public InstitutionStudyprogram() {
	}

	public Integer getInstitutionStudyprogramid() {
		return this.institutionStudyprogramid;
	}

	public void setInstitutionStudyprogramid(Integer institutionStudyprogramid) {
		this.institutionStudyprogramid = institutionStudyprogramid;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public Studyprogram getStudyprogram() {
		return this.studyprogram;
	}

	public void setStudyprogram(Studyprogram studyprogram) {
		this.studyprogram = studyprogram;
	}

}