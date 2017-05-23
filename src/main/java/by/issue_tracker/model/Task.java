package by.issue_tracker.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import static org.springframework.format.annotation.DateTimeFormat.*;

public class Task implements Serializable {
    private Integer id;
    private String name;
    private String description;
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime dueDate;
    private String done;
    private Integer sprintId;
    private Integer performerId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public String getDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }

    public Integer getSprintId() {
        return sprintId;
    }

    public void setSprintId(Integer sprintId) {
        this.sprintId = sprintId;
    }

    public Integer getPerformerId() {
        return performerId;
    }

    public void setPerformerId(Integer performerId) {
        this.performerId = performerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) &&
                Objects.equals(name, task.name) &&
                Objects.equals(description, task.description) &&
                Objects.equals(dueDate, task.dueDate) &&
                Objects.equals(done, task.done) &&
                Objects.equals(sprintId, task.sprintId) &&
                Objects.equals(performerId, task.performerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, dueDate, done, sprintId, performerId);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", done='" + done + '\'' +
                ", sprintId='" + sprintId + '\'' +
                ", performerId='" + performerId + '\'' +
                '}';
    }
}
