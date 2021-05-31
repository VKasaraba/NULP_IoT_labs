package ua.lviv.iot.kasaraba.model;

public class Organization {
    private String name;
    private int authorId;

    public Organization(String name, int author_id) {
        this.name = name;
        this.authorId = author_id;
    }

    public Organization() {
    }

    @Override
    public String toString() {
        return "name= " + name +
                "\t author_id=" + authorId;
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

    public void setAuthorId(int author_id) {
        this.authorId = author_id;
    }
}
