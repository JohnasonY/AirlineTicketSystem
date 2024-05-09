import java.util.List;
import java.util.Scanner;

public class AirlineTicketSystem {
    private static Scanner scanner = new Scanner(System.in);

    //Predefine administrator username and password
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";

    //instantiate the client and admin
    private static Client client;
    private static Administrator admin;

    //instantiate the flight list before reading the file
    private static List<Flight> flights;

    public static void main(String[] args) {
        admin = new Administrator(ADMIN_USERNAME, ADMIN_PASSWORD, "System Administrator", "admin@airline.com"); // Admin is pre-created
        //only do this once!!!
        flights = Database.getFlights();
        System.out.println("Welcome to the Airline Ticket System");
        while (true) {
            System.out.println("=====================================");
            System.out.println("Are you a(n):");
            System.out.println("1. Administrator");
            System.out.println("2. Client");
            System.out.println("3. Register as New Client");
            System.out.println("4. Exit");
            System.out.println("=====================================");
            System.out.println("Enter choice: ");
            int roleChoice = scanner.nextInt();
            scanner.nextLine();

            switch (roleChoice) {
                case 1:
                    if (adminLogin()) {
                        adminMenu();
                    } else {
                        System.out.println("Invalid admin credentials!");
                    }
                    break;
                case 2:
                    if (clientLogin()) {
                        clientMenu();
                    }
                    break;
                case 3:
                    registerNewClient();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }

    private static void registerNewClient() {
        System.out.print("Enter new username: ");
        String userName = scanner.nextLine();
        System.out.print("Enter new password: ");
        String password = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email address: ");
        String email = scanner.nextLine();

        Client newClient = new Client(userName, password, phoneNumber, email);
        Database.registerClient(newClient);
    }

    private static boolean adminLogin() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        return username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD);
    }

    private static boolean clientLogin() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = Database.users.get(username);
        if (user != null && user.password.equals(password)) {
            client = (Client) user; // Cast the user to Client after successful login
            return true;
        }
        System.out.println("Invalid username or password.");
        return false;
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("======================");
            System.out.println("Admin Menu:");
            System.out.println("1. Add Flight");
            System.out.println("2. View All Flights");
            System.out.println("3. Logout");
            System.out.println("======================");
            System.out.println("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addFlightUI();
                    break;
                case 2:
                    viewAllFlights(flights);
                    break;
                case 3:
                    return; // Logout
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }

    private static void clientMenu() {
        while (true) {
            System.out.println("===========================");
            System.out.println("Client Menu:");
            System.out.println("1. View Available Flights");
            System.out.println("2. Book Ticket");
            System.out.println("3. View Reservations");
            System.out.println("4. Cancel Reservation");
            System.out.println("5. Logout");
            System.out.println("===========================");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewAvailableFlights(flights);
                    break;
                case 2:
                    bookTicketUI();
                    break;
                case 3:
                    viewReservationsUI();
                    break;
                case 4:
                    cancelReservationUI();
                    break;
                case 5:
                    return; // Logout
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }

    private static void addFlightUI() {
        System.out.println("Enter flight details (ID, Company, From, To, Departure Date and Time, Arrival Date and Time, Available Seats):");
        System.out.println("Example format: 101, Delta, New York, Los Angeles, 2024-05-10 08:00, 2024-05-10 11:00, 180");
        String input = scanner.nextLine();
        String[] details = input.split(",\\s*");  // Split by comma and remove any extra spaces
        if (details.length == 7) {
            try {
                int id = Integer.parseInt(details[0]);
                String company = details[1];
                String from = details[2];
                String to = details[3];
                String departure = details[4];
                String arrival = details[5];
                int seats = Integer.parseInt(details[6]);
                Flight flight = new Flight(id, company, from, to, departure, arrival, seats);
                Database.addFlight(flight);
                System.out.println("Flight added: " + company + " from " + from + " to " + to);
            } catch (NumberFormatException e) {
                System.out.println("Error: Incorrect number format in input. Please try again.");
            }
        } else {
            System.out.println("Error: Incorrect format. Please follow the example format.");
        }
    }



    private static void viewAvailableFlights(List<Flight> flights) {
        if (flights.isEmpty()) {
            System.out.println("No available flights.");
        } else {
            System.out.println("Available Flights:");
            for (Flight flight : flights) {
                System.out.println("Flight ID: " + flight.getID() + ", From: " + flight.getFrom() + " to " + flight.getTo() +
                        ", Departure: " + flight.getDepartureTime() + ", Arrive: " + flight.getArriveTime() +
                        ", Seats Available: " + flight.getAvailableSeats());
            }
        }
    }


    private static void viewAllFlights(List<Flight> flights) {
        if (flights.isEmpty()) {
            System.out.println("No flights available.");
        } else {
            System.out.println("Available Flights:");
            for (Flight flight : flights) {
                System.out.println("Flight ID: " + flight.getID() + ", From: " + flight.getFrom() + " to " + flight.getTo() +
                        ", Departure: " + flight.getDepartureTime() + ", Arrival: " + flight.getArriveTime() +
                        ", Seats Available: " + flight.getAvailableSeats());
            }
        }
    }


    private static void bookTicketUI() {
        System.out.print("Enter Flight ID and Seat Number to book (FlightID, SeatNum): ");
        String[] bookingDetails = scanner.nextLine().split(", ");
        try {
            int flightId = Integer.parseInt(bookingDetails[0]);
            String seatNum = bookingDetails[1];
            Flight flight = flights.stream()
                    .filter(f -> f.getID() == flightId)
                    .findFirst()
                    .orElse(null);
            if (flight != null && flight.getAvailableSeats() > 0) {
                client.reserveTicket(flight, seatNum);
                flight.setAvailableSeats(flight.getAvailableSeats() - 1);  // Decrease available seats
            } else {
                System.out.println("Flight not found or no available seats.");
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid input format. Please enter Flight ID and Seat Number correctly.");
        }
    }

    private static void viewReservationsUI() {
        client.viewReservations();
    }

    private static void cancelReservationUI() {
        System.out.print("Enter Ticket ID to cancel: ");
        try {
            int ticketID = Integer.parseInt(scanner.nextLine());
            FlightTicket ticket = client.ticketList.stream()
                    .filter(t -> t.getTicketID() == ticketID)
                    .findFirst()
                    .orElse(null);
            if (ticket != null) {
                client.cancelReservations(ticket);
                // Increment the seats available for the flight
                Flight flight = flights.stream()
                        .filter(f -> f.getID() == ticket.getFlightID())
                        .findFirst()
                        .orElse(null);
                if (flight != null) {
                    flight.setAvailableSeats(flight.getAvailableSeats() + 1);
                }
            } else {
                System.out.println("Ticket not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid Ticket ID.");
        }
    }
}
