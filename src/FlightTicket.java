/**
 * A class whose object to be instantiated when a client successfully buy a ticket
 * @author Jiaxing Rong
 */

public class FlightTicket {
    /**
     * used for identifying which flight this ticket belongs to
     */
    private int flightID;
    /**
     * A unique ID for each ticket
     */
    private int ticketID;
    /**
     * used to check whether this ticket available
     */
    private boolean isAvailable;
    /**
     * the seat number of this flight ticket
     */
    private String seatNum;

    /**
     * Constructor initializing the information of the ticket
     * @param flightID The flight ID of the ticket
     * @param ticketID The ticket ID of the ticket
     * @param isAvailable The availability of the ticket
     * @param seatNum The seat number of the ticket
     */
    public FlightTicket(int flightID, int ticketID, boolean isAvailable, String seatNum) {
        this.flightID = flightID;
        this.ticketID = ticketID;
        this.isAvailable = isAvailable;
        this.seatNum = seatNum;
    }

    /**
     * getter function to get the ticket ID
     * @return An int representing the ticket ID
     */
    public int getTicketID() { return ticketID; }

    /**
     * getter function to get the Flight ID of the ticket
     * @return An int representing the flight ID
     */
    public int getFlightID() { return flightID; }

    /**
     * getter function to get the seat number of the ticket
     * @return A String representing the seat number of the ticket
     */
    public String getSeatNum() { return seatNum; }
}
