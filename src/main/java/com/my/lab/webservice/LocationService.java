package com.epam.lab.webservice;

import com.epam.lab.domain.PlaceType;
import com.epam.lab.wrapper.Response;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface LocationService {

    @WebMethod
    Response findFriendsByPlace(String placeName);

    @WebMethod
    Response findFriendsByCoordinates(double lat, double lon);

    @WebMethod
    Response addPlace(String placeName, PlaceType placeType, double lat, double lon);

    Response findNearPlacesByDistance(double lat, double lon, long distance);

    @WebMethod
    Response checkin(int userId, int placeId);
}
