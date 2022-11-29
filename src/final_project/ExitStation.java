
package final_project;
import java.util.*;
import java.io.*;
public class ExitStation extends EntryClass{
    public ExitStation() {
        
    }
    
    public String carState(String id){
        String x="";
        long endTime=System.currentTimeMillis();
        long startTime=0;
        long totalTime=0;
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
        double theCost=  ((p2*20)+(p3*0.3333333333333333)+(p1*0.0055555555555556));
        if(car.equalsIgnoreCase("null")){
            x="car not found!!";
        }else{
        x="The car number : "+id+
         "\nplate number :  [ "+car+" ]\nin the parking From : "+p2 + " : " + p3 + " : " + p1
        +"\nThe cost is : "+ (int)(theCost*100)/100.0+" LE";
        }
        input.close();
        }catch(FileNotFoundException e){
            
        }
        
       return x;
    }
    
    
        public String removeCar(String id ){
            String x ="";
            int i=0;
            int j=0;
            String old ="D:\\LOL\\PROGRMMING\\Java\\pl_2 project\\final_project\\src\\back end\\cars2.txt";
            String temp ="D:\\LOL\\PROGRMMING\\Java\\pl_2 project\\final_project\\src\\back end\\temp.txt";
            File oldFile = new File(old);     
            File newFile = new File(temp);
            String ID ="";String carNum="null";String time="";
            
            try{
            FileWriter fw =new FileWriter(newFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);
            Scanner input = new Scanner(new File(old)); 

            
            while(input.hasNext()){
                
                ID=input.next();
                carNum=input.next();
                time=input.next();
                if (!ID.equals(id)){
                    pw.println(ID+" "+carNum+" "+time);
                    j++;
                }
                 i++;
            }
            
              
            input.close();
            pw.flush();
            pw.close();
            bw.close();
            fw.close();
            oldFile.delete();
            File dump =new File(old);
            boolean successful = newFile.renameTo(dump);
            if (i==j){
                x="Car not Found !!";
                return x;
            }
            else{
            if (successful){
                x="successful operation";
                updateSpots();
                copy();
            }
            else
                x="Faild";
                }
            }catch(IOException e){
            }
            return x;
            }

         private void updateSpots(){
            int size=0;
            String old ="D:\\LOL\\PROGRMMING\\Java\\pl_2 project\\final_project\\src\\back end\\Spots.txt";
            File oldFile = new File(old); 
            try{
            Scanner input =new Scanner (oldFile);
            if(input.hasNext())
                 size=input.nextInt();
            input.close();
            }catch(FileNotFoundException e){
            }
            try{
            FileWriter fw =new FileWriter(oldFile,false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw =new PrintWriter(bw);
            pw.print(size+1);
            pw.flush();
            pw.close();
            }catch(IOException e){
            }
    
         }
        
     private void copy(){
  String sfile = "D:\\LOL\\PROGRMMING\\Java\\pl_2 project\\final_project\\src\\back end\\cars2.txt";  
  String dfile = "D:\\LOL\\PROGRMMING\\Java\\pl_2 project\\final_project\\src\\back end\\cars.txt"; 
  try{
  FileReader fin = new FileReader(sfile);  
  FileWriter fout = new FileWriter(dfile,false);  
  int c;  
  while ((c = fin.read()) != -1) {  
   fout.write(c);  
  }    
  fin.close();  
  fout.close();  
  }catch(IOException e){}
     }
}
