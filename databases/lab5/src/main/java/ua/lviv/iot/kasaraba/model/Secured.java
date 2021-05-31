package ua.lviv.iot.kasaraba.model;

import javax.persistence.*;

@Entity
@Table(name = "secured", schema = "kasaraba_lab5")
public class Secured {
    private Integer cardNumber;
    private String password;

    @Id
    @Column(name = "card_number")
    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Secured that = (Secured) o;

        if (cardNumber != null ? !cardNumber.equals(that.cardNumber) : that.cardNumber != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cardNumber != null ? cardNumber.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public static String getHeaders() {
        return String.format("%-16s  %-16s",
                "cardNumber", "password");
    }

    @Override
    public String toString() {
        return String.format("%-16s  %-16s",
                cardNumber, password);
    }
}
