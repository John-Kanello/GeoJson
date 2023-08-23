import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;
import java.util.Map;


public class Main {

    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

//        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        String jsonString = """
                {
                  "type" : "Feature",
                  "geometry": {
                    "type": "LineString",
                    "coordinates": [
                      [100.1, 11.1],
                      [21.4, 55.6]
                    ]
                  },
                  "properties": {
                    "prop0": "value0",
                    "prop1": {
                        "this": "that"
                    }
                  },
                  "title": "Test title"
                }
                """;

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
                                },
                                "properties": {
                                  "prop0": "value0",
                                  "prop1": {
                                    "this": "that"
                                  }
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
                                },
                                "properties": {
                                  "prop0": "value0",
                                  "prop1": {
                                    "this": "that"
                                  }
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
                                },
                                "properties": {
                                  "prop0": "value0",
                                  "prop1": {
                                    "prop2": {
                                        "prop3": "value2"
                                    }
                                  }
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

        String propertiesGeoJson = """
                {
                    "prop0": "value0",
                    "prop1": {
                        "this": "that"
                    }
                }
                """;

        String polygonString = """
                {
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
                """;

        GeoJson polygon = objectMapper.readValue(polygonString, GeoJson.class);
        System.out.println(polygon);

//        Map<String, Object> map;
//        map = objectMapper.readValue(propertiesGeoJson, Map.class);
//        readJson(map);
    }

    static void readJson(Map<String, Object> map) {
        for(var entry : map.entrySet()) {
            System.out.println(entry.getKey());
            if(entry.getValue().getClass().equals(LinkedHashMap.class)) {
                LinkedHashMap linkedHashMap = (LinkedHashMap) entry.getValue();
                readJson(linkedHashMap);
            } else {
                System.out.println(entry.getValue());
            }
        }
    }




}





















