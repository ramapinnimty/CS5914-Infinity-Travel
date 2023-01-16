package business;

import business.discount.DiscountDAO;
import business.discount.DiscountDAOJdbc;
import business.flights.FlightsDAO;
import business.flights.FlightsDAOJdbc;

public class ApplicationContext {
    private DiscountDAO discountDAO;
    private FlightsDAO flightsDAO;
    public static ApplicationContext INSTANCE = new ApplicationContext();

    private ApplicationContext() {
        discountDAO = new DiscountDAOJdbc();
        flightsDAO = new FlightsDAOJdbc();
    }

    public DiscountDAO getDiscountDAO() {return discountDAO;}

    public FlightsDAO getFlightsDAO() {
        System.out.println("Returning FlightsDAO context");
        return flightsDAO;
    }
}
