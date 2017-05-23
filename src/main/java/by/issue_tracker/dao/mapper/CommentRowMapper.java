package by.issue_tracker.dao.mapper;

import by.issue_tracker.model.Comment;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CommentRowMapper implements RowMapper<Comment> {
    @Override
    public Comment mapRow(ResultSet resultSet, int i) throws SQLException {
        Comment comment = new Comment();
        comment.setId(resultSet.getInt("id"));
        comment.setTaskId(resultSet.getInt("task_id"));
        comment.setAuthorId(resultSet.getInt("author_id"));
        comment.setContent(resultSet.getString("content"));
        return comment;
    }
}
