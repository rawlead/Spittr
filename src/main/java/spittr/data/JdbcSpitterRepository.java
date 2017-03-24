package spittr.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import spittr.Spitter;
import spittr.web.SpitterNotFoundException;

import javax.sql.RowSet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcSpitterRepository implements SpitterRepository {
    private JdbcOperations jdbc;

    @Autowired
    public JdbcSpitterRepository(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    public Spitter save(Spitter spitter) {
        jdbc.update("INSERT INTO Spitter (username, password, first_name, last_name, email)" +
                        " VALUES (?,?,?,?,?)",
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFirstName(),
                spitter.getLastName(),
                spitter.getEmail());
        return spitter;
    }

    public Spitter findByUsername(String username) throws SpitterNotFoundException {
        String QUERY = "SELECT id, username, null, first_name, last_name, email FROM Spitter where username=?";
        return jdbc.queryForObject(
                QUERY,
                new SpitterRowMapper(),
                username
        );
    }


    public List<Spitter> findAllSpitters() {
        String QUERY = "SELECT id, username, null, first_name, last_name, email FROM Spitter";
        return jdbc.query(QUERY,new SpitterRowMapper());
    }

    private static class SpitterRowMapper implements RowMapper<Spitter> {
        public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Spitter(
                    rs.getLong("id"),
                    rs.getString("username"),
                    null,
                    rs.getString("email"),
                    rs.getString("first_name"),
                    rs.getString("last_name")
            );

        }
    }


    public boolean spitterExists(String username) {
        String QUERY = "SELECT count(*) FROM Spitter where username=?";
        Integer cnt = jdbc.queryForObject(QUERY,Integer.class,username);
        return cnt != null && cnt > 0 && !username.equals("");
    }
}
