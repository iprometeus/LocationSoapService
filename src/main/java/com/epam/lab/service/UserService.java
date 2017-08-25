package com.epam.lab.service;

import com.epam.lab.domain.User;
import com.vividsolutions.jts.geom.Point;

import java.util.List;

public interface UserService {

    List<User> findByPlace(String placeName);

    List<User> findByCoordinates(Point coordinates);

    User checkin(int userId, int placeId);
}
