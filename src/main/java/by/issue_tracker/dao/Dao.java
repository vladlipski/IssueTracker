package by.issue_tracker.dao;

import by.issue_tracker.dao.exception.DaoException;
import by.issue_tracker.db.DbWorker;

import java.sql.Connection;
import java.util.List;

public abstract class Dao<E, K> {
    private DbWorker dbWorker;
    protected Connection connection;

    public Dao() {
        dbWorker = new DbWorker();
        connection = dbWorker.getConnection();
    }

    public abstract List<E> getAll() throws DaoException;
    public abstract E update(E entity) throws DaoException;
    public abstract E getEntityById(K id) throws DaoException;
    public abstract boolean delete(K id) throws DaoException;
    public abstract boolean create(E entity) throws DaoException;

    public void closeConnection() {
        dbWorker.closeConnection(connection);
    }

    @Override
    protected void finalize() throws Throwable {
        closeConnection();
        super.finalize();
    }
}