package com.storm.kafka.mysql;

import java.sql.PreparedStatement;

import backtype.storm.tuple.Tuple;

public class MySqlDump {
	private MySqlConnection conn;

	public MySqlDump() {
		conn = new MySqlConnection();
		conn.open();
	}

	public void persist(Tuple tuple) {
		PreparedStatement statement = null;
		try {
			statement = conn.getConnection()
					.prepareStatement("insert into TestTable (id, dataitem) values (default, ?)");
			statement.setString(1, tuple.getString(0));

			int val = statement.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	public void close() {
		conn.close();
	}
}
