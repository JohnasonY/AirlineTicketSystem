/**
 * A class whose object to be instantiated when Database add a new flight
 * @author Jiaxing Rong
 */
public class Flight {
    /**
     * The flight ID to uniquely identify a flight
     */
    private int ID;
    /**
     * what company the flight belongs to
     */
    private String company;
    /**
     * departure city
     */
    private String from;
    /**
     * destination city
     */
    private String to;
    /**
     * The departure time (format: yyyy-MM-dd HH:mm)
     */
    private String departureTime;
    /**
     * The arrived time (format: yyyy-MM-dd HH:mm)
     */
    private String arriveTime;
    /**
     * The number of available seats of the flight
     */
    private int availableSeats;

    /**
     * Constructor initializing the information of the flight
     * @param ID flight ID
     * @param company the company belongs to
     * @param from departure city
     * @param to destination city
     * @param departureTime The departure time (format: yyyy-MM-dd HH:mm)
     * @param arriveTime The arrived time (format: yyyy-MM-dd HH:mm)
     * @param availableSeats The number of available seats of the flight
     */
    public Flight(int ID, String company, String from, String to, String departureTime, String arriveTime, int availableSeats) {
        this.ID = ID;
        this.company = company;
        this.from = from;
        this.to = to;
        this.departureTime = departureTime;
        this.arriveTime = arriveTime;
        this.availableSeats = availableSeats;
    }

    /**
     * getter function to get the flight ID
     * @return An int representing the flight ID
     */
    public int getID() { return ID; }

    /**
     * getter function to get the company the flight belongs to
     * @return A String representing the company
     */
    public String getCompany() { return company; }

    /**
     * getter function to get the departure city
     * @return A String representing the departure city
     */
    public String getFrom() { return from; }

    /**
     * getter function to get the destination city
     * @return A String representing the destination city
     */
    public String getTo() { return to; }

    /**
     * getter function to get the departure time
     * @return A String representing the departure time
     */
    public String getDepartureTime() { return departureTime; }

    /**
     * getter function to get the arrived time
     * @return A String representing the arrived time
     */
    public String getArriveTime() { return arriveTime; }

    /**
     * getter function to get the number of available seats
     * @return An int representing the number of available seats
     */
    public int getAvailableSeats() { return availableSeats; }

    /**
     * setter function to set the number of available seats
     * @param availableSeats the number of available seats
     */
    public void setAvailableSeats(int availableSeats) { this.availableSeats = availableSeats; }


    /**
     * When print out the object, all the information of the flight will be printed out
     * @return A String showing all the information of the flight, comma to separate
     */
    @Override
    public String toString() {
        return ID + ", " + company + ", " + from + ", " + to + ", " + departureTime + ", " + arriveTime + ", " + availableSeats;
    }

}
