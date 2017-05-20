package by.issue_tracker.models;

import java.io.Serializable;

public class Task implements Serializable {
    private String id;
    private String name;
    private String description;
    private String due_date;
    private String done;
    private String sprint_id;
    private String performer_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public String getDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }

    public String getSprint_id() {
        return sprint_id;
    }

    public void setSprint_id(String sprint_id) {
        this.sprint_id = sprint_id;
    }

    public String getPerformer_id() {
        return performer_id;
    }

    public void setPerformer_id(String performer_id) {
        this.performer_id = performer_id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
