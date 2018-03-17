package com.epam.lab.wrapper;

import com.epam.lab.domain.Place;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "places")
@XmlAccessorType(XmlAccessType.FIELD)
public class Places {

    private List<Place> places = null;

    public Places() {
    }

    public Places(List<Place> places) {
        this.places = places;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }
}
