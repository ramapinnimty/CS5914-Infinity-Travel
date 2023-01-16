package api;

import business.ApplicationContext;
import business.discount.Discount;
import business.discount.DiscountDAO;
import business.flights.Flights;
import business.flights.FlightsDAO;


import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@ApplicationPath("/")
@Path("/")
public class ApiResource {
    private final DiscountDAO discountDAO = ApplicationContext.INSTANCE.getDiscountDAO();
    private final FlightsDAO flightsDAO = ApplicationContext.INSTANCE.getFlightsDAO();

    @GET
    @Path("discounts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Discount> discount_codes(@QueryParam("limit") @DefaultValue("10") int limit,
                                         @Context HttpServletRequest httpRequest) {
        try {
            return discountDAO.getAll(limit);
        } catch(Exception e) {
            throw new ApiException("Discount Codes lookup failed", e);
        }
    }

    @GET
    @Path("discounts/{discount-id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Discount discoutById(@PathParam("discount-id") int discount_id,
                                @Context HttpServletRequest httpRequest) {
        try {
            Discount discount = discountDAO.get(discount_id);
            if (discount == null) {
                throw new ApiException(String.format("Discount id %d not found", discount_id));
            }
            return discount;
        } catch (Exception e) {
            throw new ApiException("Exception while retrieving discount by Id", e);
        }
    }

    @GET
    @Path("discounts/code/{discount-code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Discount discountByCode(@PathParam("discount-code") String discount_code,
                                   @Context HttpServletRequest httpRequest) {
        try {
            Discount discount = discountDAO.getByCode(discount_code);
            if (discount == null) {
                throw new ApiException(String.format("Discount Code %s not found", discount_code));
            }
            return discount;
        } catch(Exception e) {
            throw new ApiException("Exception while retrieving discount by code", e);
        }
    }

//    Flight APIs
    @GET
    @Path("flights")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Flights> flightByLegs(@QueryParam("src") @DefaultValue("roanoke") String src,
                                      @QueryParam("dest") @DefaultValue("washington") String dest,
                                      @Context HttpServletRequest httpRequest) {

        try {
            System.out.println(String.format("SRC: %s", src));
            System.out.println(String.format("DEST: %s", dest));
            return flightsDAO.getBySrcDest(src, dest);
        } catch (Exception e) {
            throw new ApiException("Error while calling flightByLegs call", e);
        }
    }
}
