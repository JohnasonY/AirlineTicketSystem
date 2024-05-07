import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Database {
    private static final String FlightsInfo = "flights.txt";
    public static HashMap<String, User> users = new HashMap<>();

    public static void addFlight(Flight flight) {
        if (validateFlight(flight)) {
            try (FileWriter fw = new FileWriter(FlightsInfo, true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw)) {
                out.println(flight);
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }
        } else {
            System.out.println("Failed to add flight. Invalid flight details.");
        }
    }

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



    public static void registerClient(Client client) {
        if (!users.containsKey(client.userName)) {
            users.put(client.userName, client);
            System.out.println(client.userName + " registered successfully.");
        } else {
            System.out.println("Registration failed: Username already exists.");
        }
    }
}
