package by.issue_tracker.dao;

import by.issue_tracker.db.DbWorker;

import java.sql.Connection;
import java.util.List;

public abstract class DAO<E, K> {
    private DbWorker dbWorker;
    private Connection connection;

    public DAO() {
        dbWorker = new DbWorker();
        connection = dbWorker.getConnection();
    }

    public abstract List<E> getAll();
    public abstract E update(E entity);
    public abstract E getEntityById(K id);
    public abstract boolean delete(K id);
    public abstract boolean create(E entity);

    public void closeConnection() {
        dbWorker.closeConnection(connection);
    }

    @Override
    protected void finalize() throws Throwable {
        closeConnection();
        super.finalize();
    }
}