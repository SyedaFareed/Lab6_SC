/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sc.lab6_2;

import java.sql.*;

/**
 *
 * @author Dell
 */
public class Database {
     Connection con = null;
     PreparedStatement preps = null;
    
    
     Database(){
      try{
	      //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "root");
                
                //con.close(); 
      }
      
      catch(Exception i){
          System.out.println(i);    //print exception
      }
                
    }   //end function connect
     
    
     public void delete(int regno){
         try{
             display(1,regno);  //checking if the student exists
         Statement stmt=con.createStatement();
         String rs="delete from student where RegNo="+regno+";"; 
         preps= con.prepareStatement(rs);
         preps.executeUpdate();
         System.out.println("\nRemoving student with ID= "+regno);
         display(0,1);  //displaying results after delete
         }catch(Exception e){ System.out.println(e);}  
           
     }
     
     public void display(int j, int regno){
         try{   
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from student"); 
            
            if(j==1){    //if j=1 then user wants to search a specific record
                rs=stmt.executeQuery("select* from student where RegNo="+regno+";"); //change rs to finding the record
                if (rs.next()==false)
                        System.out.println("\nNo student with ID= "+regno);
            }
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            
            for (int i = 1; i <= columnsNumber; i++) {  //printing column headings
                System.out.print(rsmd.getColumnName(i)+" ");
                if(i==columnsNumber)    //if the last column, insert new line
                    System.out.print("\n");
            }
            
            while (rs.next()) {   
                for (int i = 1; i <= columnsNumber; i++) {  //printing data
                    //if (i > 1) System.out.print(",  ");
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue + "  ");    //if the last column, insert new line
                    
                    if(i==columnsNumber) 
                        System.out.print("\n");
                }
              
            }   //end while
                   
            }catch(Exception e){ System.out.println(e);}  
            
     }      //end display function

    
}
