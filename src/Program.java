import java.util.Scanner;

public class Program {
	// Marcus Libutan
	// AP Computer Science
	// Project 2 - TextExcel
	// Extra credit so far:
	// * none
	static Scanner console = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Welcome to TextExcel!");
		System.out.print("textexcel@command:~$ ");
		String inputString = console.nextLine();
		while (!inputString.equals("exit")) {
			System.out.print("textexcel@command:~$ ");
			inputString = console.nextLine();
		}
	}
}