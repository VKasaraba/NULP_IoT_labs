package ua.lviv.iot.kasaraba.controller;

import java.sql.SQLException;
import java.util.List;
import ua.lviv.iot.kasaraba.service.CommonServiceInterface;

public interface CommonControllerInterface<T> {
    int add(T entity) throws SQLException;

    int update(T entity) throws SQLException;

    int delete(int id) throws SQLException;

    List<T> getAll() throws SQLException;

    T getById(int id) throws SQLException;

    CommonServiceInterface<T> getService();
}
