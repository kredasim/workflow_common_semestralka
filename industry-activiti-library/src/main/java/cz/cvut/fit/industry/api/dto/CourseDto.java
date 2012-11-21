package cz.cvut.fit.industry.api.dto;

public class CourseDto {

    private String code;
    private String name;
    private String description;
    private String objective;
    private String eduxUrl;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getEduxUrl() {
        return eduxUrl;
    }

    public void setEduxUrl(String eduxUrl) {
        this.eduxUrl = eduxUrl;
    }
}