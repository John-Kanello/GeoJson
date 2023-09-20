import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import geoJson.*;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testFeatureSerialization() throws JsonProcessingException {
        Main main = new Main();

        String jsonString = """
                {
                  "type" : "Feature",
                  "geometry" : {
                    "type": "LineString",
                    "coordinates": [
                      [100.1, 11.1 ],
                      [21.4, 55.6 ]
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

        Feature feature = new Feature();
        GeometryObject geometry = new LineString();
        geometry.setCoordinates(new ArrayList<>(List.of(new ArrayList<>(List.of(100.1f, 11.1f)), new ArrayList<>(List.of(21.4f, 55.6f)))));
        Map<String, Object> properties = new LinkedHashMap<>();
        properties.put("prop0", "value0");
        properties.put("prop1", new HashMap<>(Map.ofEntries(Map.entry("this", "that"))));
        feature.setGeometry(geometry);
        feature.setProperties(properties);
        feature.setTitle("Test title");

        ObjectMapper objectMapper = new ObjectMapper();

        GeoJson geoJson = objectMapper.readValue(jsonString, GeoJson.class);
        assertEquals(geoJson, feature);
    }
}