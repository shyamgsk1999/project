import java.util.*;
import java.io.*;
import java.sql.*;
import java.sql.SQLException;

 public class demo2
{
   public void Crudoperations()
   { 
    String continuedata = " ";
   System.out.println("Welcome");
   String connectionurl =
              "jdbc: sqlserver://DESKTOP-3HQ8C5Q:1433;"
                 + "database=studentDB;"
                 + "user=sa;"
                 + "password=Password@1;";
  do
 {
     System.out.println("Select options form below menu: ");
   System.out.println("Press 1 to Select data\nPress 2 to insert data\nPress 3 to delete data\nPress 4 to update data");
   Scanner sc=new  Scanner(System.in);
   var DataInput= sc.nextLine();
   switch (DataInput)
  {
     case "1":
         ResultSet resultSet = null;
       try (Connection connection = DriverManager.getConnection(connectionurl);
                 Statement statement = connection.createStatement();)
      {
                String selectsql = "SELECT * from Employee_Record";
              resultSet = statement.executeQuery(selectSql);
             while (resultSet.next())
            {
                  var str=String.format("%s %s %s %s %s %s %s %s", resultset.getString(1), resultset.getString(2), resultSet.getString(3), resultset.getString(4), resultset.getString(5),
                resultSet.getString(6), resultSet.getString(7));
                System.out.println(str);
            }
  }
catch (SQLException e)
{
e.printStackTrace();
}
break;
case "2":
try(Connection connection = DriverManager.getConnection (connectionurl)
{
System.out.println("Enter ID :");
var fname=sc.nextLine();
System.out.println(id);
System.out.println("Enter  Name :");
var 1name=sc.nextLine();
System.out.println(name);
System.out.println("Enter Gender:");
var email=sc.nextLine();
System.out.println(gender);
System.out.println("Enter hire_date :");
var gen=sc.nextLine();
System.out.println(hire_date);
System.out.println("Enter Salary :");
var dob=sc.nextLine();
System.out.println(salary);
System.out.println("Enter commission :");
var adharno=sc.nextLine();
System.out.println(Commission);
System.out.println("Enter dept_id :");
var driving=sc.nextLine();
System.out.println(dept_id);
PreparedStatement stmt=connection.prepareStatement("insert into Student
stmt.setString(1,id);
stmt.setString(2, name);
stmt.setString(3, gender);
stmt.setString(4,hire_date);
stmt.setString(5, salary);
stmt.setString(6, commission );
stmt.setString(7, dept_id);
stmt.executeUpdate();
System.out.println("Data Entered Successfully");
}
catch(SQLException e)
{
e.printStackTrace();
}
break;
case "3":
try (Connection connection = DriverManager.getConnection(connectionurl);
Statement stmt = connection.createStatement();)
{
System.out.println("Enter an ID you want to delete”);
var ID=sc.nextLine();
String Delquery= "delete from Student_Record where student_id = " + ID;
stmt.executeUpdate(Delquery);
System.out.println("Data Deleted successfully");
}
catch (SQLException e)
{
e.printStackTrace();
}
break;
//case “4”:
//try(Connection connection = DriverManager.getConnection(connectionurl);
//Statement stmt = connection.createStatement();)
//{
//   System.out.println("Enter an ID you want to update");  
//    var ID = sc.nextLine();  
//     String id;
//    id = sc.next();
//   System.out.println(“Press 1 to Update id\nPress 2 to Update name\nPress 3 to Update gender\nPress 4 to Update hiredate\n Press 5 to Update salary\nPress 6 to update commission\nPress 7 to update deptid”);
//Switch(n){
//case “1”:
//string query = “update Student_Record set id= ”+ id +” where id =’”+id”’”;
//int x = stmt.executeUpdate(query);
//System.out.println("updated rows are:"+x);
//Break;
//Case “2”:
//String name;
//System.out.println(“Enter name to update”);
//name = sc.next();
//string query = “update Student_Record set name= ”+ name +” where id =’”+id”’”;
//int x = stmt.executeUpdate(query);
//System.out.println("updated rows are:"+x);
//Break;
//
//Case “3”:
//String gender;
//System.out.println(“Enter gender to update”);
//name = sc.next();
//string query = “update Student_Record set gender= ”+ gender +” where id =’”+id”’”;
//int x = stmt.executeUpdate(query);
//System.out.println("updated rows are:"+x);
//Break;
//Case “4”:
//String hire_date;
//System.out.println(“Enter Hire date to update”);
//hire_date = sc.next();
//string query = “update Student_Record set hire_date= ”+ hire_date +” where id =’”+id”’”;
//int x = stmt.executeUpdate(query);
//System.out.println("updated rows are:"+x);
//Break;
//Case “5”:
//String  salary;
//System.out.println(“Enter salary to update”);
//salary = sc.next();
//string query = “update Student_Record set salary= ”+ salary +” where id =’”+id”’”;
//int x = stmt.executeUpdate(query);
//System.out.println("updated rows are:"+x);
//Break;
//Case “6”:
//String commission;
//System.out.println(“Enter commission to update”);
//commission = sc.next();
//string query = “update Student_Record set commission= ”+ commission +” where id =’”+id”’”;
//int x = stmt.executeUpdate(query);
//System.out.println("updated rows are:"+x);
//Break;
//Case “7”:
//String dept_id;
//System.out.println(“Enter Dept Id to update”);
//dept_id = sc.next();
//string query = “update Student_Record set dept_id= ”+ dept_id +” where id =’”+id”’”;
//int x = stmt.executeUpdate(query);
//System.out.println("updated rows are:"+x);
//Break;
//default:
//System.out.println(“You entered wrong input”);
//}

}
break;
default:
System.out.println("You have selected wrong input!!!!");
break;
}
System.out.println("Enter y to continue: else press any other key to exit the program")
continuedata = sc.nextLine();
if(continuedata.equals("y"))
System.out.println("You Have selected to continue");
}
while (continuedata.equals("y"));
System.out.println("You Have Exited the Program");
