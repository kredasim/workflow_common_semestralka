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

import cz.cvut.fit.bpm.AbstractTest;
import cz.cvut.fit.bpm.api.dto.BpmProcessDto;
import cz.cvut.fit.bpm.api.dto.BpmTaskDto;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * @author Miroslav Ligas <miroslav.ligas@ibacz.eu>
 */
public class WorkflowServiceImplTest extends AbstractTest {

    public static final String TEST_USER = "kermit";

    @Autowired
    private WorkflowServiceImpl workflowService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    @Ignore
    /**
     * This test fails because no user assignment is defined in the processes.
     */
    public void testGetAllTasksForUser() throws Exception {
        List<BpmProcessDto> allProcessesForUser = workflowService.getAllProcessesForUser(TEST_USER);
        workflowService.startProcess(allProcessesForUser.get(0).getId());

        List<BpmTaskDto> allTasksForUser = workflowService.getAllTasksForUser(TEST_USER);

        assertThat(allTasksForUser, is(notNullValue()));
        assertThat(allTasksForUser.isEmpty(), is(false));
    }

    @Test
    public void testGetAllProcessesForUser() throws Exception {
        List<BpmProcessDto> allProcessesForUser = workflowService.getAllProcessesForUser(TEST_USER);

        assertThat(allProcessesForUser, is(notNullValue()));
        assertThat(allProcessesForUser.isEmpty(), is(false));
    }

    @Test
    public void testStartProcess() throws Exception {
        List<BpmProcessDto> processDtos = workflowService.getAllProcessesForUser(TEST_USER);
        String id = processDtos.get(0).getId();
        String processId = workflowService.startProcess(id);

        assertThat(processId, is(notNullValue()));
    }

    @Test
    public void testCompleteTaskByProcessId() throws Exception {
        List<BpmProcessDto> processDtos = workflowService.getAllProcessesForUser(TEST_USER);
        String id = processDtos.get(0).getId();
        String processId = workflowService.startProcess(id);

        workflowService.completeTaskByProcessId(processId, null);
    }
}
