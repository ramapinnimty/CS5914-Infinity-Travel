package business.flights;

import java.util.Date;

public class Flights {
    private int flight_id;
    private String airline_name;
    private String src;
    private String dest;
    private int num_stops;
    private int seats;
    private double price;
    private Date start_date;
    private Date reach_date;

    public Flights(int flight_id, String airline_name, String src, String dest,
                   int num_stops, int seats, double price,
                   Date start_date, Date reach_date) {
        this.flight_id = flight_id;
        this.airline_name = airline_name;
        this.src = src;
        this.dest = dest;
        this.num_stops = num_stops;
        this.seats = seats;
        this.price = price;
        this.start_date = start_date;
        this.reach_date = reach_date;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public String getAirline_name() {
        return airline_name;
    }

    public void setAirline_name(String airline_name) {
        this.airline_name = airline_name;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public int getNum_stops() {
        return num_stops;
    }

    public void setNum_stops(int num_stops) {
        this.num_stops = num_stops;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getReach_date() {
        return reach_date;
    }

    public void setReach_date(Date reach_date) {
        this.reach_date = reach_date;
    }

    @Override
    public String toString() {
        return "Flights{" +
                "flight_id=" + flight_id +
                ", airline_name='" + airline_name + '\'' +
                ", src='" + src + '\'' +
                ", dest='" + dest + '\'' +
                ", num_stops=" + num_stops +
                ", seats=" + seats +
                ", price=" + price +
                ", start_date=" + start_date +
                ", reach_date=" + reach_date +
                '}';
    }
}
