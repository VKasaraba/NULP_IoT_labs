package ua.lviv.iot.kasaraba.model;

import javax.persistence.*;

@Entity
@Table(name = "author", schema = "kasaraba_lab5")
public class Author {
    private Integer id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Author(Integer id) {
        this.id = id;
    }

    public Author() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author that = (Author) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public static String getHeaders() {
        return "id";
    }

    @Override
    public String toString() {
        return String.format("%s", id);
    }
}
