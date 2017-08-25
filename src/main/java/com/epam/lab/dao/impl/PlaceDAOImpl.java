package com.epam.lab.dao.impl;

import com.epam.lab.dao.PlaceDAO;
import com.epam.lab.domain.Place;
import com.epam.lab.util.JPAUtil;
import com.vividsolutions.jts.geom.Point;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import java.util.List;

public class PlaceDAOImpl implements PlaceDAO {

    @Override
    public Place findById(int id) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        Place place = entityManager.find(Place.class, id);
        entityManager.close();
        return place;
    }

    @Override
    public Place findByName(String name) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        TypedQuery<Place> query = entityManager.createQuery("SELECT p FROM Place p WHERE p.name = :name", Place.class);
        query.setParameter("name", name);
        Place place = query.getSingleResult();
        entityManager.close();
        return place;
    }

    @Override
    public Place findByCoordinates(Point coordinate) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        TypedQuery<Place> query = entityManager.createQuery("SELECT p FROM Place p WHERE p.coordinate = :coordinate", Place.class);
        query.setParameter("coordinate", coordinate);
        Place place = query.getSingleResult();
        entityManager.close();
        return place;
    }

    @Override
    public List<Place> findNearPlacesByDistance(Point currlocation, long distance) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_get_places_by_distance", Place.class);
        query.registerStoredProcedureParameter("location", Point.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("distance", Long.class, ParameterMode.IN);
        query.setParameter("location", currlocation);
        query.setParameter("distance", distance);
        query.execute();
        List<Place> places = query.getResultList();
        entityManager.close();
        return places;
    }

    @Override
    public Place add(Place place) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(place);
        entityManager.getTransaction().commit();
        entityManager.close();
        return place;
    }
}