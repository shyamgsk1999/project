import java.sql.*;  
public class MySQLdatabase {  
    public static void main(String[] args) {  
        try {  
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "shyam", "rootroot");  
            Statement s = con.createStatement();  
            s.execute("create table student ( stud_id integer,stud_name varchar(20),stud_address varchar(30) )"); // create a table  
            s.execute("insert into student values(001,'ARman','Delhi')"); // insert first row into the table   
            s.execute("insert into student values(002,'Robert','Canada')"); // insert second row into the table   
            s.execute("insert into student values(003,'Ahuja','Karnal')"); // insert third row into the table   
            ResultSet rs = s.executeQuery("select * from student");  
            if (rs != null) // if rs == null, then there is no record in ResultSet to show  
                while (rs.next()) // By this line we will step through our data row-by-row  
            {  
                System.out.println("________________________________________");  
                System.out.println("Id of the student: " + rs.getString(1));  
                System.out.println("Name of student: " + rs.getString(2));  
                System.out.println("Address of student: " + rs.getString(3));  
                System.out.println("________________________________________");  
            }  
            s.close(); // close the Statement to let the database know we're done with it  
            con.close(); // close the Connection to let the database know we're done with it  
        } catch (SQLException err) {  
            System.out.println("ERROR: " + err);  
        } catch (Exception err) {  
            System.out.println("ERROR: " + err);  
        }  
    }  
}  