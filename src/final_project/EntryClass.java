
package final_project;
import java.io.*;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.*;

public class EntryClass extends admin{
    private String id;
    private String No_Of_Car;
    private long startTime;
    private static int sizeOfplace  ;     
    public EntryClass() {
        startTime = System.currentTimeMillis();
        setNumOfSpots();
       
    }
    private void setNumOfSpots(){
        String sopt ="D:\\LOL\\PROGRMMING\\Java\\pl_2 project\\final_project\\src\\back end\\Spots.txt";
        String car ="D:\\LOL\\PROGRMMING\\Java\\pl_2 project\\final_project\\src\\back end\\cars.txt";
            File spotFile = new File(sopt);
            File carFile = new File(car);
            int num=numberOfSpots();
            try{
            Scanner input =new Scanner (carFile);
            if (input.hasNext()){
                Scanner input2=new Scanner(spotFile);
                sizeOfplace =input2.nextInt();
            }
            else{
            FileWriter fw =new FileWriter(spotFile,false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw =new PrintWriter(bw);
            pw.print(num);
            pw.flush();
            pw.close();
            }
            }catch(IOException e){
            }
    }
    public void getSpot() {
            
            File file=new File("D:\\LOL\\PROGRMMING\\Java\\pl_2 project\\final_project\\src\\back end\\Spots.txt");
            File spot=new File ("D:\\LOL\\PROGRMMING\\Java\\pl_2 project\\final_project\\src\\back end\\placeNum.txt");
            try{
            Scanner input =new Scanner (file);
            while(input.hasNext()){
                this.sizeOfplace=input.nextInt();
            }
            input.close();
            }catch(FileNotFoundException e){
            }
            try{
                FileWriter fw=new FileWriter(spot,true);
                PrintWriter pw =new PrintWriter(fw); 
                if(sizeOfplace>0)
                    pw.println(sizeOfplace);
                pw.close();
            }catch(Exception e){
                
            }
        
    }
    public String Entry( String id, String No_Of_Car) {
     String x="";
     updateSpots();
    getSpot();
    this.id = id;
    this.No_Of_Car = No_Of_Car;
    String path1 = "D:\\LOL\\PROGRMMING\\Java\\pl_2 project\\final_project\\src\\back end\\cars.txt"; 
    File file1 = new File(path1);
    try{
    if(!file1.exists())
    {
    file1.createNewFile();
    }
    if(sizeOfplace>0){
    FileWriter writer1 = new FileWriter(path1,true);
    writer1.write(id+" ");
    writer1.write(No_Of_Car+" ");
    writer1.write(startTime+"\n");
    writer1.close();
    sizeOfplace--;
    
    }
    else{
       x="Parking is Full , Sorry :( ";
       
    }
       copy();
      updateSpots();
    }catch(Exception e){
        
    }
    
      return x;
    }
    private void updateSpots(){
         String old ="D:\\LOL\\PROGRMMING\\Java\\pl_2 project\\final_project\\src\\back end\\Spots.txt";
            File oldFile = new File(old);     
            try{
            FileWriter fw =new FileWriter(oldFile,false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw =new PrintWriter(bw);
            pw.print(sizeOfplace);
            pw.flush();
            pw.close();
            }catch(IOException e){
            }
    
        }
    public int numOfFreeSpots(){
         String car ="D:\\LOL\\PROGRMMING\\Java\\pl_2 project\\final_project\\src\\back end\\cars.txt";
         File carFile = new File(car);
         int count=0;
          try{
            Scanner input =new Scanner (carFile);
            if (!input.hasNext()&&sizeOfplace==0)
               return numberOfSpots();
            else{
                while (input.hasNext()){
                    input.nextLine();
                    count++;
                }
                this.sizeOfplace=count;
                this.sizeOfplace=numberOfSpots()-sizeOfplace;
                updateSpots();
                return sizeOfplace;
            }
                
          }catch(IOException e){
            }
       return 1;
    }
    
    
    private void copy(){
  String sfile = "D:\\LOL\\PROGRMMING\\Java\\pl_2 project\\final_project\\src\\back end\\cars.txt";  
  String dfile = "D:\\LOL\\PROGRMMING\\Java\\pl_2 project\\final_project\\src\\back end\\cars2.txt"; 
  try{
  FileReader fin = new FileReader(sfile);  
  FileWriter fout = new FileWriter(dfile,false);  
  int c;  
  while ((c = fin.read()) != -1) {  
   fout.write(c);  
  }  
   
  fin.close();  
  fout.close();  
  }catch(Exception e){}
    
}
    
}