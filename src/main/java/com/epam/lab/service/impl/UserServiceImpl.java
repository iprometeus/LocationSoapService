package com.epam.lab.service.impl;

import com.epam.lab.dao.UserDAO;
import com.epam.lab.dao.impl.UserDAOImpl;
import com.epam.lab.domain.User;
import com.epam.lab.service.UserService;
import com.vividsolutions.jts.geom.Point;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl() {
        userDAO = new UserDAOImpl();
    }

    @Override
    public List<User> findByPlace(String placeName) {
        return userDAO.findByPlace(placeName);
    }

    @Override
    public List<User> findByCoordinates(Point coordinates) {
        return userDAO.findByCoordinates(coordinates);
    }

    @Override
    public User checkin(int userId, int placeId) {
        return userDAO.checkin(userId, placeId);
    }
}
