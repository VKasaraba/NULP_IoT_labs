package ua.lviv.iot.kasaraba.model.DAO.Implementation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ua.lviv.iot.kasaraba.model.DAO.CommonDAOInterface;
import ua.lviv.iot.kasaraba.model.Organization;

import static ua.lviv.iot.kasaraba.persistent.ConnectionManager.getConnection;

public class OrganizationDAO implements CommonDAOInterface<Organization, Integer> {
    private static final String getAllOrganizationsQuery = "SELECT * FROM kasaraba_db.organization;";
    private static final String getOrganizationByIdQuery = "SELECT * FROM kasaraba_db.organization WHERE author_id=?;";
    private static final String deleteOrganizationByIdQuery = "DELETE FROM kasaraba_db.organization WHERE author_id=?;";
    private static final String updateOrganizationByIdQuery = "UPDATE kasaraba_db.organization SET name=? " +
            "WHERE author_id=?;";
    private static final String addOrganizationQuery = "INSERT INTO kasaraba_db.organization" +
            "(name, author_id) VALUES (?, ?);";

    private Organization getOrganizationFromRS(final ResultSet rs) throws SQLException {
        int authorId = rs.getInt("author_id");
        String name = rs.getString("name");


        Organization organization = new Organization();
        organization.setName(name);
        organization.setAuthorId(authorId);

        return organization;
    }

    @Override
    public List<Organization> getAll() throws SQLException {
        List<Organization> organizations = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(getAllOrganizationsQuery)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Organization organization = getOrganizationFromRS(rs);
                organizations.add(organization);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return organizations;
    }

    @Override
    public Organization getById(Integer author_id) {
        Organization found_organization = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getOrganizationByIdQuery)) {
            preparedStatement.setInt(1, author_id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                found_organization = getOrganizationFromRS(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return found_organization;
    }

    @Override
    public int add(Organization entity) throws SQLException {
        int result = -1;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(addOrganizationQuery)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getAuthorId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Organization entity) throws SQLException {
        int result = -1;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateOrganizationByIdQuery)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getAuthorId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(Integer author_id) throws SQLException {
        int result = -1;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteOrganizationByIdQuery)) {
            preparedStatement.setInt(1, author_id);
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
