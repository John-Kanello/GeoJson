import java.util.List;

public class MultiPolygon extends GeometryObject<List<Polygon>>{

    public MultiPolygon(List<Polygon> coordinates) {
        super(coordinates, "MultiPolygon");
    }

    @Override
    public String toString() {
        return "MultiPolygon{" +
                "coordinates=" + getCoordinates() +
                ", type=" + type +
                '}';
    }

    @Override
    public List<Polygon> getCoordinates() {
        return super.getCoordinates();
    }

    @Override
    public void setCoordinates(List<Polygon> coordinates) {
        super.setCoordinates(coordinates);
    }
}
