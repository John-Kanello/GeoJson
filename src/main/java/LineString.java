import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;

@JsonTypeName("LineString")
public class LineString extends GeometryObject<List<List<Float>>> {

    public LineString() {
        this.type = "LineString";
    }

    public LineString(List<List<Float>> coordinates) {
        super(coordinates, "LineString");
    }

    @Override
    public String toString() {
        return "LineString{" +
                "coordinates=" + coordinates +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public List<List<Float>> getCoordinates() {
        return super.getCoordinates();
    }

    @Override
    public void setCoordinates(List<List<Float>> coordinates) {
        super.setCoordinates(coordinates);
    }
}
