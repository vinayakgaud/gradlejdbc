package gradlejdbc.database.createConnection;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

public class CreateConnection {

	public static DataSource createDataSource() {
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl("jdbc:mysql://localhost:3306/gradlejdbc");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}

}
