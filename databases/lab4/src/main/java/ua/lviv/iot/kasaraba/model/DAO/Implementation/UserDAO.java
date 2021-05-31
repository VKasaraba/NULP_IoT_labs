package ua.lviv.iot.kasaraba.model.DAO.Implementation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ua.lviv.iot.kasaraba.model.DAO.CommonDAOInterface;
import ua.lviv.iot.kasaraba.model.User;

import static ua.lviv.iot.kasaraba.persistent.ConnectionManager.getConnection;

public class UserDAO implements CommonDAOInterface<User, Integer> {
    private static final String getAllUsersQuery = "SELECT id, first_name, last_name, email, " +
            "year_of_registration FROM kasaraba_db.user;";
    private static final String getUserByIdQuery = "SELECT id, first_name, last_name, email, " +
            "year_of_registration FROM kasaraba_db.user WHERE id=?;";
    private static final String deleteUserByIdQuery = "DELETE FROM kasaraba_db.user WHERE id=?;";
    private static final String updateUserByIdQuery = "UPDATE kasaraba_db.user SET first_name=?, " +
            "last_name=?, email=?, year_of_registration=? WHERE id=?;";
    private static final String addUserQuery = "INSERT INTO kasaraba_db.user" +
            "(first_name, last_name, email, year_of_registration) VALUES (?, ?, ?, ?);";

    private User getUserFromRS(final ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String email = rs.getString("email");
        int yearOfRegistration = rs.getInt("year_of_registration");


        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setYearOfRegistration(yearOfRegistration);
        user.setEmail(email);

        return user;
    }

    @Override
    public List<User> getAll() throws SQLException {
        List<User> users = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(getAllUsersQuery)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = getUserFromRS(rs);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getById(Integer id) throws SQLException {
        User found_user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getUserByIdQuery)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                found_user = getUserFromRS(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return found_user;
    }

    @Override
    public int add(User entity) throws SQLException {
        int result = -1;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(addUserQuery)) {
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setString(3, entity.getEmail());
            preparedStatement.setInt(4, entity.getYearOfRegistration());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(User entity) throws SQLException {
        int result = -1;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateUserByIdQuery)) {
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setString(3, entity.getEmail());
            preparedStatement.setInt(4, entity.getYearOfRegistration());
            preparedStatement.setInt(5, entity.getId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(Integer id) throws SQLException {
        int result = -1;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteUserByIdQuery)) {
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException ex) {
            System.out.println("A value in this row is a foreign key in another table. Please firstly delete the " +
                    "depending row.");
            ex.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
