package ua.lviv.iot.kasaraba.DAO;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.lviv.iot.kasaraba.DAO.queries.QueryManger;
import ua.lviv.iot.kasaraba.persistence.SessionManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CommonDAO<T, ID> {

    QueryManger getQueryManger();

    default List<T> findAll() throws SQLException {
        List<T> entityList = new ArrayList<>();
        try (Session session = SessionManager.getSession()) {
            Query query = session.createQuery(getQueryManger().getFindAllQuery());
            for (Object entity : query.list()) {
                entityList.add((T) entity);
            }
            return entityList;
        }
    }

    default T findById(ID id) throws SQLException {

        try (Session session = SessionManager.getSession()) {
            Query query = session.createQuery(getQueryManger().getFindByIdQuery());
            query.setParameter("id", id);
            return (T) query.uniqueResult();
        }
    }

    default int create(T entity) throws SQLException {
        try (Session session = SessionManager.getSession()) {
            int id = (int) session.save(entity);
            session.close();
            return id;
        }
    }

    default void update(T entity) throws SQLException {

        try (Session session = SessionManager.getSession()) {
            session.beginTransaction();
            session.update(entity);

            session.getTransaction().commit();
            session.close();
        }
    }

    default int delete(ID id) throws SQLException {

        try (Session session = SessionManager.getSession()) {
            session.beginTransaction();
            Query query = session.createQuery(getQueryManger().getDeleteByIdQuery());
            query.setParameter("id", id);
            Integer res = query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            return res;
        }
    }
}