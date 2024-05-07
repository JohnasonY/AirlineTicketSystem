class Administrator extends User implements addFlights {
    private String name;
    private String email;

    public Administrator(String userName, String password, String name, String email) {
        super(userName, password);
        this.name = name;
        this.email = email;
    }

    @Override
    public void addFlight(Flight flight) {
        Database.addFlight(flight);
        System.out.println("Flight added: " + flight.getCompany() + " from " + flight.getFrom() + " to " + flight.getTo());
    }
}
