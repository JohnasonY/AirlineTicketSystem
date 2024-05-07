class Flight {
    private int ID;
    private String company;
    private String from;
    private String to;
    private String departureTime;
    private String arriveTime;
    private int availableSeats;

    public Flight(int ID, String company, String from, String to, String departureTime, String arriveTime, int availableSeats) {
        this.ID = ID;
        this.company = company;
        this.from = from;
        this.to = to;
        this.departureTime = departureTime;
        this.arriveTime = arriveTime;
        this.availableSeats = availableSeats;
    }

    public int getID() { return ID; }
    public String getCompany() { return company; }
    public String getFrom() { return from; }
    public String getTo() { return to; }
    public String getDepartureTime() { return departureTime; }
    public String getArriveTime() { return arriveTime; }
    public int getAvailableSeats() { return availableSeats; }
    public void setAvailableSeats(int availableSeats) { this.availableSeats = availableSeats; }

    @Override
    public String toString() {
        return ID + ", " + company + ", " + from + ", " + to + ", " + departureTime + ", " + arriveTime + ", " + availableSeats;
    }

}
