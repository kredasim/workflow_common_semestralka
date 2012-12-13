/* ===========================================================================
 * IBA CZ Confidential
 *
 * (c) Copyright IBA CZ 2011 ALL RIGHTS RESERVED
 * The source code for this program is not published or otherwise
 * divested of its trade secrets.
 *
 * =========================================================================== */
package cz.cvut.fit.bpm.lombardy;

import java.util.Collections;
import java.util.List;

import cz.cvut.fit.bpm.api.dto.BpmProcessDto;
import cz.cvut.fit.bpm.api.service.ProcessService;
import org.springframework.stereotype.Component;

/**
 * @author Miroslav Ligas <miroslav.ligas@ibacz.eu>
 */
@Component("lombardyProcessService")
public class LombardyDummyProcessServiceImpl implements ProcessService {

    @Override
    public List<BpmProcessDto> getAllProcessesForUser(String userId) {
        return Collections.emptyList();
    }

    @Override
    public String startProcess(String processId) {
        return null;

    }
}
