package ua.lviv.iot.kasaraba.business;

import ua.lviv.iot.kasaraba.DAO.CommonDAO;

import java.sql.SQLException;
import java.util.List;

public interface CommonService<T, ID> {
    CommonDAO<T, ID> getDAO();

    default List<T> findAll() throws SQLException {
        return getDAO().findAll();
    }

    default T findById(ID id) throws SQLException {
        return getDAO().findById(id);
    }

    default int create(T entity) throws SQLException {
        return getDAO().create(entity);
    }

    default void update(T entity) throws SQLException {
        getDAO().update(entity);
    }

    default int delete(ID id) throws SQLException {
        return getDAO().delete(id);
    }
}
