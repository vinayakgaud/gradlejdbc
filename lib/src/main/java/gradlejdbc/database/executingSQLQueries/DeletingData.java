package gradlejdbc.database.executingSQLQueries;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import gradlejdbc.database.createConnection.CreateConnection;

public class DeletingData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DataSource dataSource = CreateConnection.createDataSource();
			Connection connection = dataSource.getConnection();
			try {
				BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter the id: ");
				int id = Integer.parseInt(bReader.readLine());
				String sqlString = "delete from userdata where uid = ?";
				PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
				preparedStatement.setInt(1, id);
				preparedStatement.executeUpdate();
				System.out.println("deleted data for id: "+id+"");
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
