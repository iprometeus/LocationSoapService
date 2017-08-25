package com.epam.lab.dao;

import com.epam.lab.domain.Place;
import com.vividsolutions.jts.geom.Point;

import java.util.List;

public interface PlaceDAO {

    List<Place> findNearPlacesByDistance(Point location, long distance);

    Place add(final Place book);

    Place findById(int id);

    Place findByName(String name);

    Place findByCoordinates(Point coordinates);
}
