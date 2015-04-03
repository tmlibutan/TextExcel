public class Cell {

	String shortValue = "            ";
	String fullValue = "            ";
	String pos;

	public String toShort() {
		return shortValue;
	}

	public String toFull() {
		return fullValue;
	}

	public void setValue(String fullVal) {
		fullValue = fullVal;

		if (fullVal.length() > 12) {
			fullVal = fullVal.substring(0, 11) + ">";
		}

		shortValue = "";
		for (int k = 1; k <= ((12 - fullVal.length()) / 2); k++) {
			shortValue += " ";
		}
		shortValue += fullVal;
		while (shortValue.length() < 12) {
			shortValue += " ";
		}
	}

	public void setValue(String fullVal, String shortVal) {
		fullValue = fullVal;

		if (shortVal.length() > 12) {
			shortVal = shortVal.substring(0, 11) + ">";
		}

		shortValue = "";
		for (int k = 1; k <= ((12 - shortVal.length()) / 2); k++) {
			shortValue += " ";
		}
		shortValue += shortVal;
		while (shortValue.length() < 12) {
			shortValue += " ";
		}
	}

	public void setPosition(String str) {
		pos = str;
	}

	public String getPos() {
		return pos;
	}
}
