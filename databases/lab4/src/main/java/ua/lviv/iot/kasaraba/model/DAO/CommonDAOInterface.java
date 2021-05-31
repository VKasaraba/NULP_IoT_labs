package ua.lviv.iot.kasaraba.model.DAO;

import java.sql.SQLException;
import java.util.List;

public interface CommonDAOInterface<T, ID> {
    List<T> getAll() throws SQLException;

    T getById(ID id) throws SQLException;

    int add(T entity) throws SQLException;

    int update(T entity) throws SQLException;

    int delete(ID id) throws SQLException;

}
