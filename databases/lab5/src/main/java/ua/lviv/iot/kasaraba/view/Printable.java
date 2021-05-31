package ua.lviv.iot.kasaraba.view;

import java.io.IOException;
import java.sql.SQLException;

@FunctionalInterface
public interface Printable {
    void print() throws SQLException, ClassNotFoundException, IOException;
}
