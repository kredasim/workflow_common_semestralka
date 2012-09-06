package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the acceptanceResult database table.
 * 
 */
@Entity
public class AcceptanceResult implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer acceptanceresultid;

	private String name;

	//bi-directional many-to-one association to TaskSolutionAcceptance
	@OneToMany(mappedBy="acceptanceResult")
	private List<TaskSolutionAcceptance> taskSolutionAcceptances;

	public AcceptanceResult() {
	}

	public Integer getAcceptanceresultid() {
		return this.acceptanceresultid;
	}

	public void setAcceptanceresultid(Integer acceptanceresultid) {
		this.acceptanceresultid = acceptanceresultid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TaskSolutionAcceptance> getTasksolutionacceptances() {
		return this.taskSolutionAcceptances;
	}

	public void setTasksolutionacceptances(List<TaskSolutionAcceptance> taskSolutionAcceptances) {
		this.taskSolutionAcceptances = taskSolutionAcceptances;
	}

}