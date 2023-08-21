import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {
        Feature feature = new Feature(
                new LineString(
                        List.of(
                                new Position(List.of(100.1f, 11.1f)),
                                new Position(List.of(21.4f, 55.6f))
                        )
                )
        );

        String jsonString = """
                {
                  "type" : "Feature",
                  "geometry": {
                    "type": "LineString",
                    "coordinates": [
                      {
                        "type" : "Point",
                        "coordinates": [100.1, 11.1]
                      },
                      {
                        "type" : "Point",
                        "coordinates": [21.4, 55.6]
                      }
                    ]
                  }
                }
                """;

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        GeoJson nextFeature = objectMapper.readValue(jsonString, GeoJson.class);
        System.out.println(nextFeature);
    }
}
