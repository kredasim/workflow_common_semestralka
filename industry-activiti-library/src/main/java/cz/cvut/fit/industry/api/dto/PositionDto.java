/* ===========================================================================
 * IBA CZ Confidential
 *
 * (c) Copyright IBA CZ 2011 ALL RIGHTS RESERVED
 * The source code for this program is not published or otherwise
 * divested of its trade secrets.
 *
 * =========================================================================== */
package cz.cvut.fit.industry.api.dto;

import java.util.List;

/**
 * @author Miroslav Ligas <miroslav.ligas@ibacz.eu>
 */
public class PositionDto {

    private long id;
    private String positionName;
    private int requiredWorkers;
    private String description;
    private List<WorkersDto> workers;
    private List<SkillDto> skills;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public int getRequiredWorkers() {
        return requiredWorkers;
    }

    public void setRequiredWorkers(int requiredWorkers) {
        this.requiredWorkers = requiredWorkers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<WorkersDto> getWorkers() {
        return workers;
    }

    public void setWorkers(List<WorkersDto> workers) {
        this.workers = workers;
    }

    public List<SkillDto> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillDto> skills) {
        this.skills = skills;
    }
}
