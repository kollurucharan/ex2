package com.charan;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@WebServlet("/Exservlet")
public class Exservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Exservlet() {
		super();

	}

	public void loop(ResultSet rs, HttpServletResponse response) throws JSONException, SQLException, IOException {
		JSONObject json = new JSONObject();
		String jsonString = null;

		while (rs.next()) {
			System.out.println("json1" + json);
			int a = rs.getInt(1);
			String b = rs.getString(2);
			String c = rs.getString(3);
			int d = rs.getInt(4);
			String e = rs.getString(5);
			String f = rs.getString(6);
			String h = rs.getString(7);
			System.out.println("json2" + json);
			json.put("a", a);
			json.put("b", b);
			json.put("c", c);
			json.put("d", d);
			json.put("e", e);
			json.put("f", f);
			json.put("h", h);
			System.out.println("json3" + json);
			jsonString = json.toString();
		}
		System.out.println("loop" + rs.toString());
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jsonString.toString());

	}

	masterjdbc mj = new masterjdbc();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String param1 = request.getParameter("img");

		if (param1.equals("first")) {
			try {
				String query = "select * from prod168 limit 1";
				mj.king(query);
				ResultSet rs = mj.input();
				System.out.println("fas:" + rs);
				loop(rs, response);
			} catch (Exception e) {
				System.out.println("error at resultset");
				System.out.println(e);
			}
		}

		else if (param1.equals("last")) {
			try {
				String query = "select * from prod16 LIMIT 1 OFFSET (SELECT COUNT(*) - 1 FROM prod16)";
				mj.king(query);
				ResultSet rs = mj.input();
				System.out.println("fas:" + rs);
				loop(rs, response);
			} catch (Exception e) {
				System.out.println("error at resultset");
				System.out.println(e);
			}
		}

		else if (param1.equals("start")) {
			try {
				String query = "select * from prod16 ";
				mj.king(query);
				ResultSet rs = mj.input();
				System.out.println("fas11111:" + rs);

				JSONArray jarray = new JSONArray();

				while (rs.next()) {
					int a = rs.getInt(1);
					String b = rs.getString(2);
					String c = rs.getString(3);
					int d = rs.getInt(4);
					String e = rs.getString(5);
					String f = rs.getString(6);
					String g = rs.getString(7);
					JSONObject json = new JSONObject();
					json.put("a", a);
					json.put("b", b);
					json.put("c", c);
					json.put("d", d);
					json.put("e", e);
					json.put("f", f);
					json.put("g", g);

					jarray.put(json);
				}
				System.out.println("fulldata" + jarray);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(jarray.toString());

			} catch (Exception e) {
				System.out.println("error at resultset");
				System.out.println("jkhdsf");
				System.out.println(e);
			}
		}

		else if (param1.equals("delete")) {
			try {
				int param2 = Integer.parseInt(request.getParameter("id"));
				String query = "DELETE FROM prod16 WHERE product_id = ?";
				mj.kinguu(query, param2);
				ResultSet rs = mj.input();
				System.out.println("delete:" + rs);

			} catch (Exception e) {
				System.out.println("error at delete");
				System.out.println(e);
			}
		}

		else if (param1.equals("add")) {
			try {
				int param2 = Integer.parseInt(request.getParameter("a1"));
				String param3 = request.getParameter("a2");
				int param4 = Integer.parseInt(request.getParameter("a3"));
				int param5 = Integer.parseInt(request.getParameter("a4"));
				String param6 = request.getParameter("a5");
				String param7 = request.getParameter("a6");
				String dateStr = request.getParameter("a7");
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date parsedDate = null;

				try {
					parsedDate = dateFormat.parse(dateStr);
				} catch (ParseException e) {
					System.out.println("11111111111111111111111111" + e);
					e.printStackTrace();
				}

				if (parsedDate != null) {
					java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());

					String query = "insert into prod16 values(?,?,?,?,?,?,?);";
					mj.kinguu(query, param2, param3, param4, param5, param6, param7, sqlDate);
					ResultSet rs = mj.input();
					System.out.println("delete:" + rs);
				} else {

					System.out.println("Invalid date format for param8");
				}

			} catch (Exception e) {
				System.out.println("error ataddd");
				System.out.println(e);
			}
		}

		else if (param1.equals("edit")) {
			try {
				int param2 = Integer.parseInt(request.getParameter("a1"));
				String param3 = request.getParameter("a2");
				int param4 = Integer.parseInt(request.getParameter("a3"));
				int param5 = Integer.parseInt(request.getParameter("a4"));
				String param6 = request.getParameter("a5");
				String param7 = request.getParameter("a6");
				String dateStr = request.getParameter("a7");
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date parsedDate = null;
				System.out.println("9999999999999");
				try {
					parsedDate = dateFormat.parse(dateStr);
				} catch (ParseException e) {
					System.out.println("22222222222222222" + e);
					e.printStackTrace();
				}

				if (parsedDate != null) {
					java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());

					String query = "update  prod16 set  product_name =?, price = ?,stock_quantity = ?, manufacturer =?,category = ?,purchase_date = ? where  product_id =?;";
					mj.kinguu(query, param2, param3, param4, param5, param6, param7, sqlDate);
					ResultSet rs = mj.input();
					System.out.println("update:" + rs);
					rs.close(); 
				}
			} catch (Exception e) {
				System.out.println("error at edit");
				e.printStackTrace();
			}
		}

	}
}
