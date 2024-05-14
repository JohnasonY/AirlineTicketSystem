import java.util.List;

/**
 * An interface that can add a new flight
 * @author Jiaxing Rong
 */
public interface addFlights {
    /**
     *
     * @param flight a new flight to be added
     * @param flights the flight list storing all the current available flights
     */
    void addFlight(Flight flight, List<Flight> flights);
}
