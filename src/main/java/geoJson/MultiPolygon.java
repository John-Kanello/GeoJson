package geoJson;

import com.fasterxml.jackson.annotation.JsonTypeName;
import geoJson.exceptions.InvalidBboxException;
import geoJson.exceptions.InvalidCoordinatesException;
import geoJson.exceptions.InvalidLinearRingException;
import geoJson.util.BboxValidator;
import geoJson.util.PolygonValidator;

import java.util.List;

@JsonTypeName("geoJson.MultiPolygon")
public class MultiPolygon extends GeometryObject<List<List<List<List<Float>>>>> {

    public MultiPolygon() {
        super("geoJson.MultiPolygon");
    }

    public MultiPolygon(List<List<List<List<Float>>>> coordinates) {
        super("geoJson.MultiPolygon", coordinates);
    }

    @Override
    public List<List<List<List<Float>>>> getCoordinates() {
        return super.getCoordinates();
    }

    @Override
    public void setCoordinates(List<List<List<List<Float>>>> coordinates) {

        if (coordinates == null || coordinates.isEmpty()) {
            throw new InvalidCoordinatesException();
        } else if (!BboxValidator.isValid(this)) {
            throw new InvalidBboxException();
        }
        for (var polygon : coordinates) {
            Polygon p = new Polygon(polygon);
            if (PolygonValidator.isValid(p)) {
                throw new InvalidLinearRingException();
            }

            if(BboxValidator.isValid(p)) {
                throw new InvalidBboxException();
            }
        }

        super.setCoordinates(coordinates);
    }

    @Override
    public String toString() {
        return "geoJson.MultiPolygon{" +
                "coordinates=" + coordinates +
                ", type='" + type + '\'' +
                ", bbox=" + bbox +
                '}';
    }
}