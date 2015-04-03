public class StringCell extends Cell {
	public StringCell(String fullStr, String str, String label) {
		String fullVal = fullStr;

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
		super.setValue(fullVal, shortVal);
		setPosition(label);
	}
}
