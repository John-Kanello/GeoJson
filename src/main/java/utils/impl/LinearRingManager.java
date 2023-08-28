package utils.impl;

import exception.InvalidLinearRingException;
import utils.GeometryManager;

import java.util.List;

public class LinearRingManager implements GeometryManager<List<List<Float>>> {
    @Override
    public boolean isValid(List<List<Float>> coordinates) {
        if(coordinates == null) {
            throw new NullPointerException("Value cannot be null");
        }

        if(coordinates.size() < 4 || !coordinates.get(0).equals(coordinates.get(coordinates.size() - 1))) {
            throw new InvalidLinearRingException();
        }

        return true;
    }
}
