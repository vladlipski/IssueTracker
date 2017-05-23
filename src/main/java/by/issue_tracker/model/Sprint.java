package by.issue_tracker.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import static org.springframework.format.annotation.DateTimeFormat.*;

public class Sprint implements Serializable {
    private Integer id;
    private String name;
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate startDate;
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate endDate;
    private Integer projectId;

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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sprint sprint = (Sprint) o;
        return Objects.equals(id, sprint.id) &&
                Objects.equals(name, sprint.name) &&
                Objects.equals(startDate, sprint.startDate) &&
                Objects.equals(endDate, sprint.endDate) &&
                Objects.equals(projectId, sprint.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, startDate, endDate, projectId);
    }

    @Override
    public String toString() {
        return "Sprint{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", projectId='" + projectId + '\'' +
                '}';
    }
}
