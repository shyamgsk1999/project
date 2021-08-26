import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;

 

public class JDBCconnection {
    public static void main(String args[]) {
        try {
        Class.forName("oracle.jdbc.driver.OracleDriver"); // loading driver
        // to establish connection bridge
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ose","shyam","root");
        //to carry the code and result from java to db and again back to java resp. 
        Statement st = con.createStatement();
        
        ResultSet rs = st.executeQuery("select * from Name");
        while(rs.next()) {
            System.out.println(rs.getString(1)+" "+rs.getString(2));
        }
        int ch; 
        switch(ch)  
        {  
        case 1:  
           
        System.out.println(" enter name");    
        String insert = "insert into Name (fname,lname) values(?,?)";
        PreparedStatement p = con.prepareStatement(insert);
        p.setString(1, "Sonali");
        p.setString(2, "Rai");
        p.executeUpdate();
        
        case 2:
        String S ="Sonali";
        
        String dlt = "delete from name where fname=?";
        PreparedStatement pr = con.prepareStatement(dlt);
        pr.setString(1, S);
        pr.executeUpdate();
        
        
        
        }catch(Exception e) {
            System.out.println(e);
        
        }
        System.out.println("Connected");
        
        
        
    }
}