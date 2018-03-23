/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sc.lab6_2;

import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author Dell
 */
public class SCLab6_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Database d= new Database();
        Scanner sc=new Scanner(System.in);  
        int choice=123;
        int regno=0;
        
        while(choice!=-1)
        {
            System.out.println("\nEnter 0 to display all students\n..."
                    + "Enter 1 to view a specific student\n..."
                    + "Enter 2 to delete a specific student\n..."
                    + "Enter -1 to exit\n" );
            choice=sc.nextInt(); 

            if (choice==0)
                d.display(0,0);
            else if(choice!=-1){
                 System.out.println("Enter Registration number of the student\n");
                 regno= sc.nextInt();
                 
                 if(choice==1)
                     d.display(1, regno);
                 else{
                     d.delete(regno);
                 }
            }
        }
        
    }
    
}
