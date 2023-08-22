import com.fasterxml.jackson.annotation.JsonTypeName;

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
    public String toString() {
        return "MultiPolygon{" +
                "coordinates=" + coordinates +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public List<List<List<List<Float>>>> getCoordinates() {
        return super.getCoordinates();
    }

    @Override
    public void setCoordinates(List<List<List<List<Float>>>> coordinates) {
        super.setCoordinates(coordinates);
    }
}
