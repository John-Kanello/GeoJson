import com.fasterxml.jackson.annotation.JsonTypeName;

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
    public String toString() {
        return "Point{" +
                "coordinates=" + coordinates +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public List<Float> getCoordinates() {
        return super.getCoordinates();
    }

    @Override
    public void setCoordinates(List<Float> coordinates) {
        super.setCoordinates(coordinates);
    }
}
