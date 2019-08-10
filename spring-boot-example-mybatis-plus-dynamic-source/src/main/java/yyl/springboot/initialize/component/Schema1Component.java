package yyl.springboot.initialize.component;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.baomidou.dynamic.datasource.annotation.DS;


@DS("master")
@Component
public class Schema1Component {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void initialize() {
        jdbcTemplate.execute(""//
                + " CREATE TABLE IF NOT EXISTS `hello1` (" //
                + " `id` BIGINT(11) NOT NULL auto_increment, "//
                + " `name` VARCHAR(255) NOT NULL, "//
                + " `value` VARCHAR(255) NOT NULL, "//
                + " PRIMARY KEY (`id`) "//
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
