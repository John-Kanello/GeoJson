
public class Polygon extends GeometryObject<LinearRing> {

    public Polygon(LinearRing coordinates) {
        super(coordinates, "Polygon");
    }

    @Override
    public String toString() {
        return "Polygon{" +
                "coordinates=" + getCoordinates() +
                ", type=" + type +
                '}';
    }
}
