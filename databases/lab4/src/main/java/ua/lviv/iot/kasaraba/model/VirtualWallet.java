package ua.lviv.iot.kasaraba.model;

public class VirtualWallet {
    private int id;
    private String securedCardNumber;
    private int balanceInDol;
    private int userId;

    public VirtualWallet(int id, String securedCardNumber, int balanceInDol, int userId) {
        this.id = id;
        this.securedCardNumber = securedCardNumber;
        this.balanceInDol = balanceInDol;
        this.userId = userId;
    }

    public VirtualWallet(String securedCardNumber, int balanceInDol, int userId) {
        this.securedCardNumber = securedCardNumber;
        this.balanceInDol = balanceInDol;
        this.userId = userId;
    }

    public VirtualWallet() {
    }

    @Override
    public String toString() {
        return "id= " + id +
                "\t secured_card_number= " + securedCardNumber +
                "\t balance_in_dol= " + balanceInDol +
                "\t user_id= " + userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSecuredCardNumber() {
        return securedCardNumber;
    }

    public void setSecuredCardNumber(String securedCardNumber) {
        this.securedCardNumber = securedCardNumber;
    }

    public int getBalanceInDol() {
        return balanceInDol;
    }

    public void setBalanceInDol(int balanceInDol) {
        this.balanceInDol = balanceInDol;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
