import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {

        String jsonString = """
                {
                  "type" : "Feature",
                  "geometry": {
                    "type": "LineString",
                    "coordinates": [
                      [100.1, 11.1],
                      [21.4, 55.6]
                    ]
                  }
                }
                """;

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        GeoJson nextFeature = objectMapper.readValue(jsonString, GeoJson.class);
        System.out.println(nextFeature);

        String geoJsonString = """
                {
                        "type": "FeatureCollection",
                        "features":
                        [
                            {
                                "type": "Feature",
                                "geometry": {
                                    "type": "Point",
                                    "coordinates": [102.0, 0.5]
                                }
                            },
                             {
                                "type": "Feature",
                                "geometry": {
                                    "type": "LineString",
                                    "coordinates": [
                                        [102.0, 0.0],
                                        [103.0, 1.0],
                                        [104.0, 0.0],
                                        [105.0, 1.0]
                                    ]
                                }
                            },
                            {
                                "type": "Feature",
                                "geometry": {
                                    "type": "Polygon",
                                    "coordinates": [
                                        [
                                            [100.0, 0.0],
                                            [101.0, 0.0],
                                            [101.0, 1.0],
                                            [100.0, 1.0],
                                            [100.0, 0.0]
                                        ]
                                    ]
                                }
                            }
                        ]
                    }
                """;

        GeoJson geoJson = objectMapper.readValue(geoJsonString, GeoJson.class);
        System.out.println(geoJson);

        String geometryCollectionString = """
                {
                   "type": "GeometryCollection",
                   "geometries": [{
                     "type": "Point",
                     "coordinates": [100.0, 0.0]
                   }, {
                     "type": "LineString",
                     "coordinates": [
                       [101.0, 0.0],
                       [102.0, 1.0]
                     ]
                   }]
                 }
                """;

        GeoJson geometryCollection = objectMapper.readValue(geometryCollectionString, GeoJson.class);
        System.out.println(geometryCollection);
    }
}





















