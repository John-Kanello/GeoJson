package geoJson;

import com.fasterxml.jackson.annotation.JsonTypeName;
import exception.InvalidBboxException;
import utils.impl.BboxManager;
import utils.impl.LinearRingManager;

import java.util.List;


@JsonTypeName("LinearRing")
public class LinearRing extends LineString {

    public LinearRing() {
       super("LinearRing");
    }

    public LinearRing(List<List<Float>> coordinates) {
        super("LinearRing");
        LinearRingManager linearRingManager = new LinearRingManager();
        if(!linearRingManager.isValid(coordinates)) {
            throw new RuntimeException();
        }
        this.coordinates = coordinates;
    }

    @Override
    public List<List<Float>> getCoordinates() {
        return super.getCoordinates();
    }

    @Override
    public void setCoordinates(List<List<Float>> coordinates) {
        super.setCoordinates(coordinates);
        if(!new BboxManager().isValid(this)) {
            throw new InvalidBboxException();
        }
    }

    @Override
    public String toString() {
        return "LinearRing{" +
                "coordinates=" + coordinates +
                ", type='" + type + '\'' +
                ", bbox=" + bbox +
                '}';
    }
}
