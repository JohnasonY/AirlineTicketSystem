import java.util.ArrayList;

/**
 * A class inherits class User
 * @author Jiaxing Rong
 */
public class Client extends User {
    /**
     * phone number of the client
     */
    private String phoneNumber;
    /**
     * email of the client
     */
    private String email;
    /**
     * ArrayList of flight ticket for holding the client's reserved tickets
     */
    protected ArrayList<FlightTicket> ticketList;

    /**
     * Constructor initializing the client's information
     * @param userName username of the client
     * @param password password of the client
     * @param phoneNumber phone number of the client
     * @param email email of the client
     */
    public Client(String userName, String password, String phoneNumber, String email) {
        super(userName, password);
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.ticketList = new ArrayList<>();
    }

    /**
     * setter function to set the phone number to its parameter
     * @param phoneNumber phone number of the client
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * setter function to set the email to its parameter
     * @param email email of the client
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * getter function to get the phone number of the client
     * @return A String representing the phone number of the client
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * getter function to get the email of the client
     * @return A String representing the email of the client
     */
    public String getEmail() {
        return email;
    }

    /**
     * print out all the reserved tickets of the client
     */
    public void viewReservations() {
        for (FlightTicket ticket : ticketList) {
            System.out.println("Ticket ID: " + ticket.getTicketID() + ", Flight ID: " + ticket.getFlightID() + ", Seat: " + ticket.getSeatNum());
        }
    }

    /**
     * book a flight ticket for the client
     * @param flight the flight that the client want to book ticket
     * @param seatNum the seat number that the client wants to reserve
     */
    public void reserveTicket(Flight flight, String seatNum) {
        FlightTicket ticket = new FlightTicket(flight.getID(), flight.getID(), true, seatNum);
        ticketList.add(ticket);
        System.out.println("Ticket reserved: Flight ID " + flight.getID() + ", Seat " + seatNum);
    }

    /**
     * cancel a ticket that the client reserved
     * @param ticket the ticket that the client wants to cancel
     */
    public void cancelReservations(FlightTicket ticket) {
        ticketList.remove(ticket);
        System.out.println("Reservation cancelled: Ticket ID " + ticket.getTicketID());
    }
}
