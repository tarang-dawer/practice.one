package Assignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RecordGenerator {

	public static int i = 0;
	public static Timestamp timestamp = new Timestamp(
			System.currentTimeMillis());
	public static List<Integer> stockSymbolList = null;
	public static List<Integer> fractalStockSymbolList = null;
	public static Map<Integer, Integer> stockSymbolQuantity = null;
	public static Map<Integer, Integer> stockSymbolPrice = null;

	public static void main(String[] args) {
		RecordGenerator r = new RecordGenerator();

		stockSymbolList = r.getRandomSymbolList(70000, 70000);
		fractalStockSymbolList = r.getFractalStockSymbolList(0.3, 70008,
				stockSymbolList);
		stockSymbolQuantity = r.getAttribForStockSymbol(fractalStockSymbolList,
				100, 10000);
		stockSymbolPrice = r.getAttribForStockSymbol(fractalStockSymbolList,
				50, 500);

		String database = "assignment32";
		String tableName = database + ".trade";

		// connection string required to establish connection with the mysql
		// instance
		String connectionUrl = "jdbc:mysql://localhost:3306?db?useServerPrepStmts=false&rewriteBatchedStatements=true";

		// RecordGenerator recGenerator = new RecordGenerator();

		// get a list of insert statement records that need be stored in the
		// database

		// Register JDBC Driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Error while loading mysql driver...");
			throw new RuntimeException(e);
		}

		// create a connection using the connectionString above
		Connection connection = null;
		// Statement insert = null;
		try {
			connection = DriverManager.getConnection(connectionUrl, "root",
					"root");
			connection.setAutoCommit(false);

			// create a statement object for batch inserts
			// insert = connection.createStatement();

			String sql = "DROP DATABASE " + database;
			connection.prepareStatement(sql).executeUpdate();
			System.out.println("Database : " + database
					+ " dropped successfully");

		} catch (SQLException e1) {
			System.out.println("Error occured while trying to drop database :"
					+ database + ", " + e1.getMessage());
		}
		try {
			r.createDatabase(database, connection);
		} catch (SQLException e) {
			if (!e.getMessage().contains("database exists"))
				throw new RuntimeException("Unable to create database: "
						+ database + " ," + e);
		}

		try {
			r.createTable(database, tableName, connection);
		} catch (SQLException e) {
			if (!e.getMessage().contains("already exists"))
				throw new RuntimeException("Unable to create table: "
						+ tableName + " ," + e);
		}
		for (int j = 0; j < 100; j++) {
			// insert =
			r.insertRecords(connection, tableName, j);
			// try {
			// insert.executeBatch();
			// connection.commit();
			//
			System.out.println("Batch: " + j + 1 + " inserted successfully");
			// } catch (SQLException e) {
			// // System.out.println(records);
			// throw new RuntimeException("Error while commiting batch, ", e);
			// }
		}

		System.out.println("Successfully inserted");

		try {
			connection.close();
		} catch (SQLException e) {
			System.err.println("Error closing connection...");
			throw new RuntimeException(e);
		}
	}

	private void createTable(String database, String tableName,
			Connection connection) throws SQLException {
		// String selectTable = "use database " + database;
		// connection.createStatement().executeQuery(selectTable);

		String sql = "CREATE TABLE " + tableName + " "
				+ "(`stocksymbol` INTEGER UNSIGNED NOT NULL, "
				+ "`time` DATETIME NOT NULL, "
				+ "`quantity` INTEGER UNSIGNED NOT NULL,"
				+ "`price` bigint UNSIGNED NOT NULL, "
				+ "  PRIMARY KEY (`time`))";

		connection.prepareStatement(sql).executeUpdate();

		System.out.println("Created table " + tableName + " in database :"
				+ database);

	}

	private void createDatabase(String database, Connection connection)
			throws SQLException {
		String dbCreate = "CREATE DATABASE " + database;

		connection.prepareStatement(dbCreate).executeUpdate();
		System.out.println("Created database: " + database + " successfully");

	}

	public List<Integer> getRandomSymbolList(int range, int numberOfRecords) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < numberOfRecords; i++) {
			list.add((int) Math.floor(Math.random() * range));
		}
		return list;
	}

	public void insertRecords(Connection connection, String tableName,
			int iteration) {
		PreparedStatement ps = null;
		try {
			ps = connection
					.prepareStatement("Insert IGNORE into "
							+ tableName
							+ " (stocksymbol, time, quantity, price) values (?, ?, ?, ?);");
		} catch (SQLException e) {
			throw new RuntimeException("Error while generating records" + e);
		}

		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// Random random = new Random();
		// int millisIn1Day = 24 * 60 * 60 * 1000;
		// long todaysDateinMilis = 1448031600000l + iteration * millisIn1Day;//
		// start
		// from
		// 11-20-2015
		// 10:00:00
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(timestamp.getTime());
		// System.out.println("Current Cal: "+cal.getTime() );
		// System.out.println("Size: " + fractalStockSymbolList.size());

		for (int symbol : fractalStockSymbolList) {
			i++;
			cal.add(Calendar.SECOND, 1);
			timestamp = new Timestamp(cal.getTime().getTime());
			try {
				// System.out.println(timestamp);
				ps.setInt(1, symbol);
				ps.setTimestamp(2, timestamp);
				ps.setInt(3, stockSymbolQuantity.get(symbol));
				ps.setLong(4, getPrice(symbol));
				ps.addBatch();

				ps.execute();
				if (i % 100000 == 0) {
					connection.commit();
					ps.close();

					ps = connection
							.prepareStatement("Insert IGNORE into "
									+ tableName
									+ " (stocksymbol, time, quantity, price) values (?, ?, ?, ?);");

				}
			} catch (SQLException e) {
				throw new RuntimeException("Error while generating records" + e);
			}

		}
		timestamp.setTime(cal.getTimeInMillis());
		// return ps;
	}

	private int getPrice(int symbol) {
		int price = stockSymbolPrice.remove(symbol);
		Random r = new Random();
		int low = 0;
		int high = 10;
		int rand = -1;
		do {
			rand = r.nextInt(high - low) - 5 + price;
		} while (rand == 0 || rand > 500 || rand < 50);
		stockSymbolPrice.put(symbol, rand);
		return rand;
	}

	private Map<Integer, Integer> getAttribForStockSymbol(
			List<Integer> fractalStockSymbolList, int low, int high) {
		Random r = new Random();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int symbol : fractalStockSymbolList) {
			int rand = r.nextInt(high - low) + low;
			if (rand > high)
				rand = low + 1;
			map.put(symbol, rand);
		}
		return map;
	}

	public List<Integer> getFractalStockSymbolList(double doubleValue,
			int range, List<Integer> numList) {
		while (range > 0) {
			range = (int) (doubleValue * range);
			numList.addAll(numList.subList(0, range));
		}
		return numList;
	}

}