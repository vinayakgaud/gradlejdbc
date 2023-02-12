package gradlejdbc.database.executingSQLQueries;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import gradlejdbc.database.createConnection.CreateConnection;

public class CreateTable {

	public static void main(String[] args) {
		//creating datasource
		DataSource dataSource = CreateConnection.createDataSource();
		try {
			//creating connection using datasource
			Connection connection = dataSource.getConnection();
			try {
				String query = "create table userdata(uid int primary key auto_increment,uname varchar(255),upic mediumblob)";
				Statement statement = connection.createStatement();
				statement.executeUpdate(query);
				System.out.println("Table created successfully");
				statement.close();
			} finally {
				connection.close();
				System.out.println("connection closed");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
