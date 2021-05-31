package ua.lviv.iot.kasaraba.DAO.queries;

public class QueryManger {
    private final String className;

    public QueryManger(String className) {
        this.className = className;
    }

    public String getFindAllQuery() {
        return "FROM " + className;
    }

    public String getFindByIdQuery() {
        return String.format("FROM %s  WHERE id = :id", className);
    }

    public String getDeleteByIdQuery() {
        return String.format("DELETE %s where id = :id", className);
    }
}
