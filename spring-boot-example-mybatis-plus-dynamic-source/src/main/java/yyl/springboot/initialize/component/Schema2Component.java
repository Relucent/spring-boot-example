package yyl.springboot.initialize.component;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.baomidou.dynamic.datasource.annotation.DS;

@Component
@DS("slave")
public class Schema2Component {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void initialize() {
        jdbcTemplate.execute(""//
                + " CREATE TABLE hello2 (" //
                + "  id    INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL PRIMARY KEY, "//
                + "  name  VARCHAR(255), "//
                + "  value VARCHAR(255)  "//
                + " )");
        printCurrentJdbcUrl();
    }

    private void printCurrentJdbcUrl() {
        String jdbcUrl = jdbcTemplate.execute(new ConnectionCallback<String>() {
            @Override
            public String doInConnection(Connection conn) throws SQLException, DataAccessException {
                return conn.getMetaData().getURL();
            }
        });
        System.out.println(jdbcUrl);
    }
}