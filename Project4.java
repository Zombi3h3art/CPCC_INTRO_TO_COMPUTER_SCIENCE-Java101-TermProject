/** You have been hired as a Junior Level Developer. 
Your first assignment is to code a program using an IPO chart that has been created by a team of software developers. 
The team has updated Project 3 by adding methods. */

import java.io.IOException;
import java.util.Scanner;

public class Project4 {
   public static void main(String[] args) throws IOException {
      String processor;
      String repeatString = "";
      String monitorResolutionAsString;
      String recommendedQuality;
      String overclockString = "";      
      int cpuCoreNumber;
      int monitorResolution = 0;
      int computerNum = 0;
      char overclock;
      char repeat = 'y';
      double average;
      double gpuClockSpeed;
      double cpuClockSpeed;
      double multiplier;
      double performanceScore;
      double totalPerformanceScore = 0.0;
      final double CLOCK_SPEED_GPU_LOW_THRESHOLD = 800;  
      final double CLOCK_SPEED_GPU_HI_THRESHOLD = 2000;
      final double CLOCK_SPEED_CPU_LOW_THRESHOLD = 1000;  
      final double CLOCK_SPEED_CPU_HI_THRESHOLD = 5500;
      final int CORES_LOW_THRESHOLD = 1;
      final int CORES_HI_THRESHOLD = 20;
      Scanner keyboard = new Scanner(System.in);
      
      do {
         displayTitle();
         System.out.println("Please enter the type of processor: ");
         processor = keyboard.nextLine(); // is calling the nextLine method() on the Scanner object 'keyboard'
         System.out.println("Please enter the clock speed (in Megahertz) of your graphics card: ");
         gpuClockSpeed = keyboard.nextDouble();
         while(gpuClockSpeed < CLOCK_SPEED_GPU_LOW_THRESHOLD || gpuClockSpeed > CLOCK_SPEED_GPU_HI_THRESHOLD) {
            System.out.println("The clock speed should be between " + CLOCK_SPEED_GPU_LOW_THRESHOLD + " and " + CLOCK_SPEED_GPU_HI_THRESHOLD + " Megahertz");
            System.out.println("Please enter the clock speed (in Megahertz) of your graphics card: ");
            gpuClockSpeed = keyboard.nextDouble();        
         }
         System.out.println("Please enter the clock speed (in Megahertz) of your processor: ");
         cpuClockSpeed = keyboard.nextDouble();
         while (cpuClockSpeed < CLOCK_SPEED_CPU_LOW_THRESHOLD || cpuClockSpeed > CLOCK_SPEED_CPU_HI_THRESHOLD) {
            System.out.println("The clock speed should be between " + CLOCK_SPEED_CPU_LOW_THRESHOLD + " and " + CLOCK_SPEED_CPU_HI_THRESHOLD + " Megahertz");
            System.out.println("Please enter the clock speed (in Megahertz) of your processor: ");
            cpuClockSpeed = keyboard.nextDouble();
         }
         System.out.println("Please enter the number of cores for your processor: ");
         cpuCoreNumber = keyboard.nextInt();
         while (cpuCoreNumber < CORES_LOW_THRESHOLD || cpuCoreNumber > CORES_HI_THRESHOLD) {
         System.out.println("The number of cores should be between " + CORES_LOW_THRESHOLD + " and " + CORES_HI_THRESHOLD + " MHz");
         System.out.println("Please enter the number of cores of your processor: ");
         cpuCoreNumber = keyboard.nextInt();
         }
         System.out.println("Is the hardware overclock-friendly? (Enter y for yes or n for no): ");
         overclockString = keyboard.nextLine();// nextChar a thing?
         overclock = overclockString.charAt(0); // do i use ignoreCase like this?
         while (overclock  != 'y'  && overclock  != 'n') {
            System.out.println("Error: the response should be y for yes or n for no");
            System.out.println("Is the hardware overclock-friendly? (Enter y for yes or n for no): ");
            overclockString = keyboard.nextLine();// nextChar a thing?
            overclock = overclockString.charAt(0);
            if (overclock == overclock.equalsIgnoreCase('y'))
               overclock = 'y';
            else if (overclock == overclock.equalsIgnoreCase('n'))
               overclock = 'n';
            else {}
            
         }
         monitorResolution = getMenuChoice();
         multiplier = getMultiplierValue(monitorResolution);
         monitorResolutionAsString = getResolutionString(monitorResolution);
         performanceScore = calculatePerformanceScore(gpuClockSpeed, cpuClockSpeed, cpuCoreNumber, multiplier);
         recommendedQuality = getRecommendedQuality(performanceScore);
         displayInformation(processor, monitorResolutionAsString, gpuClockSpeed, cpuClockSpeed, cpuCoreNumber, performanceScore, recommendedQuality, overclock);
         System.out.println("Would you like to check another recommendation? Enter y for yes or n for no");
         repeatString = keyboard.nextLine();
         repeat = repeatString.charAt(0);
         while(repeat  != 'y'  && repeat  != 'n') {
            if(repeat == repeat.equalsIgnoreCase('y'))
               repeat = 'y';
            else if(repeat == repeat.equalsIgnoreCase('n'))
               repeat = 'n';
            else{}
         }
         while (repeat != 'y' || repeat != 'n') {  // this work?
            System.out.println("Error, incorrect value entered. Would you like to check another recommendation? Enter y for yes or n for no");
            repeat = keyboard.nextLine();
         }
         computerNum++;
         totalPerformanceScore += performanceScore;
      }      
      while (repeat == repeat.equalsIgnoreCase('y'));   
      average = totalPerformanceScore / computerNum;
      System.out.println("The average of your performance score is: " + average);  
   }
   
   /** This method displays the program title */
   public static void displayTitle() {
      String title = "Graphics Quality Recommendation Tool";
      System.out.println(title);
   }
   
   /** This method displays the Information of the system and overclock warning if appropriate.
   @param processor the CPU type of the system
   @param monitorResolutionAsString the pixel size of screen
   @param gpuClockSpeed the measurement of how fast a gpu's cores can process data
   @param cpuClockSpeed measures how fast the CPU cores process data
   @param cpuCoreNumber this is how many cores/proccessors are avaliable on the systems cpu
   @param performanceScore This is our score of your systems specifications
   @param recommendedQuality This is the graphics quality we recommend for your system
   @param overclock user input of if their system is overclockable*/
   public static void displayInformation(String processor, String monitorResolutionAsString, double gpuClockSpeed, double cpuClockSpeed, int cpuCoreNumber, double performanceScore, String recommendedQuality, char overclock) {
      System.out.println("Processor: " + processor);
      System.out.println("Monitor Resolution: " + monitorResolutionAsString);
      System.out.println("GPU Clock Speed: " + gpuClockSpeed + "MHz");
      System.out.println("CPU Clock Speed: " + cpuClockSpeed + "MHz");
      System.out.println("Number of Cores: " + cpuCoreNumber + "MHz");
      System.out.println("Performance Score: " + performanceScore);
      System.out.println("Recommended Graphics Quality: " + recommendedQuality);
      if(overclock == 'n')
         System.out.println("Warning, your cooling system may work harder. Consider upgrading to overclock-friendly components.");      
   }
   
   /** getMenuChoice method() validates & holds the user input selection of their display size 
   @return monitorResolution This hold the user input */
   //do i need to import Scanner here?
   public static int getMenuChoice() throws IOException {
      var keyboard = new Scanner(System.in);
      int monitorResolution;
      System.out.println("Whats the resolution of your monitor?");
      System.out.println("Display: 1. 1280 x 720");
      System.out.println("Display: 2. 1920 x 1080");
      System.out.println("Display: 3. 2560 x 2160");
      System.out.println("Display: 4. 3840 x 2160");
      System.out.println("Please select from the options above (1, 2, 3, or 4): ");
      monitorResolution = keyboard.nextInt();
      while (monitorResolution < 1 || monitorResolution > 4) {
         System.out.println("Invalid menu selection. Please select from the options above: ");
         monitorResolution = keyboard.nextInt();
      }
      return monitorResolution;
   }
   
   /** Prepare for performanceScore calculation by assigning percent multiplier to monitor.
   @param monitorResolution allows the method() to receive a outside value from previous step
   @return multiplier a variable needed for performanceScore calculation */
   public static double getMultiplierValue(int monitorResolution) {
      final var RESOLUTION_1280_720 = 1;
      final var RESOLUTION_1920_1080 = 2;
      final var RESOLUTION_2560_1440 = 3;
      final var RESOLUTION_3840_2160 = 4;
      final double MULTIPLIER_1280_720 = 1.0;
      final double MULTIPLIER_1920_1080 = .75;
      final double MULTIPLIER_2560_1440 = .55;
      final double MULTIPLIER_3840_2160 = .35;
      double multiplier;
      if (monitorResolution == RESOLUTION_1280_720)
      multiplier = MULTIPLIER_1280_720;
      else if (monitorResolution == RESOLUTION_1920_1080)
      multiplier = MULTIPLIER_1920_1080;
      else if (monitorResolution == RESOLUTION_2560_1440)
      multiplier = MULTIPLIER_2560_1440;
      else
      multiplier = MULTIPLIER_3840_2160;
      return multiplier;
   }
   
   /**  getResolutionAsString method() is converts parameter to string equivalance.
   @param monitorResolution resolution value selected by user
   @return monitorResolutionAsString displays monitor resolution selected by user back to them, only requiring but one key entered by user */
   public static String getResolutionString(int monitorResolution) {
      String monitorResolutionAsString;
      final var RESOLUTION_1280_720 = 1;
      final var RESOLUTION_1920_1080 = 2;
      final var RESOLUTION_2560_1440 = 3;
      final var RESOLUTION_3840_2160 = 4;
      if (monitorResolution == RESOLUTION_1280_720)
         monitorResolutionAsString = "1280 x 720";
      else if (monitorResolution == RESOLUTION_1920_1080)
         monitorResolutionAsString = "1920 x 1080";
      else if (monitorResolution == RESOLUTION_2560_1440)
         monitorResolutionAsString = "2560 x 1440";
      else
         monitorResolutionAsString = "3840 x 2160";
      return monitorResolutionAsString;
   }
   
   /** Calculates the performance score
   @param gpuClockSpeed the measurement of how fast a gpu's cores can process data
   @param cpuClockSpeed measures how fast the CPU cores process data
   @param cpuCoreNumber this is how many cores/proccessors are avaliable on the systems cpu
   @param multiplier a variable needed for performanceScore calculation */
   public static double calculatePerformanceScore(double gpuClockSpeed, double cpuClockSpeed, int cpuCoreNumber, double multiplier) {
      final int ATTRIBUTE = 6;
      return ATTRIBUTE * gpuClockSpeed + (cpuCoreNumber * cpuClockSpeed) * multiplier;
   }
   
   /** Finds the Recommended Quality Settings for your system
   @param performanceScore a score we made earlier to represent the performance of the users system
   @param recommendedQuality holds the recommended quality*/
   public static String getRecommendedQuality(double performanceScore) {
      final double PERFORMANCE_THRESHOLD_HD_PLUS = 17000;
      final double PERFORMANCE_THRESHOLD_HD = 15000;
      final double PERFORMANCE_THRESHOLD_FHD = 13000;
      final double PERFORMANCE_THRESHOLD_WUXGA = 11000;
      String recommendedQuality;
      if(performanceScore > PERFORMANCE_THRESHOLD_HD_PLUS)
            recommendedQuality = "Ultra Extended";
      else if(performanceScore > PERFORMANCE_THRESHOLD_HD)
         recommendedQuality = "Ultra";
      else if(performanceScore > PERFORMANCE_THRESHOLD_FHD)
         recommendedQuality = "Medium";
      else if(performanceScore > PERFORMANCE_THRESHOLD_WUXGA)
         recommendedQuality = "Low";
      else
         recommendedQuality = "Unable to Play";
      return recommendedQuality;
   }
} 