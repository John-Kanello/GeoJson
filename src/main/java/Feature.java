import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Map;

@JsonTypeName("Feature")
public class Feature extends GeoJson {

    private GeometryObject geometry;
    private Map<String, Object> properties;

    public Feature() {
        super("Feature");
    }

    public Feature(GeometryObject geometry, Map<String, Object> properties) {
        super("Feature");
        this.geometry = geometry;
        this.properties = properties;
    }

    public GeometryObject getGeometry() {
        return geometry;
    }

    public void setGeometry(GeometryObject geometry) {
        this.geometry = geometry;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Feature{" +
                "geometry=" + geometry +
                ", properties=" + properties +
                ", type='" + type + '\'' +
                '}';
    }
}
