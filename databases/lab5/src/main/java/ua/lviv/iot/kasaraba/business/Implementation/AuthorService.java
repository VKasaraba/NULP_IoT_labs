package ua.lviv.iot.kasaraba.business.Implementation;

import ua.lviv.iot.kasaraba.DAO.CommonDAO;
import ua.lviv.iot.kasaraba.DAO.Implementation.ApplicationDAO;
import ua.lviv.iot.kasaraba.DAO.Implementation.AuthorDAO;
import ua.lviv.iot.kasaraba.business.CommonService;
import ua.lviv.iot.kasaraba.model.Application;
import ua.lviv.iot.kasaraba.model.Author;

public class AuthorService implements CommonService<Author, Integer> {
    private CommonDAO authorDAO = new AuthorDAO();

    @Override
    public CommonDAO<Author, Integer> getDAO() {
        return authorDAO;
    }
}
