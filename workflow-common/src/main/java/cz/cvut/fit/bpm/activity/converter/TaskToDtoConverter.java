/* ===========================================================================
 * IBA CZ Confidential
 *
 * (c) Copyright IBA CZ 2011 ALL RIGHTS RESERVED
 * The source code for this program is not published or otherwise
 * divested of its trade secrets.
 *
 * =========================================================================== */
package cz.cvut.fit.bpm.activity.converter;

import cz.cvut.fit.bpm.api.dto.BpmTaskDto;
import cz.cvut.fit.bpm.api.dto.BpmType;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Component;

/**
 * @author Miroslav Ligas <miroslav.ligas@ibacz.eu>
 */

@Component
public class TaskToDtoConverter extends GenericConverter<Task,BpmTaskDto> {

    @Override
    public BpmTaskDto convert(Task task) {
        BpmTaskDto result = new BpmTaskDto();
        result.setId(task.getId());
        result.setSystem(BpmType.ACTIVITI);
        result.setName(task.getName());
        result.setProcessId(task.getParentTaskId());
        result.setProcessName(task.getProcessDefinitionId());
        result.setOwner(task.getOwner());
        result.setState(task.getDelegationState().toString());
        result.setStatus(null);
        result.setRunUrl(null);
        return result;

    }
}
