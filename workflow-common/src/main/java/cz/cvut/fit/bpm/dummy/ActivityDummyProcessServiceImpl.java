/* ===========================================================================
 * IBA CZ Confidential
 *
 * (c) Copyright IBA CZ 2011 ALL RIGHTS RESERVED
 * The source code for this program is not published or otherwise
 * divested of its trade secrets.
 *
 * =========================================================================== */
package cz.cvut.fit.bpm.dummy;

import cz.cvut.fit.bpm.api.dto.BpmProcessDto;
import cz.cvut.fit.bpm.api.service.ProcessService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Miroslav Ligas <miroslav.ligas@ibacz.eu>
 */
@Component
public class ActivityDummyProcessServiceImpl implements ProcessService {
    @Override
    public List<BpmProcessDto> getAllProcessesForUser(String userId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
