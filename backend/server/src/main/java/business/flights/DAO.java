package business.flights;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {

    List<T> getAll(int limit) throws SQLException;

    int save(T t) throws SQLException;

    int insert(T t) throws SQLException;

    int update(T t) throws SQLException;

    int delete(T t) throws SQLException;
}
