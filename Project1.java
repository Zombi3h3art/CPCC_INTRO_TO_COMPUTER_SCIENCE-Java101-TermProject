
/** this program is about making a IPO (input process output) for a portion of the code that can be used 
in the completly functioning program that solves a real world problem. 
I'm tasked to create a program to tell a gamer what graphics quality they will be able to run, based on their computer specifications
*/
import java.util.Scanner;
public class Project1
{
   public static void main(String[] args)
   {
         
      var keyboard = new Scanner(System.in);
      
      String cpuType;      
      System.out.println("What type of processor do you have? (example: Intel Core i5 13600K)");
      cpuType = keyboard.nextLine();
      
      // keyboard.nextLine();
      
      double gpuSpeed;      
      System.out.println(" What is the clock speed of your computers graphics card in Megahertz (MHz)");
      gpuSpeed = keyboard.nextDouble();
      
      
      double cpuSpeed;
      System.out.println("What is the clock speed of your computers processor in Megahertz (MHz)");
      cpuSpeed = keyboard.nextDouble();
      
      int cores;
      System.out.println("How many cores does your CPU have?");
      cores = keyboard.nextInt();
      
      //keyboard.nextLine();
      
      
      System.out.println("Is the hardware overclock-friendly? type Y or N");
      var overclockable = keyboard.next(); //they want me to make this char datatype
      
      keyboard.nextLine(); // skipping to nextLine because i dont want any issues from the cursor position in the compiler staying on the same line of .next() Method 
     
      

      
      System.out.println("Computer Hardware Recomendation Tool. \n Your type of processor: " + cpuType + "\nYour GPU Speed: " 
         + gpuSpeed + "\nYour Your CPU Speed: " + cpuSpeed +
         "\nYour CPU's Core Count is: " + cores + "\nIs the Hardware Overclock-Friendly?: " + overclockable);
     
      
   }
   
}