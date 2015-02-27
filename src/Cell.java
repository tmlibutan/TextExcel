public class Cell {

	private String shortValue;
	private String fullValue;
	private String pos;

	public Cell() {
		this.shortValue = "            ";
	}

	public String toFull() {
		return this.fullValue;
	}

	public String toShort() {
		return this.shortValue;
	}

	public void setValue(String str) {
		this.fullValue = str;

		if (str.length() > 12) {
			str = str.substring(0, 11) + ">";
		}

		this.shortValue = "";
		for (int k = 1; k <= ((12 - str.length()) / 2); k++) {
			this.shortValue += " ";
		}
		this.shortValue += str;
		while (this.shortValue.length() < 12) {
			this.shortValue += " ";
		}
	}

	public String getPosition() {
		return this.pos;
	}

	public void setPosition(String str) {
		this.pos = str;
	}

}
