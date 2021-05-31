package ua.lviv.iot.kasaraba.model;

import ua.lviv.iot.kasaraba.DAO.Implementation.SecuredDAO;
import ua.lviv.iot.kasaraba.DAO.Implementation.UserDAO;

import javax.persistence.*;
import java.sql.SQLException;

@Entity
@Table(name = "virtual_wallet", schema = "kasaraba_lab5")
public class VirtualWallet {
    private final UserDAO userDAO = new UserDAO();
    private final SecuredDAO securedDAO = new SecuredDAO();
    private Integer id;
    private Integer balanceInDol;
    private String subscriptionPlan;
    private Byte payAutomatically;
    private Secured securedBySecuredCardNumber;
    private User userByUserId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "balance_in_dol")
    public Integer getBalanceInDol() {
        return balanceInDol;
    }

    public void setBalanceInDol(Integer balanceInDol) {
        this.balanceInDol = balanceInDol;
    }

    @Basic
    @Column(name = "subscription_plan")
    public String getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public void setSubscriptionPlan(String subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }

    @Basic
    @Column(name = "pay_automaticly")
    public Byte getPayAutomatically() {
        return payAutomatically;
    }

    public void setPayAutomatically(Byte payAutomaticly) {
        this.payAutomatically = payAutomaticly;
    }

    public VirtualWallet(Integer id, Integer balanceInDol, String subscriptionPlan, Byte payAutomatically, Integer securedCardNumberId, Integer userId) throws SQLException {
        this.id = id;
        this.balanceInDol = balanceInDol;
        this.subscriptionPlan = subscriptionPlan;
        this.payAutomatically = payAutomatically;
        this.securedBySecuredCardNumber = securedDAO.findById(securedCardNumberId);
        this.userByUserId = userDAO.findById(userId);
    }

    public VirtualWallet(Integer balanceInDol, String subscriptionPlan, Byte payAutomatically, Integer securedCardNumberId, Integer userId) throws SQLException {
        this.balanceInDol = balanceInDol;
        this.subscriptionPlan = subscriptionPlan;
        this.payAutomatically = payAutomatically;
        this.securedBySecuredCardNumber = securedDAO.findById(securedCardNumberId);
        this.userByUserId = userDAO.findById(userId);
    }

    public VirtualWallet() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VirtualWallet that = (VirtualWallet) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (balanceInDol != null ? !balanceInDol.equals(that.balanceInDol) : that.balanceInDol != null) return false;
        if (subscriptionPlan != null ? !subscriptionPlan.equals(that.subscriptionPlan) : that.subscriptionPlan != null)
            return false;
        if (payAutomatically != null ? !payAutomatically.equals(that.payAutomatically) : that.payAutomatically != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (balanceInDol != null ? balanceInDol.hashCode() : 0);
        result = 31 * result + (subscriptionPlan != null ? subscriptionPlan.hashCode() : 0);
        result = 31 * result + (payAutomatically != null ? payAutomatically.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "secured_card_number", referencedColumnName = "card_number", nullable = false)
    public Secured getSecuredBySecuredCardNumber() {
        return securedBySecuredCardNumber;
    }

    public void setSecuredBySecuredCardNumber(Secured securedBySecuredCardNumber) {
        this.securedBySecuredCardNumber = securedBySecuredCardNumber;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    public static String getHeaders() {
        return String.format("%-3s  %-18s %-18s %-18s %-18s %-10s",
                "id", "balanceInDol", "subscriptionPlan", "payAutomatically", "cardNumber", "userId");
    }

    @Override
    public String toString() {
        return String.format("%-3s  %-18s %-18s %-18s %-18s %-10s",
                id, balanceInDol, subscriptionPlan, payAutomatically, securedBySecuredCardNumber.getCardNumber(), userByUserId.getId());
    }
}
