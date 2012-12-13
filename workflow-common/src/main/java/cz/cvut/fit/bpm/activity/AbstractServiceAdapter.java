/* ===========================================================================
 * IBA CZ Confidential
 *
 * (c) Copyright IBA CZ 2011 ALL RIGHTS RESERVED
 * The source code for this program is not published or otherwise
 * divested of its trade secrets.
 *
 * =========================================================================== */
package cz.cvut.fit.bpm.activity;

import cz.cvut.fit.industry.api.service.ActivitiLibrary;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Miroslav Ligas <miroslav.ligas@ibacz.eu>
 */
public class AbstractServiceAdapter {
    @Autowired
    protected ActivitiLibrary activitiLibrary;

}
