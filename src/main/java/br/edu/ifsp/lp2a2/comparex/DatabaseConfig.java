package br.edu.ifsp.lp2a2.comparex;



import com.zaxxer.hikari.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

  @Value("${DATABASE_JDBC}")
  private String dbUrl;
  @Value("${DATABASE_USER}")
  private String username;
  @Value("${DATABASE_PASSWORD}")
  private String password;

  @Bean
  public DataSource dataSource() {
      HikariConfig config = new HikariConfig();
      config.setJdbcUrl(dbUrl+"?user="+username+"&password="+password+"&ssl=true");
      config.setUsername(username);
      config.setPassword(password);
      return new HikariDataSource(config);
  }
}