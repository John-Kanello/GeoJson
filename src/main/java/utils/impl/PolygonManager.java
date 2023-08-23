package utils.impl;

import exception.InvalidLinearRingException;
import utils.Manager;

import java.util.List;

public class PolygonManager implements Manager<List<List<List<Float>>>> {

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
