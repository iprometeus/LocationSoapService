package com.epam.lab.service;

import com.epam.lab.domain.Place;
import com.vividsolutions.jts.geom.Point;

import java.util.List;

public interface PlaceService {

    Place add(final Place place);

    Place findById(int id);

    Place findByName(String name);

    List<Place> findNearPlacesByDistance(Point location, long distance);

    Place findByCoordinates(Point coordinates);
}