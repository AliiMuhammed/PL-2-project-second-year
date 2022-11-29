
package final_project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *                

 * @author DELL
 */
public class Customer extends ExitStation  {
    private Date time;
    private SimpleDateFormat sf;
    
    
   public Customer(){
    time = new Date();
    sf = new SimpleDateFormat("yyyy/MM/dd   hh:mm a");   
   }
   
   public String payment(String id){
       String x="";
        long endTime=System.currentTimeMillis();
        long startTime=0;
        long totalTime=0;
        double theCost=0;
        String car="null";
        File file =new File("D:\\LOL\\PROGRMMING\\Java\\pl_2 project\\final_project\\src\\back end\\cars.txt");
        try{
        Scanner input =new Scanner (file);      
        while(input.hasNext()){
            if(input.next().equals(id)){
                car=input.next();
                startTime=input.nextLong();
                break;
            }

        }
        totalTime=(endTime-startTime)/1000;
        int p1=(int)totalTime%60;
        int p2=(int)totalTime/60;
        int p3=p2%60;
        p2=p2/60;
        theCost=  ((p2*20)+(p3*0.3333333333333333)+(p1*0.0055555555555556));
        if(car.equalsIgnoreCase("null")){
            x="car not found!!";
            return x;
        }
        input.close();
        }catch(FileNotFoundException e){
        }
        x="You Shoulde Pay : "+(int)(theCost*100)/100.0+" L.E";
        return  x;
   }
   
     
     public String gettext( String id)  {
        String Time="";
        String car="";
        String ticket="null";
        File file =new File("D:\\LOL\\PROGRMMING\\Java\\pl_2 project\\final_project\\src\\back end\\cars.txt");
        try{
        Scanner input =new Scanner (file);      
        while(input.hasNext()){
            if(input.next().equals(id)){
                car=input.next();
                input.next();
                Time=sf.format(time);
                ticket="Your Id : "+id+"\nCar number : "+car+"\nDate : "+Time;
                break;
            }

        }
        if(ticket.equalsIgnoreCase("null")){
            ticket="car not found!!";
            
        }
        input.close();
        }catch(FileNotFoundException e){
        }
        
        return  ticket;
    }
    
}