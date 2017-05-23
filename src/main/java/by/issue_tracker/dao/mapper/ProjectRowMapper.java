package by.issue_tracker.dao.mapper;

import by.issue_tracker.model.Project;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

@Component
public class ProjectRowMapper implements RowMapper<Project> {
    @Override
    public Project mapRow(ResultSet resultSet, int i) throws SQLException {
        Project project = new Project();
        project.setId(resultSet.getInt("id"));
        project.setName(resultSet.getString("name"));
        project.setDescription(resultSet.getString("description"));
        Timestamp date = resultSet.getTimestamp("creation_date");
        project.setCreationDate(date.toLocalDateTime().toLocalDate());
        project.setManagerId(resultSet.getInt("manager_id"));
        return project;
    }
}
