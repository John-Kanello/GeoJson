import com.fasterxml.jackson.annotation.JsonTypeName;
import exception.InvalidLinearRingException;
import utils.impl.LinearRingManager;

import java.util.List;


@JsonTypeName("LinearRing")
public class LinearRing extends LineString {

    public LinearRing() {
       super("LinearRing");
    }

    public LinearRing(List<List<Float>> coordinates) {
        super("LinearRing");
        LinearRingManager linearRingManager = new LinearRingManager();
        if(!linearRingManager.isValid(coordinates)) {

        }
        this.coordinates = coordinates;

    }

    @Override
    public String toString() {
        return "LinearRing{" +
                "coordinates=" + coordinates +
                ", type='" + type + '\'' +
                '}';
    }
}
