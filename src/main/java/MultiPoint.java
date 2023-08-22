import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;

@JsonTypeName("MultiPoint")
public class MultiPoint extends GeometryObject<List<List<Float>>> {

    public MultiPoint() {
        this.type = "MultiPoint";
    }

    public MultiPoint(List<List<Float>> coordinates) {
        super(coordinates, "MultiPoint");
    }

    @Override
    public String toString() {
        return "MultiPoint{" +
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
