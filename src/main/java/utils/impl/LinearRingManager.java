package utils.impl;

import exception.InvalidLinearRingException;
import utils.Manager;

import java.util.List;

public class LinearRingManager implements Manager<List<List<Float>>> {
    @Override
    public boolean isValid(List<List<Float>> coordinates) {
        if(coordinates == null) {
            throw new NullPointerException("Value cannot be null");
        }

        for(var linearRing : coordinates) {
            if(linearRing == null || linearRing.size() < 4 || !linearRing.get(0).equals(linearRing.get(linearRing.size() - 1))) {
                throw new InvalidLinearRingException();
            }
        }
        return true;
    }
}
