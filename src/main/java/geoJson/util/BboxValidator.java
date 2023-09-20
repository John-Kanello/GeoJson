package geoJson.util;

import geoJson.Feature;
import geoJson.FeatureCollection;
import geoJson.GeoJson;
import geoJson.GeometryObject;

import java.util.List;

public class BboxValidator {

    public static boolean isValid(GeoJson geoJson) {
        if (geoJson == null) {
            return false;
        }
        if (geoJson.getBbox() == null) {
            return true;
        }
        int bBoxSize = geoJson.getBbox().size();
        int dimensions;
        if (geoJson instanceof FeatureCollection featureCollection) {
            dimensions = getDimensions(featureCollection.getFeatures());
            if (!validateDimensions(bBoxSize, dimensions)) {
                return false;
            }
            for (Feature f : featureCollection.getFeatures()) {
                if (!isValid(f)) {
                    return false;
                }
            }
        }
        if (geoJson instanceof Feature feature) {
            dimensions = getDimensions((List<?>) feature.getGeometry().getCoordinates());
            return validateDimensions(bBoxSize, dimensions) && isValid(feature.getGeometry());
        }
        if (geoJson instanceof GeometryObject<?> geometryObject) {
            dimensions = getDimensions((List<?>) geometryObject.getCoordinates());
            return validateDimensions(bBoxSize, dimensions);
        }
        return true;
    }

    private static boolean validateDimensions(int bBoxSize, int dimensions) {
        return bBoxSize == 2 * dimensions;
    }

    private static int getDimensions(List<?> coordinates) {
        if (!(coordinates.get(0) instanceof List)) {
            return 1;
        }

        return 1 + getDimensions((List<?>) coordinates.get(0));
    }
}