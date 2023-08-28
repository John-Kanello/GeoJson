package utils.impl;

import exception.InvalidLinearRingException;
import utils.GeometryManager;

import java.util.List;

public class PolygonManager implements GeometryManager<List<List<List<Float>>>> {

    LinearRingManager linearRingManager = new LinearRingManager();

    @Override
    public boolean isValid(List<List<List<Float>>> coordinates) {
        for(var linearRing : coordinates) {
            if(!linearRingManager.isValid(linearRing)) {
                throw new InvalidLinearRingException();
            }
        }

        return true;
    }
}
