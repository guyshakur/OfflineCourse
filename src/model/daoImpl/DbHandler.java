package model.daoImpl;

import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import main.Main;

public class DbHandler {

	private String connectionString=null;
//	private Connection connection=null;
	private PreparedStatement statment=null;




	public String getConnectionString() {
		return connectionString;
	}

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}
	
	public static Connection connectToDb(String dbFile) throws Exception{
		try {
			String path=Main.class.getClassLoader().getResource("").getPath();
			String fullPath=URLDecoder.decode(path,"UTF-8");
			fullPath=fullPath.substring(1);
			fullPath=fullPath.replace("bin", "src");
			//String dbPath="jdbc:sqlite:"+fullPath+"offline_courses.db";
			String dbPath="jdbc:sqlite:"+fullPath+dbFile;
			DbHandler dbHandler=new DbHandler();
			dbHandler.setConnectionString(dbPath);
			return dbHandler.connect();
		}

		catch(Exception e){
			throw new Exception("ERROR: Failed to connect to DB. "+e.getMessage());
		}
	}
	
	private Connection connect() throws Exception {
		Connection connection=null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection=DriverManager.getConnection(connectionString);
		} catch (Exception e) {
			throw new Exception("Failed connecting to db. "+e.getMessage());
		}

		return connection;

	}
	
}
