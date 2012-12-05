package com.octo.livecoding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultDao {

	/**
	 * 24/12/2002
	 * To Refactor
	 * @return List
	 */
	public static List<Result> query() {
		List<Result> r = new ArrayList<Result>();
		try {
			Class.forName("org.hsqldb.jdbcDriver").newInstance();
		} catch (InstantiationException e) {
			// Use RuntimeException, it's easier
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		// WTF
    	Connection c = null;
    	PreparedStatement p = null;
    	ResultSet res = null;
		try {
			
			// TODO Extract constant
			c = DriverManager.getConnection("jdbc:hsqldb:mem:test",
					"sa", "");
			p = c.prepareStatement("Select departement,manager,netprofit,operatingExpense from result");
	    	
			res = p.executeQuery();
	    	
	    	while(res.next()) {
	    		Result result = new Result();
	    		result.setDepartement(res.getString("departement"));
	    		result.setManager(res.getString("manager"));
	    		result.setNetProfit(res.getDouble("netprofit"));
	    		result.setOperatingExpense(res.getDouble("operatingExpense"));
	    		r.add(result);
	    	}
	    	
	    	return r;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			
			try {
				if(res != null)
					res.close();
				if(p != null)
					p.close();
				if(c != null)
					c.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
    	
    	
	}

}
