package ua.lviv.iot.kasaraba.service;

import ua.lviv.iot.kasaraba.model.DAO.CommonDAOInterface;

import java.sql.SQLException;
import java.util.List;

public interface CommonServiceInterface<T> {
    CommonDAOInterface<T, Integer> getDAO();

    List<T> getAll() throws SQLException;

    T getById(Integer id) throws SQLException;

    int add(T entity) throws SQLException;

    int update(T entity) throws SQLException;

    int delete(Integer id) throws SQLException;
}
