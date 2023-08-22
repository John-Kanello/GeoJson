import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Feature")
public class Feature extends GeoJson {

    private GeometryObject geometry;

    public Feature() {
        this.type = "Feature";
    }

    public Feature(GeometryObject geometry) {
        this.geometry = geometry;
        this.type = "Feature";
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
