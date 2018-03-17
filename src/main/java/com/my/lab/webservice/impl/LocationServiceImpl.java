package com.epam.lab.webservice.impl;


import com.epam.lab.domain.Place;
import com.epam.lab.domain.PlaceType;
import com.epam.lab.domain.User;
import com.epam.lab.service.PlaceService;
import com.epam.lab.service.UserService;
import com.epam.lab.service.impl.PlaceServiceImpl;
import com.epam.lab.service.impl.UserServiceImpl;
import com.epam.lab.util.GeometryUtil;
import com.epam.lab.webservice.LocationService;
import com.epam.lab.wrapper.Places;
import com.epam.lab.wrapper.Response;
import com.epam.lab.wrapper.ResponseMessage;
import com.epam.lab.wrapper.Users;
import com.vividsolutions.jts.geom.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.jws.WebService;

@WebService(endpointInterface = "com.epam.lab.webservice.LocationService")
public class LocationServiceImpl implements LocationService {

    private final static Logger LOG = LogManager.getLogger(LocationService.class);
    private UserService userService;
    private PlaceService placeService;

    public LocationServiceImpl() {
        userService = new UserServiceImpl();
        placeService = new PlaceServiceImpl();
    }

    @Override
    public Response findFriendsByPlace(String placeName) {
        Users users = new Users(userService.findByPlace(placeName));
        if (users == null) {
            LOG.info(ResponseMessage.FIND_FRIENDS_BY_PLACE_FAILURE);
            return Response.failure(ResponseMessage.FIND_FRIENDS_BY_PLACE_FAILURE, users);
        }
        LOG.info(ResponseMessage.FIND_FRIENDS_BY_PLACE_SUCCESS);
        return Response.success(ResponseMessage.FIND_FRIENDS_BY_PLACE_SUCCESS, users);
    }

    @Override
    public Response findFriendsByCoordinates(double lat, double lon) {
        Point point = GeometryUtil.createPoint(lat, lon);
        Users users = new Users(userService.findByCoordinates(point));
        if (users == null) {
            LOG.info(ResponseMessage.FIND_FRIENDS_BY_COORDINATES_FAILURE);
            return Response.failure(ResponseMessage.FIND_FRIENDS_BY_COORDINATES_FAILURE, users);
        }
        LOG.info(ResponseMessage.FIND_FRIENDS_BY_COORDINATES_SUCCESS);
        return Response.success(ResponseMessage.FIND_FRIENDS_BY_COORDINATES_SUCCESS, users);
    }

    @Override
    public Response addPlace(String placeName, PlaceType placeType, double lat, double lon) {
        Place place = new Place(placeName, placeType, GeometryUtil.createPoint(lat, lon));
        placeService.add(place);
        if (place == null) {
            LOG.info(ResponseMessage.ADD_PLACE_FAILURE);
            return Response.failure(ResponseMessage.ADD_PLACE_FAILURE, place);
        }
        LOG.info(ResponseMessage.ADD_PLACE_SUCCESS);
        return Response.success(ResponseMessage.ADD_PLACE_SUCCESS, place);
    }

    @Override
    public Response findNearPlacesByDistance(double lat, double lon, long distance) {
        Point currLocation = GeometryUtil.createPoint(lat, lon);
        Places places = new Places(placeService.findNearPlacesByDistance(currLocation, distance));
        if (places == null) {
            LOG.info(ResponseMessage.FIND_NEAR_PLACES_BY_DISTANCE_FAILURE);
            return Response.failure(ResponseMessage.FIND_NEAR_PLACES_BY_DISTANCE_FAILURE, places);
        }
        LOG.info(ResponseMessage.FIND_NEAR_PLACES_BY_DISTANCE_SUCCESS);
        return Response.success(ResponseMessage.FIND_NEAR_PLACES_BY_DISTANCE_SUCCESS, places);
    }

    @Override
    public Response checkin(int userId, int placeId) {
        User user = userService.checkin(userId, placeId);
        if (user == null) {
            LOG.info(ResponseMessage.CHECKIN_FAILURE);
            return Response.failure(ResponseMessage.CHECKIN_FAILURE, user);
        }
        LOG.info(ResponseMessage.CHECKIN_SUCCESS);
        return Response.success(ResponseMessage.CHECKIN_SUCCESS, user);
    }
}