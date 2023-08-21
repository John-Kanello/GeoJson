public class MultiLineString extends GeometryObject<LineString> {

    public MultiLineString(LineString coordinates) {
        super(coordinates, "MultiLineString");
    }

    @Override
    public String toString() {
        return "MultiLineString{" +
                "coordinates=" + getCoordinates() +
                ", type=" + type +
                '}';
    }

    @Override
    public LineString getCoordinates() {
        return super.getCoordinates();
    }

    @Override
    public void setCoordinates(LineString coordinates) {
        super.setCoordinates(coordinates);
    }
}
