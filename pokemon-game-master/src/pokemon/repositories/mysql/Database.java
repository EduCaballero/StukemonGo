package pokemon.repositories.mysql;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Database {

	protected Connection connection;
	protected QueryRunner db;

	private final String jdbcDriver = "com.mysql.jdbc.Driver";
	private final String driver = "mysql";
	private final String dbHost = "127.0.0.1";
	private final int dbPort = 3306;
	private final String dbName = "pokemon";
	private final String dbUsername = "root";
	private final String dbPassword = "";

	public Database() {
		DbUtils.loadDriver(jdbcDriver);
		this.db = new QueryRunner();
	}

	public void setupConnection() throws SQLException {
		connection = DriverManager.getConnection(getURL(), dbUsername, dbPassword);
	}

	public void closeConnection() {
		DbUtils.closeQuietly(connection);
	}

	private String getURL() {
		return "jdbc:" + driver + "://" + dbHost + ":" + dbPort + "/" + dbName;
	}

}
