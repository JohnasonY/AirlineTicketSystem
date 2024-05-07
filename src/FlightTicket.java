class FlightTicket {
    private int flightID;
    private int ticketID;
    private boolean isAvailable;
    private String seatNum;

    public FlightTicket(int flightID, int ticketID, boolean isAvailable, String seatNum) {
        this.flightID = flightID;
        this.ticketID = ticketID;
        this.isAvailable = isAvailable;
        this.seatNum = seatNum;
    }

    public int getTicketID() { return ticketID; }
    public int getFlightID() { return flightID; }
    public String getSeatNum() { return seatNum; }
}