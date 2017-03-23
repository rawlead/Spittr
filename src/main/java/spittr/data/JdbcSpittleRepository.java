package spittr.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import spittr.Spittle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcSpittleRepository implements SpittleRepository {
    private JdbcOperations jdbc;

    @Autowired
    public JdbcSpittleRepository(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    public List<Spittle> findRecentSpittles() {
        return jdbc.query("SELECT id, message, created_at, latitude, longitude FROM Spittle" +
                        " order by created_at desc limit 20",
                new SpittleRowMapper());
    }

    public List<Spittle> findSpitles(long max, int count) {
        return jdbc.query("SELECT id, message, created_at, latitude, longitude FROM Spittle" +
                        " where id < ?" +
                        " order by created_at desc limit 20",
                new SpittleRowMapper(), max);
    }

    public Spittle findOne(long id) {
        List<Spittle> spittles = jdbc.query(
                "SELECT id, message, created_at, latitude, longitude" +
                        " FROM Spittle" +
                        " WHERE id=?",
                new SpittleRowMapper(), id);
        return spittles.size() > 0 ? spittles.get(0) : null;
    }

    public void save(Spittle spittle) {
        jdbc.update(
                "INSERT INTO Spittle (message, created_at, latitude, longitude)" +
                        " VALUES (?,?,?,?)",
                spittle.getMessage(),
                spittle.getTime(),
                spittle.getLatitude(),
                spittle.getLongitude()
        );
    }


    private static class SpittleRowMapper implements RowMapper<Spittle> {

        public Spittle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return new Spittle(
                    resultSet.getLong("id"),
                    resultSet.getString("message"),
                    resultSet.getDate("created_at"),
                    resultSet.getDouble("longitude"),
                    resultSet.getDouble("latitude")
            );
        }
    }
}