import java.util.ArrayList;

class Client extends User {
    protected String phoneNumber;
    protected String email;
    protected ArrayList<FlightTicket> ticketList;

    public Client(String userName, String password, String phoneNumber, String email) {
        super(userName, password);
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.ticketList = new ArrayList<>();
    }


    public void viewReservations() {
        for (FlightTicket ticket : ticketList) {
            System.out.println("Ticket ID: " + ticket.getTicketID() + ", Flight ID: " + ticket.getFlightID() + ", Seat: " + ticket.getSeatNum());
        }
    }

    public void reserveTicket(Flight flight, String seatNum) {
        FlightTicket ticket = new FlightTicket(flight.getID(), flight.getID(), true, seatNum);
        ticketList.add(ticket);
        System.out.println("Ticket reserved: Flight ID " + flight.getID() + ", Seat " + seatNum);
    }

    public void cancelReservations(FlightTicket ticket) {
        ticketList.remove(ticket);
        System.out.println("Reservation cancelled: Ticket ID " + ticket.getTicketID());
    }
}