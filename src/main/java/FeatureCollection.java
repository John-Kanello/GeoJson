import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;

@JsonTypeName("FeatureCollection")
public class FeatureCollection extends GeoJson {

    private List<Feature> features;

    public FeatureCollection() {
        super("FeatureCollection");
    }

    public FeatureCollection(List<Feature> features) {
        super("FeatureCollection");
        this.features = features;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    @Override
    public String toString() {
        return "FeatureCollection{" +
                "features=" + features +
                ", type='" + type + '\'' +
                '}';
    }
}
