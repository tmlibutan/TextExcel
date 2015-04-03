import java.util.*;

import persistence.*;

public class Program {

	static Scanner console = new Scanner(System.in);

	// Marcus Libutan
	// AP Computer Science
	// Project 2 - TextExcel
	// Extra credit so far:
	// * none so far

	public static void main(String[] args) { // User inputString
		System.out.println("Welcome to TextExcel!");
		boolean start = true;
		Spreadsheet sheet = new Spreadsheet();
		String inputString = "";
		/**
		 * Below this, the program will get input and determine if the program
		 * is started or terminated. This also handles the clear, exit, and
		 * print commands.
		 */
		while (start == true) { // Loops command until "exit"
			/**
			 * while 'start' is true, the program stays running. Once exit is
			 * entered this will end/terminate the program
			 */
			System.out.println("Command/> ");
			inputString = console.nextLine();

			if (inputString.equals("clear")) {
				/**
				 * New Spreadsheet "clear" is created completely making a new
				 * spreadsheet.
				 */
				Spreadsheet clear = new Spreadsheet();
				sheet = clear;
			} else if (inputString.equals("exit")) {
				/**
				 * boolean start changes from true to false. This will terminate
				 * the program rather than using System.exit(0);
				 */
				start = false;
				System.out.println("Farewell! See you in the next milestone ^_^");
			} else if (inputString.equalsIgnoreCase("print")) {
				/**
				 * print will call to the spreadsheet class and create a new
				 * spreadsheet according to the values of printsheet()
				 */
				System.out.println();
				System.out.println(sheet.printSheet());
			} else if (inputString.contains("=")) {
				/**
				 * Handles errors :?
				 */

				if (inputString.toLowerCase().contains("null")) {
					System.out.println("Error:/>" + inputString.substring(0, inputString.indexOf('=') - 1) + ">");
				} else {
					String cellPos = inputString.substring(0, inputString.indexOf('=') - 1);
					inputString = inputString.substring(inputString.indexOf("=") + 2, inputString.length());
					sheet.setValueAt(cellPos.toUpperCase(), inputString);
				}
			} else if (inputString.length() > 5 && inputString.substring(0, 4).equals("save")) {
				try {
					PersistenceHelper.save(inputString.substring(inputString.indexOf(' ') + 1), sheet);
				} catch (Exception e) {
					System.out.println("Can't save ):");
				}
			} else if (inputString.length() > 5 && inputString.substring(0, 4).equals("load")) {
				try {
					PersistenceHelper.load(inputString.substring(inputString.indexOf(' ') + 1), sheet);
				} catch (Exception e) {
					System.out.println("Unable to load from path \'"
							+ inputString.substring(inputString.indexOf(' ') + 1) + "\'.  Error: "
							+ inputString.substring(inputString.indexOf(' ') + 1)
							+ "(The system cannot find the file specified)");
				}
			} else if (inputString.toLowerCase().contains("clear") && inputString.length() == 5) {
				sheet = new Spreadsheet();
			} else if (inputString.toLowerCase().contains("clear")) {
				sheet.clearCellAt(inputString.substring(inputString.indexOf(' ') + 1).toUpperCase());
			} else {
				System.out.println(sheet.getValueAt(inputString.toUpperCase()));
			}
		}
	}
}
