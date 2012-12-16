/**
 * 
 */
package cz.cvut.fit.bpm.activity;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.fit.bpm.api.dto.SkillDto;
import cz.cvut.fit.bpm.api.service.SkillDtoService;

/**
 * Dummy implementation of {@link SkillDtoService}.
 * @author Simeon Kredatus
 *
 */
public class DummySkillDtoService implements SkillDtoService {

	/** 
	 * {@inheritDoc}
	 */
	@Override
	public List<SkillDto> getSkillsForUser(Long id) {
		List<SkillDto> dest = new ArrayList<SkillDto>();
		for (int j = 0; j < 5; j++) {
			SkillDto s = new SkillDto();
			s.setRating(j);
			s.setType("Skill no.: " + j);
			dest.add(s);
		}
		return dest;
	}

}
