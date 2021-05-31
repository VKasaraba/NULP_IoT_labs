package ua.lviv.iot.kasaraba.model;

public class Application {
    private int id;
    private String name;
    private int authorId;
    private int releaseYear;
    private int priceInDol;

    public Application(int id, String name, int authorId, int releaseYear, int priceInDol) {
        this.id = id;
        this.name = name;
        this.authorId = authorId;
        this.releaseYear = releaseYear;
        this.priceInDol = priceInDol;
    }

    public Application(String name, int authorId, int releaseYear, int priceInDol) {
        this.name = name;
        this.authorId = authorId;
        this.releaseYear = releaseYear;
        this.priceInDol = priceInDol;
    }

    public Application() {
    }

    @Override
    public String toString() {
        return "id= " + id + "\t name= " + name + "\t author id= " + authorId + "\t release year= " + releaseYear +
                "\t price in dollars= " + priceInDol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getPriceInDol() {
        return priceInDol;
    }

    public void setPriceInDol(int priceInDol) {
        this.priceInDol = priceInDol;
    }
}
