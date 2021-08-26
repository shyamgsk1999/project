import java.io.*;  
 import java.sql.*;  
 import javax.sql.*;  
 import java.util.*;  
 public class DBSwitch  
  {  
  public static void main(String[] args) throws Exception   
   {   int rno,age;  
      String usn,name,marks;    
      Connection con=null;  
      Statement s=null;  
      ResultSet rs=null;  
     int ch;  
     boolean flag=true;  
           Scanner sc=new Scanner(System.in);  
  
//CHANGE THIS LINE
   Class.forName("oracle.jdbc.driver.OracleDriver");  
      System.out.println("Successfully registered driver");  
   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","shyam","root");  
      System.out.println("Got connected with DB");  
      
        
 do  
 {   
 System.out.println("Press 1 to INSERT into the DB");  
  System.out.println("Press 2 to DELETE from DB");  
  System.out.println("Press 3 to UPDATE into DB");  
 System.out.println("Press 4 to VIEW ALL from DB");  
 System.out.println("Press 5 to EXIT");  
 System.out.println("Enter your choice");  
 ch=Integer.parseInt(sc.nextLine());  
   
 switch(ch)  
 {  
 case 1:  
    
  System.out.println(" enter usn");  
   usn=sc.nextLine();  
   System.out.println(" enter name");  
   name=sc.nextLine();  
   System.out.println(" enter marks");  
   marks=sc.nextLine();   
    try  
   {  
    String query="Insert into stud values(?,?,?)";  
    PreparedStatement p = con.prepareStatement(query);
    p.setString(1,usn); 
    p.setString(2,name);
    p.setString(3,marks);
    p.executeUpdate();
     
   System.out.println("row inserted");  
    }  
   
      catch(Exception e)  
    {  
    System.out.println("error2"+e);  
    
    }      
   break;  
    
 case 2:  
   
    try  
   {  
       System.out.println("Eneter the usn");  
       String str2=sc.nextLine();  
    String query="delete from stud where usn=?"; 
    
       PreparedStatement p = con.prepareStatement(query);
       p.setString(1, str2);
      int x = p.executeUpdate();
    System.out.println("deleted rows are:"+x);  
   
   }  
    catch(Exception e)  
    {  
    System.out.println("error3"+e);  
    
    }     
   break;  
   
 case 3:  
   
  try  
   {  
    System.out.println("enter usn to be updated");  
    String usn1=sc.nextLine();  
    System.out.println("Enter updated marks");
    String mk = sc.nextLine();
    String query="update stud set marks=? where usn= ?";  
    PreparedStatement p = con.prepareStatement(query);
    p.setString(1, mk);
    p.setString(2,usn1);
    int x=p.executeUpdate();  
    System.out.println("updated rows are:"+x);  
   
   }  
    catch(Exception e)  
    {  
    System.out.println("error4"+e);  
    
    }     
   break;  
   
 case 4:  
   
   try  
   {  
   
   String query="select * from stud ";  
   Statement ss = con.createStatement() ; 
  ResultSet rr=ss.executeQuery(query);  
     
   while(rr.next())  
   
   {  
   System.out.println(rr.getString(1)+"        "+rr.getString(2)+"       "+rr.getString(3));  
    }      
   

 

     
 
    
   }  
   
    catch(Exception e)  
    {  
    System.out.println("error5"+e);  
    
    }      
  break;  
 case 5:  
  System.exit(1);  
    break;  
   
 default:  
   System.out.println("iam default");  
   
 }  
 System.out.println("do u want to continue(yes /no)");  
 String str=sc.nextLine();  
 if(str.equals("yes")|| str.equals("y"))  
 flag=true;  
 if(str.equals("no")||str.equals("no"))  
 flag=false;  
   
 }while(flag);    
  }  
 }  