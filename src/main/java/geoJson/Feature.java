package geoJson;

import com.fasterxml.jackson.annotation.JsonTypeName;
import exception.InvalidBboxException;
import utils.impl.BboxManager;

import java.util.Map;

@JsonTypeName("Feature")
public class Feature extends GeoJson {

    private GeometryObject geometry;
    private Map<String, Object> properties;
    private String title;

    public Feature() {
        super("Feature");
    }

    public Feature(GeometryObject geometry, Map<String, Object> properties, String title) {
        super("Feature");
        this.geometry = geometry;
        this.properties = properties;
        this.title = title;

        System.out.println(geometry);
    }

    public GeometryObject getGeometry() {
        return geometry;
    }

    public void setGeometry(GeometryObject geometry) {
        this.geometry = geometry;
        if(!new BboxManager().isValid(this)) {
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
        return "Feature{" +
                "geometry=" + geometry +
                ", properties=" + properties +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", bbox=" + bbox +
                '}';
    }
}
