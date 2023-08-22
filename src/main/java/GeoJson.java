import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.util.List;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Feature.class, name = "Feature"),
        @JsonSubTypes.Type(value = FeatureCollection.class, name = "FeatureCollection"),
        @JsonSubTypes.Type(value = GeometryObject.class, name = "GeometryObject")
})
public abstract class GeoJson implements Serializable {

    String type;

    public GeoJson() {
    }
}
