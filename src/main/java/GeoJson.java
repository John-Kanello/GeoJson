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
})
public abstract class GeoJson implements Serializable {

    String type;
    private List<Float> bBox;
    private String id;
//    private Property properties;
    private String title;

    public GeoJson() {
    }

    @Override
    public String toString() {
        return "GeoJson{" +
                "type='" + type + '\'' +
                ", bBox=" + bBox +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
