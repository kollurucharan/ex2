package com.charan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class masterjdbc {
	Connection conn;
	Statement stat;
	PreparedStatement pstat;
	ResultSet rs;
	ArrayList<String> alll;

	public void king(String query) {
		alll = new ArrayList<>();
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training",
					"plf_training_admin", "pff123");
			stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stat.executeQuery(query);
			System.out.println("jdbc:" + rs);

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void kinguu(String query, int param2) {

		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training",
					"plf_training_admin", "pff123");
			pstat = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstat.setInt(1, param2);
			System.out.println(pstat.toString());
			rs = pstat.executeQuery();
		} catch (Exception ex) {
			System.out.println("HEDWTF4" + ex);
		}
	}

	public void kinguu(String query, int param2, String param3, int param4, int param5, String param6, String param7,
			Date param8) {

		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training",
					"plf_training_admin", "pff123");
			pstat = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			if (query.equals("insert into prod16 values(?,?,?,?,?,?,?);")) {
				pstat.setInt(1, param2);
				pstat.setString(2, param3);
				pstat.setInt(3, param4);
				pstat.setInt(4, param5);
				pstat.setString(5, param6);
				pstat.setString(6, param7);
				java.util.Date param8Date = param8;

				java.sql.Date sqlDate = new java.sql.Date(param8Date.getTime());

				pstat.setDate(7, sqlDate);

				pstat.executeQuery();
				System.out.println("jdbccccc:" + rs);
			} else if (query.equals(
					"update  prod16 set  product_name =?, price = ?,stock_quantity = ?, manufacturer =?,category = ?,purchase_date = ? where  product_id =?;")) {
				pstat.setInt(1, param2);
				pstat.setString(2, param3);
				pstat.setInt(3, param4);
				pstat.setInt(4, param5);
				pstat.setString(5, param6);
				pstat.setString(6, param7);
				java.util.Date param8Date = param8;

				java.sql.Date sqlDate = new java.sql.Date(param8Date.getTime());
				pstat.setDate(7, sqlDate);
				System.out.println("heloooooooooooooooo");
			}
		} catch (Exception ex) {
			System.out.println("helooo"+ex);
		}
	}

	public ResultSet input() {
		System.out.println(rs);
		return rs;

	}

}
