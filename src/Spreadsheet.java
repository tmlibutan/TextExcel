import persistence.*;
public class Spreadsheet implements Savable {

	private int rows = 11;
	private int columns = 8;
	private char[] alphabet = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
	private Cell[][] sheet = new Cell[rows][columns];

	public String printSheet() {
		String returnString = "";

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				String cellString = this.sheet[i][j].toShort();
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
			for (int j = 0; j < columns; j++) {
				if (i == 0 || j == 0) {
					this.sheet[i][j].setPosition("null");
				} else {
					String pos = alphabet[j - 1] + "";
					pos = pos + i + "";
					this.sheet[i][j].setPosition(pos);
				}
			}
		}
		for (int i = 0; i < rows; i++) {
			if (i == 0) {
				for (int j = 1; j < columns; j++) {
					this.sheet[i][j].setValue(alphabet[j - 1] + "");
				}
			} else {
				this.sheet[i][0].setValue(i + "");
			}
		}
	}
	public void setValueAt(String label, String input) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (this.sheet[i][j].getPosition().equals(label)) {
					this.sheet[i][j].setValue(input);
				}
			}
		}
	}

	@Override
	public String[] getSaveData() {
		
		return null;
	}

	@Override
	public void loadFrom(String[] saveData) {
		
	}
}
