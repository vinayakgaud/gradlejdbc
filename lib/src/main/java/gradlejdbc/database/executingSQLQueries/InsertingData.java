package gradlejdbc.database.executingSQLQueries;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;
import javax.swing.JFileChooser;

import gradlejdbc.database.createConnection.CreateConnection;

public class InsertingData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//letting user choose file
		try {
			DataSource source = CreateConnection.createDataSource();
			Connection connection = source.getConnection();
			try {
				BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter the name: ");
				String name = bReader.readLine();
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.showOpenDialog(null);
				File file = jFileChooser.getSelectedFile();
				String sqlString = "insert into userdata(uname,upic) value(?,?)";
				PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
				preparedStatement.setString(1, name);
				preparedStatement.setBinaryStream(2, new FileInputStream(file));
				preparedStatement.executeUpdate();
				System.out.println("Data inserted successfully");
				preparedStatement.close();
			} finally {
				// TODO: handle finally clause
				connection.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}

}
