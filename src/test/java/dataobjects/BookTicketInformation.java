package dataobjects;

import java.time.LocalDate;

public class BookTicketInformation {

    private String departDate;
//    private String pattern;
    private String departStation;
    private String arriveStation;
    private String seatType;
    private int ticketAmount;
    public BookTicketInformation (String departDate, String departStation, String arriveStation, String seatType, int ticketAmount) {
        this.departDate = departDate;
        this.departStation = departStation;
        this.arriveStation = arriveStation;
        this.seatType = seatType;
        this.ticketAmount = ticketAmount;
    }

    public BookTicketInformation (String departStation, String arriveStation) {
        this.departStation = departStation;
        this.arriveStation = arriveStation;
    }

    public BookTicketInformation (String departDate, String departStation, String arriveStation, int ticketAmount) {
        this.departDate = departDate;
        this.departStation = departStation;
        this.arriveStation = arriveStation;
        this.ticketAmount = ticketAmount;
    }

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public String getDepartStation() {
        return departStation;
    }

    public void setDepartStation(String departStation) {
        this.departStation = departStation;
    }

    public String getArriveStation() {
        return arriveStation;
    }

    public void setArriveStation(String arriveStation) {
        this.arriveStation = arriveStation;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public int getTicketAmount() {
        return ticketAmount;
    }

    public void setTicketAmount(int ticketAmount) {
        this.ticketAmount = ticketAmount;
    }
}
