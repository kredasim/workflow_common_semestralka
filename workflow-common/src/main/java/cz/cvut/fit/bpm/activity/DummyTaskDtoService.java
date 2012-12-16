/**
 * 
 */
package cz.cvut.fit.bpm.activity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cz.cvut.fit.bpm.api.dto.AttachmentDto;
import cz.cvut.fit.bpm.api.dto.ProjectDto;
import cz.cvut.fit.bpm.api.dto.RoleDto;
import cz.cvut.fit.bpm.api.dto.SkillDto;
import cz.cvut.fit.bpm.api.dto.TaskDto;
import cz.cvut.fit.bpm.api.dto.UnitRoleDto;
import cz.cvut.fit.bpm.api.service.TaskDtoService;

/**
 * Dummy implementation of {@link TaskDtoService} for demo purposes.
 * 
 * @author Simeon Kredatus
 * 
 */
public class DummyTaskDtoService implements TaskDtoService {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TaskDto getById(Long id) {
		ProjectDto project = new ProjectDto();
		project.setName("Sample project");
		TaskDto taskDto = new TaskDto();
		taskDto.setTitle("project1");
		taskDto.setGoals("Some targets");
		taskDto.setDescription("descriptioooon");
		taskDto.setOutputs("desiredOutputssadfkjzm,nzc,");
		taskDto.setRegistrationEnd(new Date());
		taskDto.setSubjects("PA1");
		taskDto.setProject(project);
		taskDto.setValidFrom(new Date());
		taskDto.setValidTo(new Date());
		taskDto.setWorkIntensity(100);
		taskDto.setSources("some sources");

		createSampleRoles(taskDto);
		createAttachments(taskDto);
		return taskDto;
	}

	/**
	 * @param taskDto
	 */
	private void createAttachments(TaskDto taskDto) {
		List<AttachmentDto> attachments = new ArrayList<AttachmentDto>();
		for (int i = 0; i < 4; i++) {
			AttachmentDto attachmentDto = new AttachmentDto();
			attachmentDto.setComment("Attachment:" + i);
			attachmentDto.setDownloadAddress("someAddress");
			attachmentDto.setFileId("link");
			attachments.add(attachmentDto);
		}
		taskDto.setAttachments(attachments);
		
	}

	/**
	 * @param taskDto
	 */
	private void createSampleRoles(TaskDto taskDto) {
		List<UnitRoleDto> roles = new ArrayList<UnitRoleDto>();
		for (int i = 0; i < 10; i++) {
			List<SkillDto> dest = new ArrayList<SkillDto>();
			for (int j = 0; j < 5; j++) {
				SkillDto s = new SkillDto();
				s.setRating(j);
				s.setType("Skill no.: " + j);
				dest.add(s);
			}
			UnitRoleDto role = new UnitRoleDto();
			RoleDto r = new RoleDto();
			r.setName("Role: " + i);
			r.setDescription("Role desc:" + i);
			role.setRole(r);
			role.setSkillDtoList(dest);
			role.setDescription("Some desc");
			roles.add(role);
		}
		taskDto.setRoles(roles);
	}

}
