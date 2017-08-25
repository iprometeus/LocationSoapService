package com.epam.lab.wrapper;

public interface ResponseMessage {
    String FIND_FRIENDS_BY_PLACE_FAILURE = "Friends are not found in this place.";
    String FIND_FRIENDS_BY_PLACE_SUCCESS = "Friends are found in this place.";
    String FIND_FRIENDS_BY_COORDINATES_FAILURE = "Friends are not found by the coordinates.";
    String FIND_FRIENDS_BY_COORDINATES_SUCCESS = "Friends are found by the coordinates.";
    String ADD_PLACE_FAILURE = "Place is not added.";
    String ADD_PLACE_SUCCESS = "Place is added.";
    String FIND_NEAR_PLACES_BY_DISTANCE_FAILURE = "Friends are not found near you.";
    String FIND_NEAR_PLACES_BY_DISTANCE_SUCCESS = "Friends are found near you.";
    String CHECKIN_FAILURE = "User is not checked-in.";
    String CHECKIN_SUCCESS = "User is checked-in.";
}
