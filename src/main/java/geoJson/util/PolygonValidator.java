package geoJson.util;

import geoJson.Polygon;

public class PolygonValidator  {

    public static boolean isValid(Polygon polygon) {
        if(polygon == null) {
            return false;
        }
        var coordinates = polygon.getCoordinates();
        if (coordinates == null || coordinates.isEmpty()) {
            return false;
        }
        for (var linearRing : coordinates) {
            if (linearRing == null || linearRing.size() < 4 || !linearRing.get(0).equals(linearRing.get(linearRing.size() - 1))) {
                return false;
            }
        }
        return true;
    }
}