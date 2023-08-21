import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;

@JsonTypeName("LineString")
public class LineString extends GeometryObject<List<Position>> {

    public LineString() {
        this.type = "LineString";
    }

    public LineString(List<Position> coordinates) {
        super(coordinates, "LineString");
    }

    @Override
    public String toString() {
        return "\"LineString[" +
                "coordinates=" + getCoordinates() +
                ", type=" + type +
                "]";
    }

    @Override
    public List<Position> getCoordinates() {
        return super.getCoordinates();
    }

    @Override
    public void setCoordinates(List<Position> coordinates) {
        super.setCoordinates(coordinates);
    }
}
