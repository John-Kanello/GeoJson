import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Feature")
public class Feature extends GeoJson {

    private GeometryObject geometry;

    public Feature() {
        super("Feature");
    }

    public Feature(GeometryObject geometry) {
        super("Feature");
        this.geometry = geometry;
    }

    @Override
    public String toString() {
        return "Feature{" +
                "geometry=" + geometry +
                ", type='" + type + '\'' +
                '}';
    }

    public GeometryObject getGeometry() {
        return geometry;
    }

    public void setGeometry(GeometryObject geometry) {
        this.geometry = geometry;
    }
}
