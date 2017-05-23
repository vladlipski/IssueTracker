package by.issue_tracker.dao.mapper;

import by.issue_tracker.model.Task;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

@Component
public class TaskRowMapper implements RowMapper<Task> {

    @Override
    public Task mapRow(ResultSet resultSet, int i) throws SQLException {
        Task task = new Task();
        task.setId(resultSet.getInt("id"));
        task.setName(resultSet.getString("name"));
        task.setDescription(resultSet.getString("description"));
        Timestamp date = resultSet.getTimestamp("due_date");
        task.setDueDate(date.toLocalDateTime());
        task.setDone(resultSet.getString("done"));
        task.setSprintId(resultSet.getInt("sprint_id"));
        task.setPerformerId(resultSet.getInt("performer_id"));
        return task;
    }
}
