package gradlejdbc.database.executingSQLQueries;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import gradlejdbc.database.createConnection.CreateConnection;

public class UpdatingData {
	public static void main(String[] args) {
		//updating only name
		try {
			DataSource dataSource = CreateConnection.createDataSource();
			Connection connection = dataSource.getConnection();
			try {
				BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter the name: ");
				String updatedName = bReader.readLine();
				System.out.println("Enter the id: ");
				int id = Integer.parseInt(bReader.readLine());
				String sqlString = "update userdata set uname = ? where uid = ?";
				PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
				preparedStatement.setString(1, updatedName);
				preparedStatement.setInt(2, id);
				preparedStatement.executeUpdate();
				System.out.println("Updated the userdata name to: "+updatedName+" for id: "+id+"");
				preparedStatement.close();
			} finally {
				// TODO: handle finally clause\
				connection.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}
}
