package seaBattle;

import java.util.List;

public class Ship {
    private List<Integer[]> coordinates;

    public Ship(List<Integer[]> coordinates) {
        this.coordinates = coordinates;
    }

    public List<Integer[]> getCoordinates() {
        return coordinates;
    }
}
