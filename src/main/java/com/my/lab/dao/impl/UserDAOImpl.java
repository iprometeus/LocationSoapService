package com.epam.lab.dao.impl;

import com.epam.lab.dao.PlaceDAO;
import com.epam.lab.dao.UserDAO;
import com.epam.lab.domain.Place;
import com.epam.lab.domain.User;
import com.epam.lab.util.JPAUtil;
import com.vividsolutions.jts.geom.Point;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private PlaceDAO placeDAO;

    public UserDAOImpl() {
        placeDAO = new PlaceDAOImpl();
    }

    @Override
    public List<User> findByPlace(String placeName) {
        Place place = placeDAO.findByName(placeName);
        if (place == null) {
            return null;
        }
        return findUsers(place);
    }

    @Override
    public List<User> findByCoordinates(Point coordinates) {
        Place place = placeDAO.findByCoordinates(coordinates);
        if (place == null) {
            return null;
        }
        return findUsers(place);
    }

    @Override
    public User checkin(int userId, int placeId) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Place place = placeDAO.findById(placeId);
        User user = entityManager.find(User.class, userId);
        user.setPlace(place);
        entityManager.getTransaction().commit();
        entityManager.close();
        return user;
    }

    private List<User> findUsers(Place place) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.place = :place", User.class);
        query.setParameter("place", place);
        List<User> users = query.getResultList();
        entityManager.close();
        return users;
    }
}