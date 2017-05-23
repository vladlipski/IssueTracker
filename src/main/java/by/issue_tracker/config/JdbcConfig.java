package by.issue_tracker.config;


import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages = {"by.issue_tracker.*"})
@PropertySource("classpath:db.properties")
public class JdbcConfig {

    private static final String DRIVER = "db.driver";
    private static final String URL = "db.url";
    private static final String USERNAME = "db.username";
    private static final String PASSWORD = "db.password";
    private static final String REMOVE_ABANDONED = "db.removeAbandoned";
    private static final String INIT_SIZE = "db.initialSize";
    private static final String MAX_ACTIVE = "db.maxActive";

    private final Environment environment;

    @Autowired
    public JdbcConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean(destroyMethod = "close")
    public BasicDataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(getProperty(DRIVER));
        basicDataSource.setUrl(getProperty(URL));
        basicDataSource.setUsername(getProperty(USERNAME));
        basicDataSource.setPassword(getProperty(PASSWORD));
        basicDataSource.setRemoveAbandonedOnBorrow(Boolean.valueOf(getProperty(REMOVE_ABANDONED)));
        basicDataSource.setInitialSize(Integer.valueOf(getProperty(INIT_SIZE)));
        basicDataSource.setMaxTotal(Integer.valueOf(getProperty(MAX_ACTIVE)));
        return basicDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    private String getProperty(String key) {
        return environment.getProperty(key);
    }
}