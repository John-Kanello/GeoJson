import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Feature.class, name = "Feature"),
        @JsonSubTypes.Type(value = FeatureCollection.class, name = "FeatureCollection"),
        @JsonSubTypes.Type(value = GeometryObject.class, name = "GeometryObject"),
        @JsonSubTypes.Type(value = GeometryCollection.class, name = "GeometryCollection")
})
public abstract class GeoJson implements Serializable {

    String type;

    public GeoJson() {
    }

    public GeoJson(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeoJson geoJson = (GeoJson) o;
        return Objects.equals(type, geoJson.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
