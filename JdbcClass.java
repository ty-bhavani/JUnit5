package com.te.crudOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class JdbcClass implements JdbcOperation
{
	Connection con=null;
	PreparedStatement pstmt =null;
	 Statement stmt=null;
	 ResultSet rs=null;

@Override
public void insert(int userid, String username) {
try {
Class.forName("com.mysql.cj.jdbc.Driver");
  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcoperation?user=root&password=root");
String query = "insert into student values(?,?);";
 pstmt = con.prepareStatement(query);
pstmt.setInt(1, userid);
pstmt.setString(2, username);

pstmt.execute();
con.close();
}catch (Exception e) {
e.getMessage();
}
}

@Override
public ArrayList<Object> select() {
ArrayList<Object> obj=null;
try {
Class.forName("com.mysql.cj.jdbc.Driver");
     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcoperation?user=root&password=root");
    String query = "select * from student";
     stmt = con.createStatement();
   rs= stmt.executeQuery(query);
   obj = new ArrayList<Object>();
   while(rs.next())
   {
    int i1= rs.getInt("sid");
    obj.add(i1);
    String s1 = rs.getString("sname");
    obj.add(s1);
   }
      con.close();
} catch (Exception e) {
e.getMessage();
}

return obj;
}

@Override
public void update(int userid, String username) {
try {
Class.forName("com.mysql.cj.jdbc.Driver");
     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?user=root&password=root@123");
    String query = "upadte student set sname=? where sid=?;";
    pstmt = con.prepareStatement(query);
pstmt.setString(1, username);
pstmt.setInt(2, userid);
pstmt.execute();
con.close();
} catch (Exception e) {
e.getMessage();
}

}

@Override
public void delete(int userid) {
try {
Class.forName("com.mysql.cj.jdbc.Driver");
     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcopertaion?user=root&password=root");
    String query = "delete from student where sid=?;";
 pstmt = con.prepareStatement(query);

pstmt.setInt(1, userid);

pstmt.execute();
con.close();
} catch (Exception e) {
e.getMessage();
}

}

}
