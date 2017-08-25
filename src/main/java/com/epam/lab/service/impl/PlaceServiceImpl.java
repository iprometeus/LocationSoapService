package com.epam.lab.service.impl;

import com.epam.lab.dao.PlaceDAO;
import com.epam.lab.dao.impl.PlaceDAOImpl;
import com.epam.lab.domain.Place;
import com.epam.lab.service.PlaceService;
import com.vividsolutions.jts.geom.Point;

import java.util.List;

public class PlaceServiceImpl implements PlaceService {

    private PlaceDAO placeDAO;

    public PlaceServiceImpl() {
        placeDAO = new PlaceDAOImpl();
    }

    @Override
    public Place add(Place book) {
        return placeDAO.add(book);
    }

    @Override
    public Place findById(int id) {
        return placeDAO.findById(id);
    }

    @Override
    public Place findByName(String name) {
        return placeDAO.findByName(name);
    }

    @Override
    public List<Place> findNearPlacesByDistance(Point location, long distance) {
        return placeDAO.findNearPlacesByDistance(location, distance);
    }

    @Override
    public Place findByCoordinates(Point coordinates) {
        return placeDAO.findByCoordinates(coordinates);
    }
}
