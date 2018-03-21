/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

import java.util.Arrays;
import java.util.Scanner;


/**
 *
 * @author sfatima.bese14seecs
 */
public class student {
//       private int studentGrades[6][3] = new int[ reg_no ][ cgpa ];
//       String[] myStringArray = new String[3];
//       String[] myStringArray = {"a","b","c"};
//       String[] myStringArray = new String[]{"a","b","c"};
    private String student[][] = new String[ 6 ][ 3 ];
    Scanner input =new Scanner(System.in);
    
    student(){  //default constructor
        for(int i=0; i<6; i++) //checking resgistration numbers for uniqueness
            student[i][1]= "";
    }
    public Boolean valid(String x){
        for(int i=0; i<6; i++){ //checking resgistration numbers for uniqueness
            if(student[i][1].equals(x))
                return false;
        }
        return true;
    }
    
     public Boolean valid2(String x){
        Boolean y= true;
         try {
            Double.parseDouble(x);
      
            if (Double.parseDouble(x)<0 || Double.parseDouble(x)>4){
            System.out.println("\nInvlaid CGPA (less than zero or greater than 4)\n");  
            y= false;   
        }
            
        } 
        catch (NumberFormatException e) {
            System.out.println("\nInvlaid CGPA: Not double\n");
           y=false;
        }
        
        return y;
    }   
     
    public void fillInfo(){
        //Scanner input =new Scanner(System.in);
        Boolean x;
        for(int i=0; i<6; i++){
            for(int j=0; j<3; j++){
                if(j==0){
                System.out.println("\nEnter name for student"+i+"\n");   
                String name = input.nextLine();
                student[i][j]= name;   //Saving name into array
                }
                
                else if(j==1){
                do{
                    System.out.println("\nEnter unique registration number for student"+i+"\n"); 
                    System.out.println("If you enter a used registration number, you will be asked to enter it again\n");
                    String regno = input.nextLine();
                    x= valid(regno);
                    if (x==true)    //if registration number is unique
                        student[i][j]= regno;   //Saving registration number into array
                    }while(x!=true);   
                }
                
                else if(j==2){
                    do{
                System.out.println("\nEnter CGPA that is double, >0 and <=4 for student"+i+"\n");
                System.out.println("If you enter an invalid CGPA, you will be asked to enter it again\n");
                String cgpa = input.nextLine();
                x= valid2(cgpa);
                if (x==true)    //if cgpa is valid
                    student[i][j]= cgpa;   //Saving cgpa into array
                }while(x!=true); 
                }
                
            }   //end inner for 
        }   //end outer for
    }   //end function fillInfo
    
     public void display(){
        System.out.println("Our Array is "+Arrays.deepToString(student));
        Double min= Double.parseDouble(student[0][2]);
        Double max= 0.0;
        Double total= 0.0;
        
        for(int i=0; i<6; i++){ //computing min max and average of cgpa
            if(Double.parseDouble(student[i][2])>max)
                max= Double.parseDouble(student[i][2]); 
            if(Double.parseDouble(student[i][2])<min)
                min= Double.parseDouble(student[i][2]);
            total += Double.parseDouble(student[i][2]);
        }
        
        Double avg=total/6;
        
        System.out.println("\nMax CGPA is "+ max);
        System.out.println("\nMin CGPA is "+ min);
        System.out.println("\nAverage CGPA is "+ avg);
      
        System.out.println("Students with less than average CGPA: ");
        for(int i=0; i<6; i++){ //displaying students with less than average cgpa
            if(Double.parseDouble(student[i][2])< avg)
                System.out.println(student[i][0]+"\n");  //printing names    
        }
        
     }  //end display function
     
     public void rank(){
        System.out.println("Enter name of student that you want to search\n");
        String name = input.nextLine();
        int count=0;

        for(int i=0; i<6; i++){ //checking names
            if(student[i][0].equals(name)){
                System.out.println("Student GPA: \n"+student[i][2]);
                
            for(int j=0; i<6; i++){ //getting rank
                
                if(Double.parseDouble(student[j][2])> Double.parseDouble(student[i][2]))
                    count++; 
                }   //end for
            count++;
            System.out.println("Rank of student:"+name+" is "+count);
            }
            
            else{
               System.out.println("Student unavailable\n");
               break;}
        }
     }
}

