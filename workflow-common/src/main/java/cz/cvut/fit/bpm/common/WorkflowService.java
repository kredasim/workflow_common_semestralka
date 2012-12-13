/* ===========================================================================
 * IBA CZ Confidential
 *
 * (c) Copyright IBA CZ 2011 ALL RIGHTS RESERVED
 * The source code for this program is not published or otherwise
 * divested of its trade secrets.
 *
 * =========================================================================== */
package cz.cvut.fit.bpm.common;

import java.util.List;
import java.util.Map;

import cz.cvut.fit.bpm.api.dto.BpmProcessDto;
import cz.cvut.fit.bpm.api.dto.BpmTaskDto;

/**
 * @author Miroslav Ligas <miroslav.ligas@ibacz.eu>
 */
public interface WorkflowService {

    List<BpmTaskDto> getAllTasksForUser(String userId);

    List<BpmProcessDto> getAllProcessesForUser(String userId);

    /**
     * Starts process by provided id.
     *
     * @param processId process id
     * @return process instance ID
     */
    String startProcess(String processId);


    //TODO: Should bye connected to taskId not processId. Need to be fixed.
    void completeTaskByProcessId(String processId, Map<String, Object> data);
}
