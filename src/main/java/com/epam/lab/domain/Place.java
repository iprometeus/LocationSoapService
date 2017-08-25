package com.epam.lab.domain;

import com.vividsolutions.jts.geom.Point;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "place")
@XmlRootElement(name = "place")
public class Place {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PlaceType type;

    @Column(name = "coordinate", columnDefinition = "Point")
    private Point coordinate;

    public Place() {
    }

    public Place(String name, PlaceType type, Point coordinate) {
        this.name = name;
        this.type = type;
        this.coordinate = coordinate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlaceType getType() {
        return type;
    }

    public void setType(PlaceType type) {
        this.type = type;
    }

    public Point getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Point coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public String toString() {
        return String.format("Place{ id=%d, name='%s\', type='%s\', coordinate='%s\'}",
                id, name, type, coordinate.toString());
    }
}
