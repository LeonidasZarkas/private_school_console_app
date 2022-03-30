package models;

import java.util.Date;

public class Course {
    private int id;
    private String title;
    private String stream = null;
    private String type = null;
    private Date startDate = null;
    private Date endDate = null;

    public Course() {
    }

    public Course(String title) {
        this.title = title;
    }

    public Course(int id, String title) {
        this.id = id;
        this.title = title;
    }
    
    public Course(String title, String type) {
        this.title = title;
        this.type = type;
    }

    public Course(int id, String title, String stream, String type, Date startDate, Date endDate) {
        this.id = id;
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Course{id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", stream=").append(stream);
        sb.append(", type=").append(type);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append('}');
        return sb.toString();
    }
    
    public String toStringForTitleType() {
        StringBuilder sb = new StringBuilder();
        sb.append("Course{title=").append(title);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
    
    
}
