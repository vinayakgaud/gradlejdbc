package gradlejdbc.database.createConnection;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

public class CreateConnection {

	public static DataSource createDataSource() {
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl("jdbc:mysql://localhost:3306/gradlejdbc"); //url for the database instead of gradlejdbc update the databaseName we are working on
		ds.setUsername("root"); //username for mysql
		ds.setPassword("root"); //password for mysql
		return ds;
	}

}
