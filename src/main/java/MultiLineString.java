import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;

@JsonTypeName("MultiLineString")
public class MultiLineString extends GeometryObject<List<List<List<Float>>>> {

    public MultiLineString() {
        this.type = "MultiLineString";
    }

    public MultiLineString(List<List<List<Float>>> coordinates) {
        super(coordinates, "MultiLineString");
    }

    @Override
    public String toString() {
        return "MultiLineString{" +
                "coordinates=" + coordinates +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public List<List<List<Float>>> getCoordinates() {
        return super.getCoordinates();
    }

    @Override
    public void setCoordinates(List<List<List<Float>>> coordinates) {
        super.setCoordinates(coordinates);
    }
}
