package dataobjects;

public enum Menu {
    LOGIN("Login"),
    LOGOUT("Log out"),
    HOME("Home"),
    MYTICKET("My ticket"),
    BOOKTICKET("Book ticket"),
    TIMETABLE("Timetable"),
    TICKETPRICE("Ticket price"),
    REGISTER("Register"),
    FAQ("FAQ");

    private String description;

    Menu(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return this.description;
    }

}
