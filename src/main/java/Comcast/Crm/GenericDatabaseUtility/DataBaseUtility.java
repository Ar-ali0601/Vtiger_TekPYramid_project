package Comcast.Crm.GenericDatabaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

public class DataBaseUtility {
      
	Connection conn;
	public void  getDbConnection (String Url ,String UserName ,String Password)  {
		try {
		Driver driver= new Driver();
		//DriverManager.registerDriver(driver);
		 DriverManager.getConnection(Url,UserName,Password);
		}catch (Exception e) {
		}
	}
	
	public void  getDbConnection ()  {
		try {
		Driver driverRef= new Driver();
		//DriverManager.registerDriver(driverRef);
		conn = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%","root");
		}catch (Exception e) {
		}
	}
	public void  CloseDbConnection()  {
try {
	conn.close();
}catch (Exception e) {
	// TODO: handle exception
}
	
	}	
	public ResultSet  executeSelectQuery(String query) throws Throwable {
		ResultSet result = null;
		try {
          Statement sta = conn.createStatement();
         result=  sta.executeQuery(query);
		}catch (Exception e) {
		}
		return  result;
	}
	
	public void  executeNonSelectQuery(String query) throws Throwable {
		int result = 0;
		try {
          Statement sta = conn.createStatement();
         result=  sta.executeUpdate(query);
		}catch (Exception e) {
		}
		return;
	}
	
}
