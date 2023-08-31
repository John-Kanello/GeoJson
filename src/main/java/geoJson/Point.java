package geoJson;

import com.fasterxml.jackson.annotation.JsonTypeName;
import exception.InvalidBboxException;
import exception.InvalidCoordinatesException;
import utils.impl.BboxManager;

import java.util.List;

@JsonTypeName("Point")
public class Point extends GeometryObject<List<Float>> {

    public Point() {
        super("Point");
    }

    public Point(List<Float> coordinates) {
        super("Point");
        this.setCoordinates(coordinates);
    }

    @Override
    public List<Float> getCoordinates() {
        return super.getCoordinates();
    }

    @Override
    public void setCoordinates(List<Float> coordinates) {
        if(coordinates == null || coordinates.isEmpty()) {
            throw new InvalidCoordinatesException();
        } else if(!new BboxManager().isValid(this)) {
            throw new InvalidBboxException();
        }

        super.setCoordinates(coordinates);
    }

    @Override
    public String toString() {
        return "Point{" +
                "coordinates=" + coordinates +
                ", type='" + type + '\'' +
                ", bbox=" + bbox +
                '}';
    }
}
