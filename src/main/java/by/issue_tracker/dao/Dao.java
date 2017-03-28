package by.issue_tracker.dao;

import by.issue_tracker.dao.exception.DaoException;
import by.issue_tracker.db.DbWorker;

import java.sql.Connection;
import java.util.List;

public abstract class Dao {
    private DbWorker dbWorker;
    protected Connection connection;

    public Dao() {
        dbWorker = new DbWorker();
        connection = dbWorker.getConnection();
    }

    public void closeConnection() {
        dbWorker.closeConnection(connection);
    }

    @Override
    protected void finalize() throws Throwable {
        closeConnection();
        super.finalize();
    }
}