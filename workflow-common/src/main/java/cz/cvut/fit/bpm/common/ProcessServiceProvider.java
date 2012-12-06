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
import cz.cvut.fit.bpm.api.service.ProcessService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Miroslav Ligas <miroslav.ligas@ibacz.eu>
 */

public class ProcessServiceProvider {
    private Map<String,ProcessService> processServices = new HashMap<String, ProcessService>();

    public ProcessServiceProvider(Map<String, ProcessService> processServices) {
        this.processServices = processServices;
    }

    public ProcessService getProcessService(BpmType type){
        return processServices.get(type.toString());
    }
}
