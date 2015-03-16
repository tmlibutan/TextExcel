import java.util.*;

public class Program {

	static Scanner console = new Scanner(System.in);
	 // Marcus Libutan
	 // AP Computer Science Project 2 - TextExcel
	 // Extra credit
	// Extra credit so far:
	// * none so far
	public static void main(String[] args) { // User input
		System.out.println("Welcome to TextExcel!");
		boolean start = true;
		Spreadsheet sheet = new Spreadsheet();
		String inputString = "";
		/**
		 * Below this, the program will get input and determine if the program
		 * is started or terminated. This also handles the clear, exit, and
		 * print commands.
		 */
		while (start == true) {
			/**
			 * while 'start' is true, the program stays running. Once exit is
			 * entered this will end/terminate the program
			 */
			System.out.println("Command/> ");
			inputString = console.nextLine();

			if (inputString.equals("clear")) {
				Spreadsheet clear = new Spreadsheet();
				sheet = clear;
				/**
				 * New Spreadsheet "clear" is created completely making a new
				 * spreadsheet.
				 */
			} else if (inputString.equals("exit")) {
				start = false;
				/**
				 * boolean start changes from true to false. This will terminate
				 * the program rather than using System.exit(0);
				 */
				System.out.println("Farewell! See you in the next milestone ^_^");
			} else if (inputString.equalsIgnoreCase("print")) {
				System.out.println();
				System.out.println(sheet.printSheet());
				/**
				 * print will call to the spreadsheet class and create a new
				 * spreadsheet according to the values of printsheet()
				 */
			} else if (inputString.indexOf('=') != -1) {
				if (inputString.toLowerCase().contains("null")) {
					/**
					 * Handles errors :?
					 */
					System.out.println("Error_NoCell/>" + inputString.substring(0, inputString.indexOf('=') - 1) + ">");
				} else {
					String cellPos = inputString.substring(0, inputString.indexOf('=') - 1);
					inputString = inputString.substring(inputString.indexOf("=") + 2, inputString.length());
					sheet.setValueAt(cellPos, inputString);
				}
			}
		}
	}
}
