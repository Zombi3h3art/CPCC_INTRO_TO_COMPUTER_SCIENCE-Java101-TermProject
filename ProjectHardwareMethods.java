/** This class does noot have a main() because it instead has several methods.
This file can be used for its object or methods in the other graphics recomendation tool program.
 - Clark Miller
*/
//it wants me to create a instance of the name something uhh i dont understand the instructions. what am i supposed to change about project 4? 
//can i not just make a copy? you tell me to name the same program different names and then change the name of the other, but somehow there should be three files? 
//whats the third file? What is a instance? We were taught the filename must match the class name, now we're told not to have them match, why??
public class HardwareMiller {
//recommended to make all fields with private accessModifier, & all methods public.
   private String processor = "";
   private double gpuClockSpeed = 0.0;
   private double cpuClockSpeed = 0.0;
   private int cpuCoreNumber = 0;
   private int monitorResolution = 0;
   private char overclock = 'z';
   private double multiplier = 0.0;
   private double performanceScore = 0.0;
   private String monitorResolutionAsString = "";
   private String recommendedQuality = "";

   //constructors do what? methods()?
   //the default constructor is created automatically, so i dont need to write HardwareMiller() without parameters?
   public HardwareMiller() {
   }
  
   public HardwareMiller(String pType, double gpu, double cpu, int cores, int resolution, char overC) {
      processor = pType;
      gpuClockSpeed = gpu;
      cpuClockSpeed = cpu;
      cpuCoreNumber = cores;
      monitorResolution = resolution;
      overclock = overC;
   }
   
   //getters and setters are what? methods()? yea they are the accessor and mutator methods.
   //  where accessor methods GET the value from classes field but doesnt change it.
   //Mutator method will store, or SET, a value in a field or change the value somehow.
   //i guess each set_thing() and each individual get_thing() is its own method() that i should write.
   //setters
   public void setProcessor(String pType) {
      processor = pType;
   }
   
   public void setGpuClockSpeed(double gpu) {
      gpuClockSpeed = gpu;
   }
   
   public void setCpuClockSpeed(double cpu) {
      cpuClockSpeed = cpu;
   }
   
   public void setCpuCoreNumber(int cores) {
      cpuCoreNumber = cores;
   }
   
   public void setMonitorResolution(int resolution) {
      monitorResolution = resolution;
   }
   
   public void setOverclock(char overC) {
      overclock = overC;
   }
   
   //getters
   public String getProcessor() {
      return processor;
   }
   //transform monitorResolution to string and return
   public String getResolutionString() {
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
         monitorResolutionAsString = monitorResolutionAsString;
      return monitorResolutionAsString;
   }
   
   public double getMultiplierValue() {
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
      //multiply = multiplier;
      return multiplier;
   }
   
   public double calculatePerformanceScore() {
      final int ATTRIBUTE = 6;
      performanceScore = ATTRIBUTE * gpuClockSpeed + (cpuCoreNumber * cpuClockSpeed) * multiplier;
      return performanceScore;
   }
   
   public String getRecommendedQuality() {
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
         recommendedQuality = recommendedQuality;
      return recommendedQuality;
   }
   
   public char getOverclockChoice() {
      return overclock;
   }
   
   public void displayInformation() {
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


} // end class