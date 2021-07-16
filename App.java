import java.util.Scanner;
public class App {
  //scanner
  public static Scanner INPUT = new Scanner (System.in);

  //menus
  static String[]mainMenu = {"Gas Laws Calculator", "Solution Concentration Calculator", "Exit the program"};
  static String[]gasLawsMenu = {"Boyle's Law", "Charle's Law", "Gay Lussac's Law", "Avogadro's Law", "Ideal Gas Equation"};
  static String[]solConMenu = {"Percent by mass", "Percent by volume", "Molarity", "Molality", "Mole fraction", "Normality"};

  //variable declaration
  static int optionForm; 
  static int option;
  static double result;
  static boolean sent = true;
  static String unit;
  static String inputInst = "Choose the value you want to obtain: ";

  //arrays for variables and values of gas laws 
  static String[]boyleVar = {"Initial Pressure", "Initial Volume", "Final Pressure", "Final Volume"};
  static double[]boyleValues = {0, 0, 0, 0};
  static String[]boyleUnits = {"kpa", "L", "kpa", "L"};

  static String[]charlesVar = {"Initial Volume", "Initial Temperature", "Final Volume","Final Temperature"};
  static double[]charlesValues = {0,0,0,0};
  static String[]charlesUnits = {"L", "K", "L", "K"};

  static String[]gaylussacVar = {"Initial Pressure", "Initial Temperature", "Final Pressure", "Final Temperature"};
  static double[]gaylussacValues = {0,0,0,0};
  static String[]gaylussacUnits = {"kpa", "K", "kpa", "K"};

  static String[]avogadroVar = {"Initial Volume", "Initial number of moles", "Final Volume", "Final number of moles"};
  static double[]avogadroValues = {0,0,0,0};
  static String[]avogadroUnits = {"L", "moles", "L", "moles"};

  static String[]idealgasVar = {"Pressure", "Volume", "Number of moles", "Temperature"}; 
  static double[]idealgasValues = {0,0,0,0};
  static String[]idealgasUnits = {"kpa", "L", "moles", "K"};

  // arrays for variables and values of solution concentration forms
  static String[]percbymassVar = {"Mass of solute", "Mass of solution", "Percent by mass"};
  static double[]percbymassValues = {0,0,0};
  static String[]percbymassUnits = {"gr", "gr", "%"};

  static String []percbyvolVar = {"Volume of solute", "Volume of solution", "Percent by volume"};
  static double[]percbyvolValues = {0,0,0,0};
  static String[]percbyvolUnits = {"ml", "ml", "%"};

  static String []molarityVar = {"Moles of solute", "Volume of solution",  "Molarity"};
  static double[]molarityValues = {0,0,0};
  static String[]molarityUnits = {"moles", "L", "M"};

  static String []molalityVar = {"Moles of solute", "Mass of solution",  "Molality"};
  static double[]molalityValues = {0,0,0};
  static String[]molalityUnits = {"moles", "kg", "M"};

  static String[]molefractionVar = {"Moles of solute", "Moles of solution",  "Molar fraction"};
  static double[]molefractionValues = {0,0,0};
  static String[]molefractionUnits = {"moles", "moles", "M"};

  static String[]normalityVar = {"Initial Normality", "Initial Volume", "Final Normality", "Final Volume"};
  static double[]normalityValues = {0,0,0,0};
  static String[]normalityUnits = {"N", "L", "N", "L"};

  //functions
  public static void displayMenu(String[] menu, String title) {
    System.out.println(title);
    for (int i = 0; i < menu.length; i++){
      System.out.println((i + 1) + ". " + menu[i]);
    }
    System.out.print("Select one option: ");
    if (menu == gasLawsMenu || menu == solConMenu) {
      optionForm = INPUT.nextInt();
    } else {
      option = INPUT.nextInt();
    }
    System.out.println(" ");
  }

  public static void getInputs(String[]formulaVars, double[]formulaValues, String[]formulaUnits){
    System.out.print("Enter the values. ");
    System.out.println("(Enter 0 in the value you want to obtain): ");
    for (int i = 0; i < formulaVars.length; i++) {
      System.out.print(formulaVars[i] + " [" + formulaUnits[i] + "] = ");
      formulaValues[i] = INPUT.nextDouble();
    }
  }

  public static double calcGasLaws(double[] formulaValues) {
    if (optionForm == 1) { 
      //despejes de Boyle's Law
      switch (option) {
        case 1: // P1
          result = (formulaValues[2]*formulaValues[3])/formulaValues[1];
          unit = "kpa";
          break;
        case 2: //V1
          result = (formulaValues[2]*formulaValues[3])/formulaValues[0];
          unit = "L";
          break;
        case 3: //P2
          result = (formulaValues[0]*formulaValues[1])/formulaValues[3];
          unit = "kpa";
          break;
        case 4: //V2
          result = (formulaValues[0]*formulaValues[1])/formulaValues[2];
          unit = "L";
          break;
        default:
          System.out.println("Invalid option");
          break;
      }
    } else if (optionForm >= 2 && optionForm <= 4) { 
      //despejes de Charle's, Gay Lussac's y Avogadro's Laws
      switch (option) { 
        case 1: //[0]
          result = (formulaValues[2]*formulaValues[1])/formulaValues[3];
          if (optionForm == 2 || optionForm == 4) {
            unit = "L";
          } else {
            unit = "kpa";
          }
          break;
        case 2: //[1]
          result = (formulaValues[3]*formulaValues[0])/formulaValues[2];
          if (optionForm == 2 || optionForm == 3) {
            unit = "K";
          } else {
            unit = "moles";
          }
          break;
        case 3: //[2]
          result = (formulaValues[3]*formulaValues[0])/formulaValues[1];
          if (optionForm == 2 || optionForm == 4) {
            unit = "L";
          } else {
            unit = "kpa";
          }           
          break;
        case 4: //[3]
          result = (formulaValues[2]*formulaValues[1])/formulaValues[0];
          if (optionForm == 2 || optionForm == 3) {
            unit = "K";
          } else {
            unit = "moles";
          }
          break;
        default:
          System.out.println("Invalid option");
          break;
      }
    } else if (optionForm == 5) { 
      //despejes de ideal gas equation
      double R = 8.31;
      switch (option) {
        case 1: //P
          result = (formulaValues[2]*R*formulaValues[3])/formulaValues[1];
          unit = "kpa";
          break;
        case 2: //V
          result = (formulaValues[2]*R*formulaValues[3])/formulaValues[0];
          unit = "L";
          break;
        case 3: //n
          result = (formulaValues[0]*formulaValues[1])/(R*formulaValues[3]);
          unit = "moles";
          break;
        case 4: //T
          result = (formulaValues[0]*formulaValues[1])/(formulaValues[2]*R);
          unit = "K";
          break;
        default:
          System.out.println("Invalid option");
          break;
        }
      }
      return result;   
    }

  public static double calcSolCon(double[] formulaValues) {
    if (optionForm == 6) {
      switch(option) {
        //Normality
          case 1: //N1
          result = (formulaValues[2]*formulaValues[3])/formulaValues[1];
          unit="N";
        break;
        case 2: //V1
          result= (formulaValues[2]*formulaValues[3])/formulaValues[0];
          unit = "L";
          break;
        case 3 : //N2
          result = (formulaValues[0]*formulaValues[1])/formulaValues[3];
          unit= "N";
          break; 
        case 4: //V2
          result = (formulaValues[0]*formulaValues[1])/formulaValues[2];
          unit= "L";
          break;
        default: 
          System.out.println("Invalid option");
          break;
      }
    } else if (optionForm >= 1 && optionForm <= 5) {
      switch(option) {
        case 1: //[0]
          result = (formulaValues[2]*formulaValues[1]);
          if (optionForm >= 3 && optionForm <= 5) { //molarity, molality or molar fraction
            unit = "moles";
          } else if (optionForm == 1) { //% mass
            result /= 100;
            unit = "gr";
          } else if (optionForm == 2) { //% volume
            result /= 100;
            unit = "ml";
          }
          break;
        case 2: //[1]
          result = (formulaValues[0]/formulaValues[2]);
          switch(optionForm) {
            case 1: //% mass
              result *= 100;
              unit = "gr";
              break;
            case 2: //% V
              result *= 100;
              unit = "ml";
              break;
            case 3: //molarity
              unit = "L";
              break;
            case 4: //molality
              unit = "kg";
              break;
            case 5: //molar fraction
              unit = "moles";
              break;
          }
          break;
        case 3: //[2]
          result = (formulaValues[0]/formulaValues[1]);
          if (optionForm == 1 || optionForm == 2){ // percent mass or volume
            unit = "%";
            result *= 100;
          } else if (optionForm >=3 && optionForm <=5){ //Molarity, Molality and Molar fraction
            unit = "M";
          }
          break;
        default: 
          System.out.println("Invalid option");
          break;
      }
    } else {
      System.out.print("Invalid option");
    }
    return result;
  }

  public static void displayResult(String[] formulaVars, double[] formulaValues) {
    System.out.println(" ");
    System.out.println("The result is: " + formulaVars[option - 1] + " = " + result + " [" + unit + "]");
    System.out.println(" ");
  }

  public static void runFunctions(String[] formulaVars, double[] formulaValues, String[] formulaUnits, String glORsc) {
    displayMenu(formulaVars, inputInst);
    if (option <= formulaVars.length) {
      getInputs(formulaVars, formulaValues, formulaUnits);
      if (glORsc == "gasLaws") {
      calcGasLaws(formulaValues);
      } else if (glORsc == "solCon") {
      calcSolCon(formulaValues);
      }
      displayResult(formulaVars, formulaValues);
    } else {
      System.out.println("Invalid option");
    }
  }

  public static void main(String[] args) throws Exception {
    System.out.println("Welcome to the gas laws & solution concentration calculator.");
    do {
      displayMenu(mainMenu, "***MAIN MENU***");
      if (option == 1) { //gas laws
        displayMenu(gasLawsMenu, "***Gas Laws Menu***");
        switch (optionForm) {
          case 1: //Boyle's Law
            runFunctions(boyleVar, boyleValues, boyleUnits, "gasLaws");
            break;
          case 2: //Charle's law
            runFunctions(charlesVar, charlesValues, charlesUnits, "gasLaws");              
            break;
          case 3: //Gay Lussac's Law
            runFunctions(gaylussacVar, gaylussacValues, gaylussacUnits, "gasLaws");    
            break;
          case 4: //Avogadro's Law
            runFunctions(avogadroVar, avogadroValues, avogadroUnits, "gasLaws");    
            break;
          case 5: //Ideal gas equation
            runFunctions(idealgasVar, idealgasValues, idealgasUnits, "gasLaws");
            break;
          default:
            System.out.println("Invalid option");
            break;
        }    
      } else if (option == 2) {
        displayMenu(solConMenu, "***Solution Concentration Menu***");
        switch (optionForm) {
          case 1: //Percent by mass
            runFunctions(percbymassVar, percbymassValues, percbymassUnits, "solCon");
            break;
          case 2: //Percent by volume
            runFunctions(percbyvolVar, percbyvolValues, percbyvolUnits, "solCon");
            break;
          case 3: //Molarity
            runFunctions(molarityVar, molarityValues, molarityUnits, "solCon");
            break;
          case 4: //Molality
            runFunctions(molalityVar, molalityValues, molalityUnits, "solCon");
            break;
          case 5: //Mole fraction
            runFunctions(molefractionVar, molefractionValues, molefractionUnits, "solCon");
            break;
          case 6: //Normality
            runFunctions(normalityVar, normalityValues, normalityUnits, "solCon");
            break;
          default: 
            System.out.println("Invalid option");
            break;
        }
      } else if (option == 3) { //Exit the program
        sent = false;
        System.out.println("Goodbye!");
      } else {
        System.out.println("Invalid Option");
      }
    } while (sent);
  }      
}
