package by.issue_tracker.model;

import java.io.Serializable;
import java.util.Objects;

public class Comment implements Serializable {
    private Integer id;
    private Integer taskId;
    private Integer authorId;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id) &&
                Objects.equals(taskId, comment.taskId) &&
                Objects.equals(authorId, comment.authorId) &&
                Objects.equals(content, comment.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taskId, authorId, content);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", taskId='" + taskId + '\'' +
                ", authorId='" + authorId + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
