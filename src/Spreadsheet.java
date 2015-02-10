public class Spreadsheet {
	
	
	private int rows = 11;
	private int columns = 8;
	
	private String[] alphabet = new String[] { "A", "B", "C", "D", "E", "F", "G" };
	private Cell[][] sheet = new Cell[rows][columns];

	public String printSheet() {
		String returnString = "";

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				String cellString = "";
				for (int k = 1; k <= ((12 - sheet[i][j].toString().length()) / 2); k++) {
					cellString += " ";
				}
				cellString += sheet[i][j].toString();
				while (cellString.length() < 12) {
					cellString += " ";
				}
				cellString += "|";
				returnString += cellString;
			}
			returnString += "\n";
			returnString += "------------+------------+------------+------------+------------+------------+------------+------------+";
			returnString += "\n";
		}

		return returnString;
	}

	public Spreadsheet() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				this.sheet[i][j] = new Cell();
			}
		}
		for (int i = 0; i < rows; i++) {
			if (i == 0) {
				for (int j = 1; j < columns; j++) {
					this.sheet[i][j].setValue(alphabet[j - 1]);
				}
			} else {
				this.sheet[i][0].setValue(i + "");
			}
		}
	}
}

