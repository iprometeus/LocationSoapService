package com.epam.lab.util;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

public class GeometryUtil {

    public static Point createPoint(double x, double y) {
        GeometryFactory gf = new GeometryFactory();
        Coordinate coord = new Coordinate(x, y);
        return gf.createPoint(coord);
    }
}
