package ua.lviv.iot.kasaraba.model.DAO.Implementation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ua.lviv.iot.kasaraba.model.DAO.CommonDAOInterface;
import ua.lviv.iot.kasaraba.model.VirtualWallet;

import static ua.lviv.iot.kasaraba.persistent.ConnectionManager.getConnection;

public class VirtualWalletDAO implements CommonDAOInterface<VirtualWallet, Integer> {
    private static final String getAllVirtualWalletsQuery = "SELECT id, secured_card_number, balance_in_dol, user_id " +
            "FROM kasaraba_db.virtual_wallet;";
    private static final String getVirtualWalletByIdQuery = "SELECT id, secured_card_number, balance_in_dol, user_id" +
            " FROM kasaraba_db.virtual_wallet WHERE id=?;";
    private static final String deleteVirtualWalletByIdQuery = "DELETE FROM kasaraba_db.virtual_wallet WHERE id=?;";
    private static final String updateVirtualWalletByIdQuery = "UPDATE kasaraba_db.virtual_wallet SET " +
            "secured_card_number=?, balance_in_dol=?, user_id=? WHERE id=?;";
    private static final String addVirtualWalletQuery = "INSERT INTO kasaraba_db.virtual_wallet" +
            "(secured_card_number, balance_in_dol, user_id) VALUES (?, ?, ?);";

    private VirtualWallet getVirtualWalletFromRS(final ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int userId = rs.getInt("user_id");
        String securedCardNumber = rs.getString("secured_card_number");
        int balanceInDol = rs.getInt("balance_in_dol");


        VirtualWallet virtualWallet = new VirtualWallet();
        virtualWallet.setBalanceInDol(balanceInDol);
        virtualWallet.setId(id);
        virtualWallet.setSecuredCardNumber(securedCardNumber);
        virtualWallet.setUserId(userId);

        return virtualWallet;
    }


    @Override
    public List<VirtualWallet> getAll() throws SQLException {
        List<VirtualWallet> virtualWallets = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(getAllVirtualWalletsQuery)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                VirtualWallet virtualWallet = getVirtualWalletFromRS(rs);
                virtualWallets.add(virtualWallet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return virtualWallets;
    }

    @Override
    public VirtualWallet getById(Integer id) throws SQLException {
        VirtualWallet found_virtualWallet = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getVirtualWalletByIdQuery)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                found_virtualWallet = getVirtualWalletFromRS(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return found_virtualWallet;
    }

    @Override
    public int add(VirtualWallet entity) throws SQLException {
        int result = -1;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(addVirtualWalletQuery)) {
            preparedStatement.setString(1, entity.getSecuredCardNumber());
            preparedStatement.setInt(2, entity.getBalanceInDol());
            preparedStatement.setInt(3, entity.getUserId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(VirtualWallet entity) throws SQLException {
        int result = -1;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateVirtualWalletByIdQuery)) {
            preparedStatement.setString(1, entity.getSecuredCardNumber());
            preparedStatement.setInt(2, entity.getBalanceInDol());
            preparedStatement.setInt(3, entity.getUserId());
            preparedStatement.setInt(4, entity.getId());
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
             PreparedStatement preparedStatement = connection.prepareStatement(deleteVirtualWalletByIdQuery)) {
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

