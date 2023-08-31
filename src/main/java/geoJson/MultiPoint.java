package geoJson;

import com.fasterxml.jackson.annotation.JsonTypeName;
import exception.InvalidBboxException;
import exception.InvalidCoordinatesException;
import utils.impl.BboxManager;

import java.util.List;

@JsonTypeName("MultiPoint")
public class MultiPoint extends GeometryObject<List<List<Float>>> {

    public MultiPoint() {
        super("MultiPoint");
    }

    public MultiPoint(List<List<Float>> coordinates) {
        super("MultiPoint", coordinates);
    }

    @Override
    public List<List<Float>> getCoordinates() {
        return super.getCoordinates();
    }

    @Override
    public void setCoordinates(List<List<Float>> coordinates) {
        if(coordinates == null || coordinates.isEmpty()) {
            throw new InvalidCoordinatesException();
        } else if(!new BboxManager().isValid(this)) {
            throw new InvalidBboxException();
        }

        super.setCoordinates(coordinates);
    }

    @Override
    public String toString() {
        return "MultiPoint{" +
                "coordinates=" + coordinates +
                ", type='" + type + '\'' +
                ", bbox=" + bbox +
                '}';
    }
}
