import java.util.*;

public class Program {

	static Scanner console = new Scanner(System.in);

	// Marcus Libutan
	// AP Computer Science
	// Project 2 - TextExcel
	// Extra credit so far:
	// * none so far :

	public static void main(String[] args) { // handles user input
		System.out.println("Welcome to TextExcel!");
		boolean start = true;
		Spreadsheet sheet = new Spreadsheet();
		String inputString = "";

		while (start == true) {
			System.out.println("Command/> ");
			inputString = console.nextLine();

			if (inputString.equals("exit")) {
				start = false;
				System.out.println("Farewell! See you in the next milestone ^_^");
			} else if (inputString.equalsIgnoreCase("print")) {
				System.out.println();
				System.out.println(sheet.printSheet());
			} else if (inputString.indexOf('=') != -1) {
				if (inputString.toLowerCase().contains("null")) {
					System.out.println("<ERROR: NO CELL " + inputString.substring(0, inputString.indexOf('=') - 1) + ">");
				} else {
					String cellPos = inputString.substring(0, inputString.indexOf('=') - 1);
					inputString = inputString.substring(inputString.indexOf("=") + 2, inputString.length());
					sheet.setValueAt(cellPos, inputString);
				}
			} else {
				System.out.println();
				if (inputString.toLowerCase().equalsIgnoreCase("null")) {
					System.out.println("<ERROR: NO CELL " + inputString + ">");
				} else if (!sheet.getValueAt(inputString).contains("ERROR")) {
					System.out.println(inputString + " = " + sheet.getValueAt(inputString));
				} else {
					System.out.println(sheet.getValueAt(inputString));
				}
				System.out.println();
			}
		}
	}
}
