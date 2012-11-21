/* ===========================================================================
 * IBA CZ Confidential
 *
 * (c) Copyright IBA CZ 2011 ALL RIGHTS RESERVED
 * The source code for this program is not published or otherwise
 * divested of its trade secrets.
 *
 * =========================================================================== */
package cz.cvut.fit.industry.api.dto;

import java.util.Date;
import java.util.List;

/**
 * @author Miroslav Ligas <miroslav.ligas@ibacz.eu>
 */
public class TaskDto {

    private long id;
    private String title;
    private String description;
    private String goals;
    private int workIntensity;
    private int studentReward;
//    private List<PositionDto> positions;
    private String outputs;
    private Date today;
    private Date validFrom;
    private Date validTo;
    private Date registrationEnd;
//    private ProjectDto project;
    private String subjects;
    private String sources;
    private String requirements;
    private List<String> attachmentsRefs;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public int getWorkIntensity() {
        return workIntensity;
    }

    public void setWorkIntensity(int workIntensity) {
        this.workIntensity = workIntensity;
    }

    public int getStudentReward() {
        return studentReward;
    }

    public void setStudentReward(int studentReward) {
        this.studentReward = studentReward;
    }

//    public List<UnitRoleDto> getUnitRoles() {
//        return unitRoles;
//    }
//
//    public void setUnitRoles(List<UnitRoleDto> unitRoles) {
//        this.unitRoles = unitRoles;
//    }

    public String getOutputs() {
        return outputs;
    }

    public void setOutputs(String outputs) {
        this.outputs = outputs;
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public Date getRegistrationEnd() {
        return registrationEnd;
    }

    public void setRegistrationEnd(Date registrationEnd) {
        this.registrationEnd = registrationEnd;
    }

//    public ProjectDto getProject() {
//        return project;
//    }
//
//    public void setProject(ProjectDto project) {
//        this.project = project;
//    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public List<String> getAttachmentsRefs() {
        return attachmentsRefs;
    }

    public void setAttachmentsRefs(List<String> attachmentsRefs) {
        this.attachmentsRefs = attachmentsRefs;
    }
}
