package business.discount;

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

public class DiscountDAOJdbc implements DiscountDAO {
    private static final String FIND_BY_DISCOUNT_ID_SQL =
            "SELECT coupon_code, percentage, creation_date, utilized, discount_id " +
                 "FROM discount_codes " +
                "WHERE discount_id = ?";

    private static final String FIND_ALL_DISCOUNT_SQL =
            "SELECT discount_id, coupon_code, percentage, creation_date, utilized " +
                    "FROM discount_codes " + "LIMIT ?";

    private static final String INSERT_DISCOUNT_SQL =
            "INSERT INTO discount_codes (coupon_code, percentage, creation_date, utilized) " +
                    "VALUES (?, ?, ?, ?) ";

    private static final String FIND_BY_DISCOUNT_CODE_SQL =
            "SELECT coupon_code, percentage, creation_date, utilized, discount_id " +
                    "FROM discount_codes " +
                    "WHERE coupon_code = ? AND utilized=0";
    @Override
    public Discount get(int id) throws SQLException {
        Discount discount = null;
        try (Connection connection = JdbcUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_DISCOUNT_ID_SQL)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    discount = readDiscount(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new InfinitytravelConnectionDbException("Encountered a problem finding discount code " + id, e);
        }
        return discount;
    }

    @Override
    public List<Discount> getAll(int limit) throws SQLException {
        List<Discount> discounts = new ArrayList<>();
        try (Connection connection = JdbcUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_DISCOUNT_SQL)) {
            statement.setInt(1, limit);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Discount discount = readDiscount(resultSet);
                discounts.add(discount);
            }
        } catch (SQLException e) {
            throw new InfinitytravelConnectionDbException("Encountered a problem while fetching all discount codes ", e);
        }
        return discounts;
    }

    @Override
    public int save(Discount discount) throws SQLException {
        return 0;
    }

    @Override
    public int insert(Discount discount) throws SQLException {
        try(Connection connection = JdbcUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_DISCOUNT_SQL)) {
            statement.setString(1, discount.getDiscountCode());
            statement.setInt(2, discount.getPercentage());
            statement.setDate(3, (java.sql.Date) discount.getCreationDate());
            statement.setBoolean(4, discount.getUtilized());

            try {
                int result = statement.executeUpdate();
            } catch (Exception e) {
                throw new ApiException("Insert failed", e);
            }
            return 1;

        } catch (SQLException e) {
            throw new InfinitytravelConnectionDbException("Encountered problem connection to database during insert call", e);
        }
    }
    @Override
    public Discount getByCode(String discount_code) {
        Discount discount = null;
        try(Connection connection = JdbcUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_BY_DISCOUNT_CODE_SQL)) {
            statement.setString(1, discount_code);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    discount = readDiscount(resultSet);
                }
            } catch(Exception e) {
                throw new InfinitytravelQueryDbException("Encounted a problem executing the FIND_BY_DISCOUNT_CODE_SQL command", e);
            }
        } catch(SQLException e) {
            throw new InfinitytravelConnectionDbException("Encountered problem connection to database during getByCode call", e);
        }
        return discount;
    }

    @Override
    public int update(Discount discount) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Discount discount) throws SQLException {
        return 0;
    }

    private Discount readDiscount(ResultSet resultSet) throws SQLException {
        int discount_id = resultSet.getInt("discount_id");
        String coupon_code = resultSet.getString("coupon_code");
        int percentage = resultSet.getInt("percentage");
        Date creation_date = resultSet.getDate("creation_date");
        boolean utilized = resultSet.getBoolean("utilized");

        return new Discount(discount_id, coupon_code, percentage, creation_date, utilized);
    }
}
