import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;
 
 
/*
 * 
 * Main Class
 */
 
public class JDBCExample{
 
    public static void main(String[] args) throws Exception{
         
            Scanner scan = new Scanner(System.in);
            Scanner scan2 = new Scanner(System.in);
                         
            SelectQuery sq = new SelectQuery();
            InsertQuery iq = new InsertQuery();
            UpdateQuery uq = new UpdateQuery();
            DeleteQuery dq = new DeleteQuery();
             
            Connection connection = DBCOnnection.getConnection();
             
            String con = "y";
 
        while(con.equalsIgnoreCase("y"))
            {
            System.out.println("Enter Choice:\n1.ViewData\n2.Insert Data\n3.Update Data\n4.Delete Data\n");
            int choice = scan.nextInt();
         
            switch(String.valueOf(choice))
            {
         
            case "1":{sq.sel();}        break;
            case "2":{iq.insert();}     break;  
            case "3":{uq.upd();}        break;
            case "4":{dq.delete();}     break;
            default :{System.out.println("Wrong Choice");}  break; 
         
        }
        System.out.println("\n\nContinue? (Y/N): ");
        con = scan2.nextLine();
        }
             
         
        }   
 
    }
 
 
/*
 * 
 * For Connection
 */
  
 class DBCOnnection {
 
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
                connection = DriverManager.getConnection(
                        "jdbc:oracle:thin:@localhost:1521:xe"
                                  ,"shyam","rootroot"
                        );
                 
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
     
}
 
 /*
  * 
  * To Delete
  */
 
 class DeleteQuery {
 
    public void delete() throws Exception{
        Connection connection = DBCOnnection.getConnection();
        Scanner sc = new Scanner(System.in);
         
        System.out.println("1.Delete a record\n2.Clear Table\n");
        int ch = sc.nextInt();
         
        if (ch==1)
        {
        System.out.println("Enter ID: "  );
        int eid = sc.nextInt();
                 
        Statement st = connection.createStatement();
                 
        String sql = "delete from emp where eid="+eid;
        System.out.println(sql);
         
        st.executeUpdate(sql);
         
        st.close();
        connection.close();
         
        System.out.println("\nDelete Successfull");
        }
         
        else if(ch == 2)
        {
            Statement st = connection.createStatement();
             
            String sql = "truncate table emp";
            System.out.println(sql);
             
            st.executeUpdate(sql);
             
            st.close();
            connection.close();
             
            System.out.println("\nTable Cleared");
        }
         
        else{System.out.println("Wrong Choice");}
    }
}
 
 /*
  * 
  * To Update
  */
  
 class UpdateQuery {
 
    public  void upd() throws Exception{
        Connection connection = DBCOnnection.getConnection();
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert Employee id to update record: "  );
        int eid = sc.nextInt();
        System.out.println("Enter New Name >>");
        String name = sc.next();
         
         
        Statement st = connection.createStatement();
         
        String sql = "update emp set ename='"+name+"' where eid="+eid;
                 
        st.executeUpdate(sql);
         
        st.close();
        connection.close();
         
        System.out.println("Update Successful");
    }
}
 
 /*
  * 
  * To Insert
  */
 
 class InsertQuery {
 
    public  void insert() throws Exception{
         
            Scanner sc = new Scanner(System.in);
             
            System.out.println("Enter Employee Name>> " );
            String name = sc.nextLine();
             
        Connection connection = DBCOnnection.getConnection();
         
        Statement st = connection.createStatement();
         
        String sql = "insert into emp(ename) values('"+name+"')";
         
         
        st.executeUpdate(sql);
         
        st.close();
        connection.close();
         
        System.out.println("Insert Successful");
         
        }
 
    }
 
 /*
  * 
  * To view
  */
 
 
 class SelectQuery {
 
    public  void sel() throws Exception{
        Connection connection = DBCOnnection.getConnection();
                 
        Scanner scan = new Scanner(System.in);
        Statement st = connection.createStatement();
        System.out.println("1.View a record\n2.View the table\n");
        int ch = scan.nextInt();
         
        if(ch==2)
        {
        String sql = "select * from emp";
         
        ResultSet rs = st.executeQuery(sql);
         
        if(rs == null)
        {
            System.out.println("Table Empty");
        }
         
        System.out.print("ID\t\tName\n");
        System.out.print("--\t\t----\n\n");
        while(rs.next()){
            System.out.println(rs.getInt(1)+"\t\t"+rs.getString("ename"));
        }
        rs.close();
         
        st.close();
        connection.close();
        }
         
        else if(ch == 1)
        {
            System.out.println("Enter Employee ID to view record:");
            int id = scan.nextInt();
            String sql = "select '"+id+"' from emp";
            ResultSet rs = st.executeQuery(sql);
             
            if(rs == null)
            {
                System.out.println("Table Empty");
            }
             
             
            while(rs.next()){
                System.out.println(rs.getInt(1)+"\t"+rs.getString("name"));
            }
            rs.close();
             
            st.close();
            connection.close();
        }
    }
                 
    }
