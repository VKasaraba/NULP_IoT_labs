package ua.lviv.iot.kasaraba.view;

import java.sql.SQLException;

@FunctionalInterface
public interface Printable {
    void print() throws SQLException, ClassNotFoundException;
}
