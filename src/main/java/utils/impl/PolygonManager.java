package utils.impl;

import exception.InvalidLinearRingException;
import utils.GeometryManager;

import java.util.List;

public class PolygonManager implements GeometryManager<List<List<List<Float>>>> {

    @Override
    public boolean isValid(List<List<List<Float>>> coordinates) {

        if(coordinates == null || coordinates.isEmpty()) {
            return false;
        }

        for(var linearRing : coordinates) {
            if(linearRing.size() < 4 || !linearRing.get(0).equals(linearRing.get(linearRing.size() - 1))) {
                return false;
            }
        }

        return true;
    }
}
