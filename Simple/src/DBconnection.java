import java.sql.*;

public class DBconnection {
   public static void main(String[] args) throws Exception {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection (
         "jdbc:mysql://localhost:3306/info","root", "root");
      
      Statement stmt = con.createStatement();
      String query =" SELECT c.CUS_FirstNAME, c.CUS_LastNAME, c.CUS_DOB, a.State, a.City, a.Country FROM customer c JOIN address a ON c.CUS_ID = a.CUS_ID where CUS_FirstName='Akshara'";
      ResultSet rs = stmt.executeQuery(query);
      System.out.println("Fname  Lname ");
      
      while (rs.next()) {
         String fname = rs.getString("CUS_FirstNAME");
         String lname = rs.getString("CUS_LastNAME");
         System.out.println(fname + "  " + lname);
      }
      System.out.println();
      System.out.println();
   }
}