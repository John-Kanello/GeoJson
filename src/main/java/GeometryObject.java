import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = LineString.class, name = "LineString"),
})
@JsonTypeName("GeometryObject")
public abstract class GeometryObject<T> extends GeoJson {

    T coordinates;

    public GeometryObject(){

    }

    public GeometryObject(T coordinates, String type) {
        this.coordinates = coordinates;
        this.type = type;
    }

    @Override
    public String toString() {
        return "GeometryObject{" +
                "coordinates=" + coordinates +
                '}';
    }

    public T getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(T coordinates) {
        this.coordinates = coordinates;
    }
}
