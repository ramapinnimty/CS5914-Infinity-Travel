package business.flights;

import java.util.List;

public interface FlightsDAO extends DAO<Flights> {

    List<Flights> getBySrcDest(String src, String dest);
}
