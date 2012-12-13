/* ===========================================================================
 * IBA CZ Confidential
 *
 * (c) Copyright IBA CZ 2011 ALL RIGHTS RESERVED
 * The source code for this program is not published or otherwise
 * divested of its trade secrets.
 *
 * =========================================================================== */
package cz.cvut.fit.bpm.activity;

import java.util.List;

import cz.cvut.fit.bpm.activity.converter.ProcessDefinitionToDtoConverter;
import cz.cvut.fit.bpm.api.dto.BpmProcessDto;
import cz.cvut.fit.bpm.api.service.ProcessService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Miroslav Ligas <miroslav.ligas@ibacz.eu>
 */
@Component("activitiProcessService")
public class ProcessServiceAdapter extends AbstractServiceAdapter implements ProcessService {

    @Autowired
    private ProcessDefinitionToDtoConverter converter;

    @Override
    public List<BpmProcessDto> getAllProcessesForUser(String userId) {
        RepositoryService repositoryService = activitiLibrary.getProcessEngine().getRepositoryService();

        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
//      TODO: when activiti process support role restrictions us this line
//      processDefinitionQuery.startableByUser(userId);
        List<ProcessDefinition> processDefinitions = processDefinitionQuery.list();
        return converter.convertList(processDefinitions);
    }

    @Override
    public String startProcess(String processId) {
        RuntimeService runtimeService = activitiLibrary.getRuntimeService();

//        TODO: switch to processId when portlets are capable of sending it
//        return runtimeService.startProcessInstanceById(processId).getId();
        return runtimeService.startProcessInstanceByKey(processId).getId();
    }
}
