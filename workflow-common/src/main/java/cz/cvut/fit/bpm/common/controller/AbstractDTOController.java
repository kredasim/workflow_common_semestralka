/**
 * 
 */
package cz.cvut.fit.bpm.common.controller;

import javax.annotation.PostConstruct;


/**
 * Abstract parent for controllers needing to encapsulate data within dto object.
 * @author Simeon Kredatus
 *
 */
public abstract class AbstractDTOController<DTO_OBJECT> {

	private DTO_OBJECT dto;
	
	public DTO_OBJECT getDto() {
		return dto;
	}

	public void setDto(DTO_OBJECT dto) {
		this.dto = dto;
	}
}
