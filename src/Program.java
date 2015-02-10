import java.util.*;

public class Program {

	static Scanner console = new Scanner(System.in);
	// Marcus Libutan
	// AP Computer Science
	// Project 2 - TextExcel
	// Extra credit so far:
//	     * none so far :(
	
	public static void main(String[] args) {
		
		Spreadsheet sheet = new Spreadsheet();
		boolean start = true;
		String inputString = "";

		while (start == true) {
			System.out.println("Command/> ");
			inputString = console.next();

			if (inputString.equals("exit")) {
				start = false;
				System.out.println("Farewell! See you in the next milestone ^_^");
			} else if (inputString.equalsIgnoreCase("print")) {
				System.out.println();
				System.out.println(sheet.printSheet());
			} else if (inputString.equalsIgnoreCase("print") || (inputString.equals("exit");
				System.out.println("This is a test case. This may or may not work");
			
		}

		console.close();
	}

}
