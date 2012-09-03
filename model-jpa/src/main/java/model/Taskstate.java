package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the taskstate database table.
 * 
 */
@Entity
public class Taskstate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer taskstateid;

	private String name;

	//bi-directional many-to-one association to TaskTaskstate
	@OneToMany(mappedBy="taskstate")
	private List<TaskTaskstate> taskTaskstates;

	public Taskstate() {
	}

	public Integer getTaskstateid() {
		return this.taskstateid;
	}

	public void setTaskstateid(Integer taskstateid) {
		this.taskstateid = taskstateid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TaskTaskstate> getTaskTaskstates() {
		return this.taskTaskstates;
	}

	public void setTaskTaskstates(List<TaskTaskstate> taskTaskstates) {
		this.taskTaskstates = taskTaskstates;
	}

}