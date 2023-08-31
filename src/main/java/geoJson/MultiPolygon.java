package geoJson;

import com.fasterxml.jackson.annotation.JsonTypeName;
import exception.InvalidBboxException;
import exception.InvalidCoordinatesException;
import exception.InvalidLinearRingException;
import utils.impl.BboxManager;
import utils.impl.PolygonManager;

import java.util.List;

@JsonTypeName("MultiPolygon")
public class MultiPolygon extends GeometryObject<List<List<List<List<Float>>>>>{

    public MultiPolygon() {
        super("MultiPolygon");
    }

    public MultiPolygon(List<List<List<List<Float>>>> coordinates) {
        super("MultiPolygon", coordinates);
    }

    @Override
    public List<List<List<List<Float>>>> getCoordinates() {
        return super.getCoordinates();
    }

    @Override
    public void setCoordinates(List<List<List<List<Float>>>> coordinates) {

        if(coordinates == null || coordinates.isEmpty()) {
            throw new InvalidCoordinatesException();
        } else if(!new BboxManager().isValid(this)) {
            throw new InvalidBboxException();
        }

        for(var polygon : coordinates) {
            if(!new PolygonManager().isValid(polygon)) {
                throw new InvalidLinearRingException();
            }
        }

        super.setCoordinates(coordinates);
    }

    @Override
    public String toString() {
        return "MultiPolygon{" +
                "coordinates=" + coordinates +
                ", type='" + type + '\'' +
                ", bbox=" + bbox +
                '}';
    }
}
