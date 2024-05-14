
import java.util.List;

/**
 * A class inherits class User
 * @author Jiaxing Rong
 */
public class Administrator extends User implements addFlights {
    /**
     * name of the Administrator
     */
    private String name;
    /**
     * email of the Administrator
     */
    private String email;

    /**
     * Constructor initializing Administrator's information
     * @param userName userName of the Administrator
     * @param password password of the Administrator
     * @param name name of the Administrator
     * @param email email of the Administrator
     */
    public Administrator(String userName, String password, String name, String email) {
        super(userName, password);
        this.name = name;
        this.email = email;
    }

    /**
     * Override a method from addFlights interface, add a new flight to the flights list
     * @param flight a new flight to be added
     * @param flights the flight list storing all the current available flights
     */
    @Override
    public void addFlight(Flight flight, List<Flight> flights) {
        Database.addFlight(flight, flights);
        System.out.println("Flight added: " + flight.getCompany() + " from " + flight.getFrom() + " to " + flight.getTo());
    }
}
