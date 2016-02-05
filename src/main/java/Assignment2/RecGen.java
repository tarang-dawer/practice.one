package Assignment2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RecGen {

	public static List<Integer> stockSymbolList = null;
	public static List<Integer> fractalStockSymbolList = null;
	public static Map<Integer, Integer> stockSymbolQuantity = null;
	public static Map<Integer, Integer> stockSymbolPrice = null;

	public static void main(String[] args) {
		RecGen r = new RecGen();

		stockSymbolList = r.getRandomSymbolList(70000, 70000);
		fractalStockSymbolList = r.getFractalStockSymbolList(0.3, 70008,
				stockSymbolList);
		stockSymbolQuantity = r.getAttribForStockSymbol(fractalStockSymbolList,
				100, 10000);
		stockSymbolPrice = r.getAttribForStockSymbol(fractalStockSymbolList,
				50, 500);

		String database = "assignment31";
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
		Statement insert = null;
		try {
			connection = DriverManager.getConnection(connectionUrl, "root",
					"root");
			connection.setAutoCommit(false);

			// create a statement object for batch inserts
			insert = connection.createStatement();

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
			List<String> records = r.getRecords(tableName, j);

			// add all insert statements in the insert statement object
			try {
				for (String updateSQL : records) {
					insert.addBatch(updateSQL);
					r.executeInsert(insert, connection);
					connection.commit();
					insert.clearBatch();
				}
				System.out.println("Batch: " + j + ", inserted successfully");
			} catch (SQLException e) {
				// System.out.println(records);
				throw new RuntimeException("Error while preparing batch, ", e);
			}
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

	private void executeInsert(Statement insert, Connection connection)
			throws SQLException {
		insert.executeBatch();
	}

	public List<Integer> getRandomSymbolList(int range, int numberOfRecords) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < numberOfRecords; i++) {
			list.add((int) Math.floor(Math.random() * range));
		}
		return list;
	}

	public List<String> getRecords(String tableName, int iteration) {
//		long i = 0;
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		int size = fractalStockSymbolList.size();
		List<String> listOfInserts = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		sb.append("Insert IGNORE into ");
		sb.append(tableName);
		sb.append("(" + "stocksymbol," + "time" + ",quantity,price"
				+ ") VALUES");
		Random random = new Random();
		int millisIn6Hrs = 24 * 60 * 60 * 1000;
		long todaysDateinMilis = 1448031600000l + iteration  * millisIn6Hrs;// start
																				// from
																				// 11-20-2015
																				// 10:00:00
		for (int symbol : fractalStockSymbolList) {
			date = new Date(todaysDateinMilis
					+ iteration*Math.abs(random.nextInt(millisIn6Hrs)));
			sb.append("(");
			sb.append(symbol + ", \"");
			sb.append(sdf.format(date).toString() + "\", ");
			sb.append(stockSymbolQuantity.get(symbol) + ", ");
			sb.append(getPrice(symbol) + ")");
			sb.append(", ");
		}
		sb.replace(sb.length() - 2, sb.length() - 1, ";");
		listOfInserts.add(sb.toString());
		System.out.println("Batch completed");
		return listOfInserts;
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
