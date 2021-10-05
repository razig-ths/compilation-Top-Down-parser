
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author farid
 */
public class editfile {
	 public void  editf () {   
    try {
            FileWriter text = new FileWriter("C:\\Users\\Afak\\Desktop\\framecompl\\text.txt");
            String c ;
            Scanner scan = new Scanner(System.in) ;
            System.out.println("Enter what do you want :");
            c = scan.nextLine();
            // c = "bla bla bla bla";
            text.write(c);
            text.close();
            System.out.println("Successfully wrote to the file");
        
        
        } catch (IOException ex) {
        System.out.println("Error !!");
        ex.printStackTrace();
        }
        
    
} 
 //********************************
  String data = null;
  public void readf() {
      try {
           File text = new File("C:\\Users\\Afak\\Desktop\\framecompl\\text.txt");
           Scanner reader = new Scanner(text);
           while (reader.hasNextLine()) {
             String c = reader.nextLine();
              data = c ;
             //System.out.println(c);
           }
           reader.close();
      } catch (FileNotFoundException ex) {
          System.out.println("Error !!");
          ex.printStackTrace();
      } 
	  
      
      
  }

	
}
