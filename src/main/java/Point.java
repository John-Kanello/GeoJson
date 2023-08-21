public class Point extends GeometryObject<Position> {

    String type;

    public Point(Position coordinates, String type) {
        this.setCoordinates(coordinates);
        this.type = "Point";
    }

    public Point() {
        this.type = "Point";
    }

    @Override
    public String toString() {
        return "Point{" +
                "coordinates=" + coordinates +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public Position getCoordinates() {
        return super.getCoordinates();
    }

    @Override
    public void setCoordinates(Position coordinates) {
        super.setCoordinates(coordinates);
    }
}
