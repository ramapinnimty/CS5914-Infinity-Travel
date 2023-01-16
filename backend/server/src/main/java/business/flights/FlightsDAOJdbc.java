package business.flights;

import api.ApiException;
import business.InfinitytravelDbException.InfinitytravelConnectionDbException;
import business.InfinitytravelDbException.InfinitytravelQueryDbException;
import business.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightsDAOJdbc implements FlightsDAO {
    private static final String FIND_BY_SRC_DEST_SQL =
            "SELECT flight_id, airline_name, src, dest, num_stops, seats, price, start_date, reach_date " +
                    "FROM flights " +
                    "WHERE src = ? AND dest = ? " + "LIMIT 5 ";

    @Override
    public List<Flights> getBySrcDest (String src, String dest) {
        List<Flights> flights = new ArrayList<>();
        try(Connection connection = JdbcUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_BY_SRC_DEST_SQL)) {
            statement.setString(1, src);
            statement.setString(2, dest);
            System.out.println("Reached inside getBySrcDest function");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Flights flight = readFlight(resultSet);
                flights.add(flight);
            }

        } catch(SQLException e) {
            throw new InfinitytravelConnectionDbException("Connection Error", e);
        }
        return flights;
    }

    @Override
    public List<Flights> getAll(int limit) throws SQLException {
        return null;
    }

    @Override
    public int save(Flights flights) throws SQLException {
        return 0;
    }

    @Override
    public int insert(Flights flights) throws SQLException {
        return 0;
    }

    @Override
    public int update(Flights flights) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Flights flights) throws SQLException {
        return 0;
    }

    private Flights readFlight(ResultSet resultSet) throws SQLException {
        int flight_id = resultSet.getInt("flight_id");
        String airline_name = resultSet.getString("airline_name");
        String src = resultSet.getString("src");
        String dest = resultSet.getString("dest");
        int num_stops = resultSet.getInt("num_stops");
        int seats = resultSet.getInt("seats");
        double price = resultSet.getDouble("price");
        Date start_date = resultSet.getDate("start_date");
        Date reach_date = resultSet.getDate("reach_date");

        return new Flights(
                flight_id,
                airline_name,
                src,
                dest,
                num_stops,
                seats,
                price,
                start_date,
                reach_date
        );
    }
}
