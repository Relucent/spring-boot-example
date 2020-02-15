package yyl.springboot.component;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class InitializeComponent {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	public void initialize() {
		jdbcTemplate.execute(""//
				+ " CREATE TABLE IF NOT EXISTS `hello` (" //
				+ "  `id`    BIGINT(11)   NOT NULL auto_increment, "//
				+ "  `name`  VARCHAR(255) NOT NULL, "//
				+ "  `value` VARCHAR(255) NOT NULL, "//
				+ " PRIMARY KEY  (`id`) "//
				+ " )");
	}
}
