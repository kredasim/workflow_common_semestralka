package cz.cvut.fit.industry.api.dto;

public class SkillDto {

    private int upperSkillId;
    private String type;
    private int rating;
    private boolean disabled;
    private boolean mandatory;

    public int getUpperSkillId() {
        return upperSkillId;
    }

    public void setUpperSkillId(int upperSkillId) {
        this.upperSkillId = upperSkillId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }
}