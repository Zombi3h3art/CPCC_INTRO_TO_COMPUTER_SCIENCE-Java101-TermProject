/** this program is about making a IPO (input process output) for a portion of the code that can be used 
in the completly functioning program that solves a real world problem. 
I'm tasked to create a program to tell a gamer what graphics quality they will be able to run, based on their computer specifications
*/
import java.util.Scanner;
public class Project2
   {
   public static void main(String[] args)
      {
      String title = "Computer Hardware Recomendation Tool";    
      Scanner keyboard = new Scanner(System.in);
      String cpuType;
      double gpuClockSpeed;  
      double cpuClockSpeed;
      int cpuCoreNumber;   
           
      System.out.println("What type of processor do you have? (example: Intel Core i5 13600K)");
      cpuType = keyboard.nextLine();       
      System.out.println(" What is the clock speed of your computers graphics card in Megahertz (MHz)");
      gpuClockSpeed = keyboard.nextDouble();
      System.out.println("What is the clock speed of your computers processor in Megahertz (MHz)");
      cpuClockSpeed = keyboard.nextDouble();
      System.out.println("How many cores does your CPU have?");
      cpuCoreNumber = keyboard.nextInt();
      
      //char overclockable = 'x';
      keyboard.nextLine();
      System.out.println("Is the hardware overclock-friendly? type Y or N");
      var overclockable = keyboard.next(); // they want char datatype here. have keyboard input for a char value. can i use stringReference.equalsIgnoreCase() ?
      // how to convert string to char? 
      // cant force lower datatype conversion with (char)keyboard.next()
      // cant just receive one letter with keyboard.charAt(0)
      keyboard.nextLine(); // skipping to nextLine because i dont want any issues from the cursor position in the compiler staying on the same line of .next() Method 
      
      
      //Begin Project 2 input
      var chooseResolution = 0.0;
      var resolutionMultiplier = 0.0;
      var performanceScore = 0.0;
      var monitorResolutionAsString = "";
      var recommendedQuality = "";
      var message = "";
      final double PERFORMANCE_MULTIPLIER = 5.0;
      
      //proccessing
      System.out.println("Enter the line number of your monitors resolution. \n1. 1280 x 720 \n2. 1920 x 1080 \n3. 2560 x 1440 \n4. 3840 x 2160");
      chooseResolution = keyboard.nextDouble();
      if(chooseResolution == 1) {
         resolutionMultiplier = 1;
         monitorResolutionAsString = "1280 x 720";
         }
      else if(chooseResolution == 2) {
         resolutionMultiplier = .75;
         monitorResolutionAsString = "1920 x 1080";
         }
      else if(chooseResolution == 3) {
         resolutionMultiplier = .55;
         monitorResolutionAsString = "2560 x 1440";
         }
      else if(chooseResolution == 4) {
         resolutionMultiplier = .35;
         monitorResolutionAsString = "3840 x 2160";
         }
      else {
         System.out.println("The resolution you entered is incorrect. Please rerun program.");
         }
      
      performanceScore = ((PERFORMANCE_MULTIPLIER * gpuClockSpeed) + (cpuCoreNumber * cpuClockSpeed)) * resolutionMultiplier;
      
      // switch doesnt work here because it doesnt return boolean expressions. use switch() instead of if-elseif-else when you have alot of cases      
      if(performanceScore > 17000) {
         recommendedQuality = "Ultra";
         }
      else if((performanceScore > 15000) && (performanceScore < 17000)) {
         recommendedQuality = "High";
         }
      else if((performanceScore > 13000) && (performanceScore < 15000)) {
         recommendedQuality = "Medium";
         }
      else if((performanceScore > 11000) && (performanceScore < 13000)) {
         recommendedQuality = "Low";
         }
      else 
         recommendedQuality = "Unable to Play";
      
      //output    
      System.out.println(title + "\nYour Processor type is: " + cpuType);
      System.out.print("\nYour GPU Speed is: " + gpuClockSpeed);
      System.out.print("\nYour CPU speed is: " + cpuClockSpeed);
      System.out.print("\nYour CPU's Core count is: " + cpuCoreNumber);
      System.out.print("\nIs the hardware Overclock-Friendly: " + overclockable);
      System.out.print("\nYour monitors Resolution is:" + monitorResolutionAsString); 
      System.out.printf("\nYour Performance score is: %,.3f", performanceScore);
      System.out.println("Your recommended Graphics-Quality is: " + recommendedQuality);
      // i messed this up alot. ternary operator expects a assignable value. equalsIgnoreCase() Method must be called using a String reference. N is string so use quotes.
      // i cannot print from within a ternary operator, instead assign its output to a variable, and afterwards print the variable.   
      message = overclockable.equalsIgnoreCase("N") ? "\nWarning, your cooling system may work harder. Consider upgrading to overclock-friendly components." : "" ;
      System.out.println(message);
      
      }
   
   }
