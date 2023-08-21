import java.util.List;

public class MultiPoint extends GeometryObject<List<Position>> {

    public MultiPoint() {
        this.type = "MultiPoint";
    }

    public MultiPoint(List<Position> coordinates) {
        super(coordinates, "MultiPoint");
    }

    @Override
    public String toString() {
        return "MultiPoint{" +
                "coordinates=" + getCoordinates() +
                ", type=" + type +
                '}';
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
