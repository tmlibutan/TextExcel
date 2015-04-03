import java.util.*;

public class FormulaCell extends Cell {
	public FormulaCell(String full, String small, String label) {
		ArrayList<String> tokens = new ArrayList<String>();
		double value = 0;
		while (small.indexOf(' ') != -1) {
			tokens.add(small.substring(0, small.indexOf(' ')));
			small = small.substring(small.indexOf(' ') + 1);
		}
		tokens.add(small);
		try {
			value = Double.parseDouble(tokens.get(0));
			tokens.remove(0);
		} catch (Exception e) {
			System.out.println("Invalid Format");
		}
		while (tokens.size() > 0) {
			if (tokens.get(0).equals("+")) {
				try {
					tokens.remove(0);
					value += Double.parseDouble(tokens.get(0));
					tokens.remove(0);
				} catch (Exception e) {
					System.out.println("Invalid Format");
				}
			} else if (tokens.get(0).equals("-")) {
				try {
					tokens.remove(0);
					value -= Double.parseDouble(tokens.get(0));
					tokens.remove(0);
				} catch (Exception e) {
					System.out.println("Invalid Format");
				}
			} else if (tokens.get(0).equals("*") || tokens.get(0).equals("x")) {
				try {
					tokens.remove(0);
					value *= Double.parseDouble(tokens.get(0));
					tokens.remove(0);
				} catch (Exception e) {
					System.out.println("Invalid Format");
				}
			} else if (tokens.get(0).equals("/")) {
				try {
					tokens.remove(0);
					value /= Double.parseDouble(tokens.get(0));
					tokens.remove(0);
				} catch (Exception e) {
					System.out.println("Invalid Format");
				}
			}
		}
		super.setValue(full, value + "");
		setPosition(label);
	}
}
