
package final_project;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class admin    { 
    public static int totalSpots;
    public admin (){
    }
    /*Start Employees Section */
    public void addEmployee(String id , String employee,String jop , String pass ) {
        try {
            FileWriter fw = new FileWriter("D:\\LOL\\PROGRMMING\\Java\\pl_2 project\\final_project\\src\\back end\\Employee.txt",true);
            try (PrintWriter pw = new PrintWriter(fw)) {
                pw.print(id+" ");
                pw.print(employee+" ");
                pw.print("#"+jop);
                pw.println(" "+pass);
                pw.close();
            }
        } catch (IOException ex) {
            
        }
        
    }
    public String getEmployeeName(){
        String x="";
        File EmFile=new File("D:\\LOL\\PROGRMMING\\Java\\pl_2 project\\final_project\\src\\back end\\Employee.txt");
        try{
        Scanner input =new Scanner(EmFile);
            x="[Id] , [Name] , [Jop]\n";
            x+="_______________________";
            while(input.hasNext()){
                x+="\n"+input.next()+"   -    ";
                x+=input.next()+"    -    ";
                x+=input.next()+"     ";
                input.next();
                
            }
            input.close();
        }catch(IOException e){
            
        }
        return x;
   }
    public int  getNumOfEmployee(){
    File inputFile = new File("D:\\LOL\\PROGRMMING\\Java\\pl_2 project\\final_project\\src\\back end\\Employee.txt");
    int count = 0;
    try{
    Scanner fileScanner = new Scanner(inputFile);
   
   while(fileScanner.hasNext()) //if you are trying to count lines
   {     
       fileScanner.nextLine();
       count++;
   }
   fileScanner.close();
    }catch(FileNotFoundException e){
    }
   return count;
    }
    public String removeEmployee(String id ){
        String x="";
        int i=0;
        int j=0;
            String old ="D:\\LOL\\PROGRMMING\\Java\\pl_2 project\\final_project\\src\\back end\\Employee.txt";
            String temp ="D:\\LOL\\PROGRMMING\\Java\\pl_2 project\\final_project\\src\\back end\\temp.txt";
            File oldFile = new File(old);     
            File newFile = new File(temp);
            String ID ="";String name="";String job=""; String pass="";
            try{
            FileWriter fw =new FileWriter(newFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);
            Scanner input = new Scanner(new File(old)); 
            while(input.hasNext()){
                ID=input.next();
                name=input.next();
                job=input.next();
                pass=input.next();
                if (!ID.equals(id)){
                    pw.println(ID+" "+name+" "+job+" "+pass);
                    i++;
                }
                j++;
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
                x="Employee not Found !!";
                return x;
            }
            else{
            if (successful){
                x="Employee has Removed!!";
            }
            else
                x="Faild";
                }
            }catch(IOException e){
                            }
            return x;
            }
    
    public  void UpdateEmployeeName (String id ,String oldString, String newString){
      String  filePath ="D:\\LOL\\PROGRMMING\\Java\\pl_2 project\\final_project\\src\\back end\\Employee.txt";
        File fileToBeModified = new File(filePath);
         String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        try{
        Scanner input =new Scanner (fileToBeModified);
        while(input.hasNext()){
            if (id.equalsIgnoreCase(input.next())){
                try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
             
            //Reading all the lines of input text file into oldContent
             
            String line = reader.readLine();
             
            while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                 
                line = reader.readLine();
            }
             
            //Replacing oldString with newString in the oldContent
             
            String newContent = oldContent.replaceAll(oldString, newString);
             
            //Rewriting the input text file with newContent
             
            writer = new FileWriter(fileToBeModified);
             
            writer.write(newContent);
        }
        catch (IOException e)
        {
        }
        finally
        {
            try
            {
                //Closing the resources
                 
                reader.close();
                writer.close();
            } 
            catch (IOException e) 
            {
            }
        }
                break;
            }
            input.next();
            input.next();
            input.next();
        }
        input.close();
        }catch(Exception e){}
       
         
        
    }
    public  int numberOfSpots(){
     String old ="D:\\LOL\\PROGRMMING\\Java\\pl_2 project\\final_project\\src\\back end\\totalSpots.txt";
            File oldFile = new File(old);     
            try{
                Scanner input =new Scanner (oldFile);
                totalSpots=input.nextInt();
            }catch(FileNotFoundException e){     
            }
            return totalSpots;
    }
    public void addSpots(int incrase){
         String old ="D:\\LOL\\PROGRMMING\\Java\\pl_2 project\\final_project\\src\\back end\\totalSpots.txt";
            File oldFile = new File(old);     
            try{
                Scanner input =new Scanner (oldFile);
                totalSpots=input.nextInt();
                totalSpots+=incrase;
            }catch(FileNotFoundException e){     
            }     
            try{
            FileWriter fw =new FileWriter(oldFile,false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw =new PrintWriter(bw);
            pw.print(totalSpots);
            pw.flush();
            pw.close();
            }catch(IOException e){
            }
    
    }
    public void SetnumOfSpots(int spot){
          String old ="D:\\LOL\\PROGRMMING\\Java\\pl_2 project\\final_project\\src\\back end\\totalSpots.txt";
            File oldFile = new File(old);     
            try{
            FileWriter fw =new FileWriter(oldFile,false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw =new PrintWriter(bw);
            pw.print(spot);
            pw.flush();
            pw.close();
            }catch(IOException e){
            }
    
    }
    
    public String CarDetils(){
        String x="";
        int count = 0;
        String y="";
        String id="";
        int p1;
        int p2;
        int p3;
        double theCost;
        long endTime=System.currentTimeMillis();
        long startTime=0;
        long totalTime=0;
        String car="null";
        File file =new File("D:\\LOL\\PROGRMMING\\Java\\pl_2 project\\final_project\\src\\back end\\cars.txt");
        try{
        Scanner input =new Scanner (file);      
        while(input.hasNext()){
            
               id=input.next();
                car=input.next();
                startTime=input.nextLong();
                totalTime=(endTime-startTime)/1000;
                p1=(int)totalTime%60;
                p2=(int)totalTime/60;
                p3=p2%60;
               p2=p2/60;
               theCost=  ((p2*20)+(p3*0.3333333333333333)+(p1*0.0055555555555556));
               y="The car number : "+id+
                "\nplate number :  [ "+car+" ]\nin the parking From : "+p2 + " : " + p3 + " : " + p1
               +"\nThe cost is : "+ (int)(theCost*100)/100.0+" LE\n\n";
               x+=y;
        }
        input.close();
        }catch(FileNotFoundException e){
        }
     
        try {
            Scanner read = new Scanner(file);
             while(read.hasNext()){
             id = read.next();
             read.next();
             read.next();
              count++;
            
             }
              x +="Total Cars: "+count;
              if (count==0){
                  x="There are no cars";
              }
        } catch (FileNotFoundException ex) {
            
        }
   
    return x;
    }
        
public double totalCost(){
    int p1;
        int p2;
        int p3;
        double theCost=0;
        long endTime=System.currentTimeMillis();
        long startTime=0;
        long totalTime=0;
        String car="null";
        File file =new File("C:\\Users\\DELL\\Desktop\\final_project\\src\\back end\\cars.txt");
        try{
        Scanner input =new Scanner (file);      
        while(input.hasNext()){
            
               input.next();
               input.next();
                startTime=input.nextLong();
                totalTime=(endTime-startTime)/1000;
                p1=(int)totalTime%60;
                p2=(int)totalTime/60;
                p3=p2%60;
               p2=p2/60;
               theCost +=  ((p2*20)+(p3*0.3333333333333333)+(p1*0.0055555555555556));
        }
        }catch(Exception e){
            
        }
        return (int)(theCost*100)/100.0;
}


}