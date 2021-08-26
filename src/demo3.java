import java.util.*;
import java.io.*;
import java.sql.*;

 

import java.sql.Connection;
import java.sql.DriverManager;

 


 public class demo3
{
   public static void main(String[] args) throws SQLException
   { 
    String continuedata = " ";
   System.out.println("Welcome");
   String connectionurl =
              "oracle.jdbc.driver.OracleDriver;"
                 + "jdbc:oracle:thin:@localhost:1521:xe;"
                 + "user=system;"
                 + "password=santhu;";
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
                String selectsql = "SELECT * from Employee";
              resultSet = statement.executeQuery(selectsql);
             while (resultSet.next())
            {
                  var str=String.format("%s %s %s %s %s %s %s %s", resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
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
try(Connection connection = DriverManager.getConnection (connectionurl))
{
System.out.println("Enter ID :");
var id=sc.nextLine();
System.out.println(id);
System.out.println("Enter  Name :");
var name=sc.nextLine();
System.out.println(name);
System.out.println("Enter Gender:");
var gender=sc.nextLine();
System.out.println(gender);
System.out.println("Enter hire_date :");
var hire_date=sc.nextLine();
System.out.println(hire_date);
System.out.println("Enter Salary :");
var salary=sc.nextLine();
System.out.println(salary);
System.out.println("Enter commission :");
var Commission=sc.nextLine();
System.out.println(Commission);
System.out.println("Enter dept_id :");
var dept_id=sc.nextLine();
System.out.println(dept_id);
PreparedStatement stmt=connection.prepareStatement("insert into Employee stmt.setString(1,id); stmt.setString(2, name);stmt.setString(3, gender);stmt.setString(4,hire_date);stmt.setString(5, salary);stmt.setString(6, commission );stmt.setString(7, dept_id);");
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
System.out.println("Enter an ID you want to delete");
var ID=sc.nextLine();
String Delquery= "delete from Employee where student_id = " + ID;
stmt.executeUpdate(Delquery);
System.out.println("Data Deleted successfully");
}
catch (SQLException e)
{
e.printStackTrace();
}
break;
case "4":
try(Connection connection = DriverManager.getConnection(connectionurl);
Statement stmt = connection.createStatement();)
{
   System.out.println("Enter an ID you want to update");  
    var ID = sc.nextLine();  
     String id;
    id = sc.next();
    String query = "update Employee set id= "+ id +" where id ='"+id+"'";
    int x = stmt.executeUpdate(query);
    System.out.println("updated rows are:"+x);
    break;
}
catch(SQLException e)
{
e.printStackTrace();
}
/*case "4":
try(Connection connection = DriverManager.getConnection(connectionurl);
Statement stmt = connection.createStatement();)
{
   System.out.println("Enter an ID you want to update");  
    var ID = sc.nextLine();  
     String id;
    id = sc.next();
   System.out.println("Press 1 to Update id\nPress 2 to Update name\nPress 3 to Update gender\nPress 4 to Update hiredate\n Press 5 to Update salary\nPress 6 to update commission\nPress 7 to update deptid");
   String n;
   n = sc.next();
   switch(n){
case "1":
String query = "update Employee set id= "+ id +" where id ='"+id+"'";
int x = stmt.executeUpdate(query);
System.out.println("updated rows are:"+x);
break;
case "2":
String name;
System.out.println("Enter name to update");
name = sc.next();
String query2 = "update Employee set name= "+ name +" where id ='"+id+"'";
 x = stmt.executeUpdate(query2);
System.out.println("updated rows are:"+x);
break;

 

case "3":
String gender;
System.out.println("Enter gender to update");
gender = sc.next();
String query3 = "update Employee set gender= "+ gender +" where id ='"+id+"'";
x = stmt.executeUpdate(query3);
System.out.println("updated rows are:"+x);
break;

 

case "4":
String hire_date;
System.out.println("Enter hire_date to update");
hire_date = sc.next();
String query4 = "update Employee set hire_date= "+ hire_date +" where id ='"+id+"'";
 x = stmt.executeUpdate(query4);
System.out.println("updated rows are:"+x);
break;

 

case "5":
String salary;
System.out.println("Enter salary to update");
salary = sc.next();
String query5 = "update Employee set salary= "+ salary +" where id ='"+id+"'";
x = stmt.executeUpdate(query5);
System.out.println("updated rows are:"+x);
break;

 

case "6":
String commission;
System.out.println("Enter Commission to update");
commission = sc.next();
String query6 = "update Employee set commission= "+ commission +" where id ='"+id+"'";
x = stmt.executeUpdate(query6);
System.out.println("updated rows are:"+x);
break;

 

case "7":
String dept_id;
System.out.println("Enter Dept Id to update");
dept_id = sc.next();
String query7 = "update Employee set dept_id= "+ dept_id +" where id ='"+id+"'";
 x = stmt.executeUpdate(query7);
System.out.println("updated rows are:"+x);
break;

 

    default:
        System.out.println("You entered wrong input");
        break;
}
}
break;*/
default:
System.out.println("You have selected wrong input!!!!");
break;
}
System.out.println("Enter y to continue: else press any other key to exit the program");
continuedata = sc.nextLine();
if(continuedata.equals("y"))
System.out.println("You Have selected to continue");
}
while (continuedata.equals("y"));
System.out.println("You Have Exited the Program");
   }
}
 