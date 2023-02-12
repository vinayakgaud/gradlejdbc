package gradlejdbc.database.executingSQLQueries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import java.io.FileOutputStream;
import java.sql.Blob;
import gradlejdbc.database.createConnection.CreateConnection;

public class FetchingData {
	public static void main(String[] args) {
		try {
			DataSource source = CreateConnection.createDataSource();
			Connection connection = source.getConnection();
			try {
				String sqlString = "Select * from userdata";
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(sqlString);
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("ID: "+id);
					String name = rs.getString(2);
					System.out.println("Name: "+name);
					Blob blob = rs.getBlob(3);
					String updateNameString = name.replaceAll(" ", "");
					byte[] bArr = blob.getBytes(1, (int)blob.length());
					FileOutputStream fos = new FileOutputStream("(pathForStorage)"+updateNameString+"#"+id+".png");
					fos.write(bArr);
					fos.close();
					System.out.println("Picture: "+updateNameString+"#"+id+".png");
					System.out.println("Saved the image in images folder under resources,\nPath: (pathForStorage)");
				}
				statement.close();
				rs.close();
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
