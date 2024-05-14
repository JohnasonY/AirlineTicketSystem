import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A class as a temporary database to simulate what is supposed to do
 * @author Jiaxing Rong
 */
public class Database {
    /**
     * the name of the file containing current flights information
     */
    private static final String FlightsInfo = "flights.txt";
    /**
     * HashMap used for storing users(Administrators and Clients)' information
     */
    public static HashMap<String, User> users = new HashMap<>();

    /**
     * add a mew flight to the flights list
     * @param flight a new flight to be added
     * @param flights list for storing the current flights
     */
    public static void addFlight(Flight flight, List<Flight> flights) {
        if (validateFlight(flight)) {
            /*
            try (FileWriter fw = new FileWriter(FlightsInfo, true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw)) {
                out.println(flight);
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }
            */
            flights.add(flight);
        } else {
            System.out.println("Failed to add flight. Invalid flight details.");
        }
    }

    /**
     * validate the format of flight being added, can be called without instantiating the database object
     * @param flight the flight to be checked
     * @return true for the flight information is valid
     */
    private static boolean validateFlight(Flight flight) {
        try {
            // Example validation: Ensure dates are in the correct format
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            sdf.setLenient(false);
            sdf.parse(flight.getDepartureTime()); // Will throw ParseException if the date is not valid
            sdf.parse(flight.getArriveTime());
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * read all the flights from a txt file to a flight list, should be called only once during the program
     * @return a flight list for holding the current available flights information
     */
    //make as static method so it doesn't need to be instantiated before calling
    public static List<Flight> getFlights() {
        ArrayList<Flight> flights = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FlightsInfo))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    String[] data = line.split(",\\s*");  // Split by comma and trim spaces
                    if (data.length == 7) {
                        int id = Integer.parseInt(data[0]);
                        Flight flight = new Flight(id, data[1], data[2], data[3], data[4], data[5], Integer.parseInt(data[6]));
                        flights.add(flight);
                    }
                } catch (Exception e) {
                    System.out.println("Skipping invalid entry: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return flights;
    }


    /**
     * register a new client if the client's username doesn't exist
     * @param client the client to be registered
     */
    public static void registerClient(Client client) {
        if (!users.containsKey(client.userName)) {
            users.put(client.userName, client);
            System.out.println(client.userName + " registered successfully.");
        } else {
            System.out.println("Registration failed: Username already exists.");
        }
    }
}
