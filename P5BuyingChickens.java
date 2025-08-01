/* Zhaire Robinson
* COP-2800-98672* P5 Buying Chickens at Chiki's Stop Chicken Shop
* 04/10/2025
*
* Some AI was used in this project for a better understanding of loop control and static method structure. The rest of the code was created using information from the textbook, lecture videos and modeled after previous programs I have completed in this course (P2 - P4). 
  The purpose of this program is to simulate a customer buying chickens at a virtual chicken store, while evaluating their egg-laying potential. There was a focus on Method calls and If statements to properly execute this program, building on to my skills from P2 - P4.
*/

// Import scanner for user input //

import java.util.Scanner;

// Define main class //
public class P5BuyingChickens {
  
  // Define main method and create scanner object //
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // the method that will print the welcome messge to the user // 
    printWelcomeMessage();

    // create a variable for buying more chickens loop //
    boolean moreChickens = true;
    
    // Add a while loop to prompt user an option to buy more chickens //
    while (moreChickens) {
      // Call method for getting the chicken type entered by the user, then store result in chickenType //
      int chickenType = getChickenType();

      // Call method for getting the health status entered by the user, then store result in healthStatus //
      int healthStatus = getHealthStatus();

      // Call method to calculate eggs per year based on chicken type & health //
      float yearlyEggs = calculateEggsPerYear(chickenType, healthStatus);

      // Call method to get a message based on egg production //
      String valueMessage = getValueMessage(yearlyEggs);

      // Print out the results for the user //
      System.out.println("\n~ Chicken Report ~");
      System.out.println("Estimated eggs per year: " + yearlyEggs);
      System.out.println("Value of Chicken: " + valueMessage);

      // Ask the user if they want to buy more chickens //
      System.out.println("\nWould you like to buy more chickens? Please answer yes or no: ");
      // Read and convert user input into lowercase //
      String choice = input.next().toLowerCase();

      // If user respond no, end shopping by setting loop condition to false //
      if (!choice.equals("yes")) {
        moreChickens = false; 
        // print out good bye message //
        System.out.println(" Thanks for shopping with us! See you later ^_^");
      }


    }
        // Close out the scanner //
        input.close();
  }
  

  // All five methods and return values printed out to the user //

  // Method 1: Static method with void return type & no parameters. Prints out a welcome message //
  public static void printWelcomeMessage() {
    System.out.println(" \nWelcome to Chiki's Stop, Chicken Shop!");
    System.out.println("Where you can find the best quality chickens for your farm :)\n");
  }

  // Method 2: Static method with int return type & no parameters. Asks the user what type of chcken they want to buy. //
public static int getChickenType() {
  
  // Create scanner for user input //
  Scanner input = new Scanner(System.in);

  // Ask user what chickens they want to buy: prompt user for options 1-3 //
  System.out.println("What type of chicken would you like to purchase today?");
  System.out.println("1: Rhode Island Red");
  System.out.println("2: Americana");
  System.out.println("3: Longhorn");
  System.out.println(" \nPlease enter your choice (1-3): ");
  // Return user's choice //
  return input.nextInt();
}

// Method 3: Static method with int return type & no parameters. Asks the user for health status of chicken //
public static int getHealthStatus(){
  Scanner input = new Scanner(System.in);
  System.out.println("What is the health status of your chicken?");
  System.out.println("0: Healthy");
  System.out.println("1: Under Weight");
  System.out.println("2: Over Weight");
  System.out.println("3: Droopy Comb");
  System.out.println(" \nPlease enter a choice (0-3): ");
  // Return user's choice //
  return input.nextInt();
}

// Method 4: Static method that returns a float value & has two parameters of type int. Calculates # of eggs per year based on chicken and health //
public static float calculateEggsPerYear(int chickenType, int healthCode) {
  // Variable holding eggs layed per week //
  int productionChart = 0;
  // Variable holding health factor //
  float healthValue = 1.0f;

  // Set egg production value based on chicken type //
  if (chickenType == 1){
    productionChart = 7; // Rhode islands Chickens //
  } else if (chickenType == 2){
    productionChart = 5; // Americana Chickens //
  } else if (chickenType == 3){
    productionChart = 6; // Longhorn Chickens //
  }

  // Set health value based on health status //
  if (healthCode == 0) {
    healthValue = 1.0f;      // Healthy Chickens are full value //
} else if (healthCode == 1) {
    healthValue = 0.7f;      // Under Weight Chickens are reduced value //
} else if (healthCode == 2) {
    healthValue = 0.9f;      // Over Weight Chickens are slightly reduced //
} else if (healthCode == 3) {
    healthValue = 0.5f;      // Droopy comb Chickens are low value //
}

// Return value of eggs per year usinf formula: productionChart * healthValue * 52 weeks //
  return productionChart * healthValue * 52;
}

// Method 5: Static method that returns a String value & has 1 float parameter. Takes the egg count and returns the value of the chicken //
public static String getValueMessage(float eggsPerYear) {
  if (eggsPerYear > 300) {
    return "This is Great Value!!"; // over 300 eggs are great value //
  } else if (eggsPerYear > 200) {
    return "Good Value is Fine Too"; // over 200 eggs but not equal to 300 eggs is good value //
  } else {
    return "Oh Boy >_> That's Consider Fried Chicken!"; // less than 200 is not good value //
  }
}
}