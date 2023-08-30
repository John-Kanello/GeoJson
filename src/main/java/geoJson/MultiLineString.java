package geoJson;

import com.fasterxml.jackson.annotation.JsonTypeName;
import exception.InvalidBboxException;
import utils.impl.BboxManager;

import java.util.List;

@JsonTypeName("MultiLineString")
public class MultiLineString extends GeometryObject<List<List<List<Float>>>> {

    public MultiLineString() {
        super("MultiLineString");
    }

    public MultiLineString(List<List<List<Float>>> coordinates) {
        super("MultiLineString", coordinates);
    }

    @Override
    public List<List<List<Float>>> getCoordinates() {
        return super.getCoordinates();
    }

    @Override
    public void setCoordinates(List<List<List<Float>>> coordinates) {
        super.setCoordinates(coordinates);
        if(!new BboxManager().isValid(this)) {
            throw new InvalidBboxException();
        }
    }

    @Override
    public String toString() {
        return "MultiLineString{" +
                "coordinates=" + coordinates +
                ", type='" + type + '\'' +
                ", bbox=" + bbox +
                '}';
    }
}
