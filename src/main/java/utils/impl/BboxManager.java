package utils.impl;

import geoJson.Feature;
import geoJson.FeatureCollection;
import geoJson.GeoJson;
import geoJson.GeometryObject;
import utils.GeometryManager;

import java.util.List;

public class BboxManager implements GeometryManager<GeoJson> {

    @Override
    public boolean isValid(GeoJson geoJson) {

        if(geoJson == null) {
            return false;
        }
        
        if(geoJson.getBbox() == null) {
            return true;
        }

        int bBoxSize = geoJson.getBbox().size();
        int dimensions;
        if(geoJson instanceof FeatureCollection featureCollection) {
            dimensions = getDimensions(featureCollection.getFeatures());
            if(bBoxSize != 2 * dimensions) {
                return false;
            }

            for(Feature f : featureCollection.getFeatures()) {
                if(!isValid(f)) {
                    return false;
                }
            }
        } else if(geoJson instanceof Feature feature) {
            dimensions = getDimensions((List) feature.getGeometry().getCoordinates());

            return bBoxSize == 2 * dimensions && isValid(feature.getGeometry());
        } else if (geoJson instanceof GeometryObject geometryObject) {
            dimensions = getDimensions((List) geometryObject.getCoordinates());

            return bBoxSize == 2 * dimensions;
        }

        return true;
    }

    int getDimensions(List coordinates) {
        if(!(coordinates.get(0) instanceof List)) {
            return 1;
        }

        return 1 + getDimensions((List) coordinates.get(0));
    }
}
