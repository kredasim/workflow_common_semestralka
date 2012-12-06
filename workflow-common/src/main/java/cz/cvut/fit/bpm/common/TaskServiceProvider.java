/* ===========================================================================
 * IBA CZ Confidential
 *
 * (c) Copyright IBA CZ 2011 ALL RIGHTS RESERVED
 * The source code for this program is not published or otherwise
 * divested of its trade secrets.
 *
 * =========================================================================== */
package cz.cvut.fit.bpm.common;

import cz.cvut.fit.bpm.api.dto.BpmType;
import cz.cvut.fit.bpm.api.service.TaskService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Miroslav Ligas <miroslav.ligas@ibacz.eu>
 */
public class TaskServiceProvider {

    private Map<String,TaskService> taskServices = new HashMap<String, TaskService>();

    public TaskServiceProvider(Map<String, TaskService> taskServices) {
        this.taskServices = taskServices;
    }

    public TaskService getTaskService(BpmType type){
        return taskServices.get(type.toString());
    }
}
