package ua.lviv.iot.kasaraba.model;

public class Author {
    private int id;

    public Author(int id) {
        this.id = id;
    }

    public Author() {
    }

    @Override
    public String toString() {
        return "id= " + id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
