package models;

import java.sql.Timestamp;

public class Assignment {
    private int id;
    private String title;
    private String description = null;
    private Timestamp submDateTime = null;

    public Assignment() {
    }

    public Assignment(String title) {
        this.title = title;
    }

    public Assignment(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Assignment(int id, String title, String description, Timestamp submDateTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.submDateTime = submDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Timestamp getSubmDateTime() {
        return submDateTime;
    }

    public void setSubmDateTime(Timestamp submDateTime) {
        this.submDateTime = submDateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Assignment{id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", description=").append(description);
        sb.append(", submDateTime=").append(submDateTime);
        sb.append('}');
        return sb.toString();
    }
    
    public String toStringForTitle() {
        StringBuilder sb = new StringBuilder();
        sb.append("Assignment{title=").append(title);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
