package geoJson;

import com.fasterxml.jackson.annotation.JsonTypeName;
import exception.InvalidBboxException;
import utils.impl.BboxManager;

import java.util.List;

@JsonTypeName("LineString")
public class LineString extends GeometryObject<List<List<Float>>> {

    public LineString() {
        super("LineString");
    }

    public LineString(String type) {
        super(type);
    }

    public LineString(List<List<Float>> coordinates) {
        super("LineString", coordinates);
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
        return "LineString{" +
                "coordinates=" + coordinates +
                ", type='" + type + '\'' +
                ", bbox=" + bbox +
                '}';
    }
}