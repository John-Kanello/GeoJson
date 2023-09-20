package geoJson;

import com.fasterxml.jackson.annotation.JsonTypeName;
import geoJson.exceptions.InvalidBboxException;
import geoJson.util.BboxValidator;

import java.util.Map;

@JsonTypeName("geoJson.Feature")
public class Feature extends GeoJson {

    private GeometryObject<?> geometry;
    private Map<String, Object> properties;
    private String title;

    public Feature() {
        super("geoJson.Feature");
    }

    public GeometryObject<?> getGeometry() {
        return geometry;
    }

    public void setGeometry(GeometryObject<?> geometry) {

        if (geometry == null) {
            throw new IllegalArgumentException("Geometry cannot be null");
        }

        this.geometry = geometry;
        if (!BboxValidator.isValid(this)) {
            throw new InvalidBboxException();
        }
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "geoJson.Feature{" +
                "geometry=" + geometry +
                ", properties=" + properties +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", bbox=" + bbox +
                '}';
    }
}