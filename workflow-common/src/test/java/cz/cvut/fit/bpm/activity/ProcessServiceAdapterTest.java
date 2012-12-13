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

import cz.cvut.fit.bpm.AbstractActivitiTest;
import cz.cvut.fit.bpm.api.dto.BpmProcessDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * @author Miroslav Ligas <miroslav.ligas@ibacz.eu>
 */
public class ProcessServiceAdapterTest extends AbstractActivitiTest {

    @Autowired
    private ProcessServiceAdapter processServiceAdapter;

    @Test
    public void testGetAllProcessesForUser() throws Exception {
        List<BpmProcessDto> allProcessesForUser = processServiceAdapter.getAllProcessesForUser(TEST_USER);

        assertThat(allProcessesForUser, is(notNullValue()));
        assertThat(allProcessesForUser.isEmpty(), is(false));
    }

    @Test
    public void testStartProcess() throws Exception {
//       TODO: switch to processId when portlets are capable of sending it
//       String proceseInstaceId = processServiceAdapter.startProcess(testProcessId);
        String proceseInstaceId = processServiceAdapter.startProcess(testProcessKey);

        assertThat(proceseInstaceId, is(notNullValue()));
    }
}
