package geoJson;

import com.fasterxml.jackson.annotation.JsonTypeName;
import geoJson.exceptions.InvalidBboxException;
import geoJson.exceptions.InvalidCoordinatesException;
import geoJson.util.BboxValidator;

import java.util.List;

@JsonTypeName("geoJson.FeatureCollection")
public class FeatureCollection extends GeoJson {

    private List<Feature> features;

    public FeatureCollection() {
        super("geoJson.FeatureCollection");
    }

    public FeatureCollection(List<Feature> features) {
        super("geoJson.FeatureCollection");
        this.features = features;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        if (features == null || features.isEmpty()) {
            throw new InvalidCoordinatesException();
        } else if (!BboxValidator.isValid(this)) {
            throw new InvalidBboxException();
        }

        this.features = features;
    }

    @Override
    public String toString() {
        return "geoJson.FeatureCollection{" +
                "features=" + features +
                ", type='" + type + '\'' +
                ", bbox=" + bbox +
                '}';
    }
}