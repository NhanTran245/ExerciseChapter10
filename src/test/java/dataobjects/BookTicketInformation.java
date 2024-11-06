package dataobjects;

import java.time.LocalDate;

public class BookTicketInformation {

    private int dateFromToday;
    private String pattern;
    private String departStation;
    private String arriveStation;
    private String seatType;
    private int ticketAmount;
    public BookTicketInformation (int dateFromToday, String pattern, String departStation, String arriveStation, String seatType, int ticketAmount) {
        this.dateFromToday = dateFromToday;
        this.pattern = pattern;
        this.departStation = departStation;
        this.arriveStation = arriveStation;
        this.seatType = seatType;
        this.ticketAmount = ticketAmount;
    }

    public int getDateFromToday() {
        return dateFromToday;
    }

    public void setDateFromToday(int dateFromToday) {
        this.dateFromToday = dateFromToday;
    }
    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
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
