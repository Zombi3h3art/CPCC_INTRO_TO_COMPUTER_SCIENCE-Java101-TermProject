/** this program is about making a IPO (input process output) for a portion of the code that can be used 
in the completly functioning program that solves a real world problem. 
I'm tasked to create a program to tell a gamer what graphics quality they will be able to run, based on their computer specifications
*/
import java.util.Scanner;
public class Project3
   {
   public static void main(String[] args)
      {
      String title = "Computer Hardware Recomendation Tool";    
      Scanner keyboard = new Scanner(System.in);
      String cpuType;
      double gpuClockSpeed;  
      double cpuClockSpeed;
      int cpuCoreNumber;  
      var chooseResolution = 0.0;
      var resolutionMultiplier = 0.0;
      var performanceScore = 0.000;
      var averagePerformanceScore = 0.000;
      var monitorResolutionAsString = "";
      var recommendedQuality = "";
      var message = "";
      final double PERFORMANCE_MULTIPLIER = 5.0;
      var reTest = "";
      var finalTest = "";
      var reTestCase = "";
      var reTestBoolean = false;
      var overclockable = ""; // they want char datatype here. char overclockable = 'x'; (but its not working). they want the input to ignore case
      var overclockability = "";
      var totalPC = 0;
      var runningTotal = 0.0;
      var nTest = "";
      var yTest = "";
      
      do {  
         ++totalPC; 
         //finalTest == "";
         System.out.println("What type of processor do you have? (example: Intel Core i5 13600K)");
         cpuType = keyboard.nextLine();       
         System.out.println("What is the clock speed of your computers graphics card in Megahertz (MHz). The GPU clock speed should be between 800 and 2000 MHz");
         gpuClockSpeed = keyboard.nextDouble();
         while(gpuClockSpeed < 800 || gpuClockSpeed > 2000) {
            System.out.println("Error. Try again.");
            gpuClockSpeed = keyboard.nextDouble();
            }
         System.out.println("What is the clock speed of your computers processor in Megahertz (MHz). The CPU clock speed should be between 1000 and 5500 MHz.");
         cpuClockSpeed = keyboard.nextDouble();
         while(cpuClockSpeed < 1000 || cpuClockSpeed > 5500) {
            System.out.println("Error. Try again.");
            cpuClockSpeed = keyboard.nextDouble();
            }
         System.out.println("How many cores does your CPU have? The number of cores should be between 1 and 16");
         cpuCoreNumber = keyboard.nextInt();
         while(cpuCoreNumber < 1 || cpuCoreNumber > 16) {
            System.out.println("Error. Try again.");
            cpuCoreNumber = keyboard.nextInt();
            }
         keyboard.nextLine(); //???
         //Validate input. The hardware overclock-friendly status should be only a y or n (ignoring case). 
         while(overclockable == "") {
            if (overclockable == "") {
               System.out.println("Is the hardware overclock-friendly? type Y or N");
               overclockability = keyboard.nextLine();
               nTest = overclockability.equalsIgnoreCase("N") ? "N" : "";
               yTest = overclockability.equalsIgnoreCase("Y") ? "Y" : "";
               
               if(nTest == "N")
                  overclockability = "N";
               else if(yTest == "Y")
                  overclockability = "Y";
               else{}
               
               if(nTest == overclockability || yTest == overclockability) 
                  overclockable = overclockability.equalsIgnoreCase("Y") ? "Y" : "N";
               else 
                  System.out.println("Error. Try again");
               }
            else {}
            }
         nTest = "";
         yTest = "";   
         keyboard.nextLine();//???
         System.out.println("Enter the line number of your monitors resolution. \n1. 1280 x 720 \n2. 1920 x 1080 \n3. 2560 x 1440 \n4. 3840 x 2160");
         System.out.println("The user's input for the menu selection should be between 1 and 4.");
         chooseResolution = keyboard.nextDouble();
         while(chooseResolution < 1 || chooseResolution > 4) {
            System.out.println("Error. Try again.");
            chooseResolution = keyboard.nextDouble();
            }
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
         runningTotal += performanceScore;     
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
         else {} // if score < 11000 theres no recommendedQuality
         System.out.println(title + "\nYour Processor type is: " + cpuType);
         System.out.println("Your GPU Speed is: " + gpuClockSpeed);
         System.out.println("Your CPU speed is: " + cpuClockSpeed);
         System.out.println("Your CPU's Core count is: " + cpuCoreNumber);
         System.out.println("Is the hardware Overclock-Friendly: " + overclockable);
         System.out.println("Your monitors Resolution is: " + monitorResolutionAsString); 
         System.out.printf("Your Performance score is: %,.3f\n", performanceScore);
         System.out.println("Your recommended Graphics-Quality is: " + recommendedQuality);
         message = overclockable.equalsIgnoreCase("N") ? "Warning, your cooling system may work harder. Consider upgrading to overclock-friendly components." : "" ;
         System.out.println(message);  
         keyboard.nextLine();
         while(finalTest == "") {
            if (finalTest == "") {
               System.out.println("Do you desire to test another computers graphic quality specifications? type Y or N");
               reTest = keyboard.nextLine();
               nTest = reTest.equalsIgnoreCase("N") ? "N" : "";
               yTest = reTest.equalsIgnoreCase("Y") ? "Y" : "";
               if(nTest == "N")
                  reTest = "N";
               else if(yTest == "Y")
                  reTest = "Y";
               else {}
               if(nTest == reTest || yTest == reTest) 
                  finalTest = reTest;
               else 
                  System.out.println("Error. Try again");
               }
            }
         nTest = "";
         yTest = "";
         finalTest = "";
         overclockable = "";
         reTestBoolean = reTest == "Y" ? true : false;
         } 
      while (reTestBoolean == !(false)); //while do-while booleanExpression is true, scope executes (scope of do-while includes do{}). when reTestBoolean = false, do-while exits.
      averagePerformanceScore = runningTotal / totalPC;
      System.out.println("\nYour computers average performance score: " + averagePerformanceScore);
      }
   
   }
