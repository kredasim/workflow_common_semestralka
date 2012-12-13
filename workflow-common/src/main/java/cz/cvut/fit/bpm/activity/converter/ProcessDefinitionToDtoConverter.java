/* ===========================================================================
 * IBA CZ Confidential
 *
 * (c) Copyright IBA CZ 2011 ALL RIGHTS RESERVED
 * The source code for this program is not published or otherwise
 * divested of its trade secrets.
 *
 * =========================================================================== */
package cz.cvut.fit.bpm.activity.converter;

import cz.cvut.fit.bpm.api.dto.BpmProcessDto;
import cz.cvut.fit.bpm.api.dto.BpmType;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.stereotype.Component;

/**
 * @author Miroslav Ligas <miroslav.ligas@ibacz.eu>
 */
@Component
public class ProcessDefinitionToDtoConverter extends GenericConverter<ProcessDefinition, BpmProcessDto> {

    @Override
    public BpmProcessDto convert(ProcessDefinition processDefinition) {
        BpmProcessDto result = new BpmProcessDto();
//        TODO: switch to processId when portlets are capable of sending it
//        result.setId(processDefinition.getId());
        result.setId(processDefinition.getKey());
        result.setProcessName(processDefinition.getName());
        result.setSystem(BpmType.ACTIVITI);
        result.setStartUrl(null);
        result.setType(null);
        return result;
    }
}
