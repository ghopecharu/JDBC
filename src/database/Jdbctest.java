package database;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.math.*;

public class Jdbctest {

	public static void main(String[] args) {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce1","root","root");
		Statement stmt = con.createStatement();  
        ResultSet rs = stmt.executeQuery("select * from eproduct"); 
        
        while(rs.next()) {
            
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+ "    "+rs.getInt(3)); 
        }
         //stmt.executeUpdate("insert into eproduct (name, price, date_added) values ('HardDrive', 7000.00, now());"); 
         //stmt.executeUpdate("update eproduct set price=20000 where name='Laptop'");
        // stmt.executeUpdate("delete from eproduct where id=2");
        CallableStatement stmt1 = con.prepareCall("{call add_product(?, ?)}");
        stmt1.setString(1, "IPhone");
        
        BigDecimal obj = new BigDecimal(1900.50);
        
        stmt1.setBigDecimal(2, obj);
        stmt1.executeUpdate();
        
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
