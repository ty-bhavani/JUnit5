package com.te.crudOperation;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class JdbcClassTest {

	Connection con=null;
	PreparedStatement pstmt =null;
	 Statement stmt=null;
	 ResultSet rs=null;

	@Test
	void testInsert() {
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcoperation?user=root&password=root");
	    JdbcClass jc = new JdbcClass();
	    jc.insert(1, "Bhavani");
	    String query = "select * from student";
	   stmt = con.createStatement();
	    rs= stmt.executeQuery(query);
	   assertEquals(1,rs.getInt(1));
	   assertEquals("Bhavani",rs.getString(2));
	   con.close();
	   
	} catch (Exception e) {
	e.getMessage();
	}
	}
	@Test
	void testUpdate() {
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcoperation?user=root&password=root");
	    JdbcClass jc = new JdbcClass();
	    jc.update(1, "Bhavani Prakash");
	    String query = "select * from student";
	     stmt = con.createStatement();
	   rs= stmt.executeQuery(query);
	   assertEquals("Bhavani Prakash", rs.getString(2));
	   con.close();
	} catch (Exception e) {
	e.getMessage();
	}

	}

	@Test
	void testSelect() {
	JdbcClass jc = new JdbcClass();
	ArrayList<Object> obj=jc.select();
	assertEquals(obj!=null, false);
	}

    @Test
	void testDelete() {
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcoperation?user=root&password=root");
	    JdbcClass jc = new JdbcClass();
	    jc.delete(1);
	    String query = "select * from student";
	    stmt = con.createStatement();
	    rs= stmt.executeQuery(query);
	   assertEquals(rs.next(), false);
	   con.close();
	} catch (Exception e) {
	e.getMessage();
	}
	}

	}


