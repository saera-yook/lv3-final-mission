package finalmission;

import java.sql.Connection;
import java.sql.Statement;
import org.springframework.jdbc.core.JdbcTemplate;

public class Fixture {

    public static void resetH2TableIds(JdbcTemplate jdbcTemplate) {
        jdbcTemplate.execute((Connection connection) -> {
            try (Statement statement = connection.createStatement()) {
                statement.execute("DELETE FROM reservation");
                statement.execute("ALTER TABLE reservation AUTO_INCREMENT = 1");
                statement.execute("DELETE FROM member");
                statement.execute("ALTER TABLE member AUTO_INCREMENT = 1");
                statement.execute("DELETE FROM yoga_session");
                statement.execute("ALTER TABLE yoga_session AUTO_INCREMENT = 1");
                statement.execute("DELETE FROM yoga_course");
                statement.execute("ALTER TABLE yoga_course AUTO_INCREMENT = 1");
            }
            return null;
        });
    }
}
