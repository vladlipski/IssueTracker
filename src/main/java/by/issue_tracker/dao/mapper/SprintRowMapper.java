package by.issue_tracker.dao.mapper;

import by.issue_tracker.model.Sprint;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

@Component
public class SprintRowMapper implements RowMapper<Sprint> {
    @Override
    public Sprint mapRow(ResultSet resultSet, int i) throws SQLException {
        Sprint sprint = new Sprint();
        sprint.setId(resultSet.getInt("id"));
        sprint.setName(resultSet.getString("name"));
        Timestamp startDate = resultSet.getTimestamp("start_date");
        sprint.setStartDate(startDate.toLocalDateTime().toLocalDate());
        Timestamp endDate = resultSet.getTimestamp("end_date");
        sprint.setEndDate(endDate.toLocalDateTime().toLocalDate());
        sprint.setProjectId(resultSet.getInt("project_id"));
        return sprint;
    }
}
