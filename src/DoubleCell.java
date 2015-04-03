public class DoubleCell extends Cell {
	public DoubleCell(double num, String label) {
		String str = "" + num;

		if (str.length() > 12) {
			str = str.substring(0, 11) + ">";
		}

		String shortVal = "";
		for (int k = 1; k <= ((12 - str.length()) / 2); k++) {
			shortVal += " ";
		}
		shortVal += str;
		while (shortVal.length() < 12) {
			shortVal += " ";
		}
		super.setValue(str, shortVal);
		setPosition(label);
	}
}
