import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.List;

@JsonTypeName("FeatureCollection")
public class FeatureCollection extends GeoJson {

    private List<Feature> features;

    public FeatureCollection(List<Feature> features) {
        this.features = features;
        this.type = "FeatureCollection";
    }


}
