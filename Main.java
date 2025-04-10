// PARTNER NAME: Ana Maria Jose 
// PARTNER NAME:
// CS111 SECTION #:
// DATE: 03/13/2025

public class Main {
	/**
	 * ALGORITHM:
	 * - Add total funds to taco stand
	 * - Order supplies
	 * - Print status of stand (when it opens)
	 * - Print welcome message
	 * - Take customer order
	 * - Print status of stand (when its closed)
	 */
	public static void main(String[] args)
	{
		//DECLARATION + INITIALIZATION SECTION
		TacoStand.initialize();

		//INPUT + CALCULATION + OUTPUT SECTION
		TacoStand.addTotalFunds(20);
		TacoStand.orderSupplies(15);

		System.out.println("OPENING UP THE STAND...");
		System.out.println(TacoStand.getStatus() +"\n\n");

		Main.printWelcome();
		System.out.println("\n");
		
		Main.takeOrder();
		//can call multiple times

		System.out.println("--------CART IS CLOSED---------\n\n" + TacoStand.getStatus());
	}

	/**
	 * Prints a welcome message for the user
	 */
	public static void printWelcome()
	{
		UtilityBelt.printCentered(50, "Welcome to MCC Taco Stand!");
		UtilityBelt.printCentered(50, "┈┈┈┈╭╯╭╯╭╯┈┈┈┈┈");
		UtilityBelt.printCentered(50, "┈┈┈╱▔▔▔▔▔╲▔╲┈┈┈");
		UtilityBelt.printCentered(50, "┈┈╱┈╭╮┈╭╮┈╲╮╲┈┈");
		UtilityBelt.printCentered(50, "┈┈▏┈▂▂▂▂▂┈▕╮▕┈┈");
		UtilityBelt.printCentered(50, "┈┈▏┈╲▂▂▂╱┈▕╮▕┈┈");
		UtilityBelt.printCentered(50, "┈┈╲▂▂▂▂▂▂▂▂╲╱┈┈");
		//ascii art credit:
		//https://mizbizbby.tumblr.com/post/12937794639/happy-taco-ascii-art-for-taco-thursday
	}
	
	/**
	 * Prints the menu, asks the user for the taco option and number of tacos,
	 * updates total funds based on user input and prints an order confirmation
	 */
	public static void takeOrder(){
		//DECLARATION + INITIALIZATION SECTION
		int option, numTacosOrdered;

		//INPUT SECTION
		TacoStand.printMenu();
		option = UtilityBelt.readInt("Enter choice> ", 1, 4);
		numTacosOrdered = UtilityBelt.readInt("Enter number of tacos you want> ", 1, 50);

		//CALCULATION + OUTPUT SECTION
		if (TacoStand.areTacosAvailable(option, numTacosOrdered))
		{
			TacoStand.updateTotalFunds(option, numTacosOrdered);
			Main.printConfirmation(numTacosOrdered);
		}
		else
		{
			System.out.println("We don't have that many tacos, sorry! Try again :(");
		}
	}

	/**
	 * Prints a confirmation message that varies based on the number of tacos in the order
	 * 
	 * @param numTacos
	 */
	public static void printConfirmation(int numTacos) 
	{
    System.out.println("Here you go, buen provecho!");
    int tacosToDisplay = Math.min(numTacos, 20);
    for (int i = 0; i < tacosToDisplay; i++) 
	{
        System.out.print("🌮");
		
    }
	System.out.println(); // New line after printing tacos
	System.out.println(); // I needed another one 
	}
}