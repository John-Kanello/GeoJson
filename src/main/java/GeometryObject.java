import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = LineString.class, name = "LineString"),
        @JsonSubTypes.Type(value = MultiLineString.class, name = "MultiLineString"),
        @JsonSubTypes.Type(value = MultiPoint.class, name = "MultiPoint"),
        @JsonSubTypes.Type(value = MultiPolygon.class, name = "MultiPolygon"),
        @JsonSubTypes.Type(value = Point.class, name = "Point"),
        @JsonSubTypes.Type(value = Polygon.class, name = "Polygon")
})
@JsonTypeName("GeometryObject")
public abstract class GeometryObject<T> extends GeoJson {

    T coordinates;

    public GeometryObject(){
        super("GeometryObject");
    }

    public GeometryObject(String type) {
        super(type);
    }

    public GeometryObject(T coordinates) {
        super("GeometryObject");
        this.coordinates = coordinates;
    }

    public GeometryObject(String type, T coordinates) {
        super(type);
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "GeometryObject{" +
                "coordinates=" + coordinates +
                ", type='" + type + '\'' +
                '}';
    }

    public T getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(T coordinates) {
        this.coordinates = coordinates;
    }
}
