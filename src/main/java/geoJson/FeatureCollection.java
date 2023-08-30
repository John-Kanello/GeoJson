package geoJson;

import com.fasterxml.jackson.annotation.JsonTypeName;
import exception.InvalidBboxException;
import utils.impl.BboxManager;

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
        if(!new BboxManager().isValid(this)) {
            throw new InvalidBboxException();
        }
    }

    @Override
    public String toString() {
        return "FeatureCollection{" +
                "features=" + features +
                ", type='" + type + '\'' +
                ", bbox=" + bbox +
                '}';
    }
}
