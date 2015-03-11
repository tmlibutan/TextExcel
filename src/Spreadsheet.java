import persistence.*;

public class Spreadsheet implements Savable {

	private int rows = 11;
	private int columns = 8;
	private char[] alphabet = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
	private Cell[][] sheet = new Cell[rows][columns];

	/**
	 * Above this are the values for the spreadsheet. A-G are the labeled
	 * X-Axis. We need 11 rows and 8 columns as we have a empty cell on the very
	 * first cell. Used a two-dimensional array to represent the row and columns
	 */

	public String printSheet() {
		/**
		 * printSheet hands all the values above. This method uses its values to
		 * create parts of the spreadsheet. returnString creates the separation
		 * for each cell and constructs the spreadsheet
		 */
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
		/**
		 * This method handles where the input should be put in (e.g A10). This
		 * calls to getPosition to find out where the cell is and then puts in
		 * the input in that cell.
		 */
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (this.sheet[i][j].getPosition().equals(label)) {
					this.sheet[i][j].setValue(input);
				}
			}
		}
	}

	/**
	 * Below this are the load + save methods. This will load a txt file that is
	 * in the root of the TextExcel folder. This will also save a file to the
	 * same location
	 */

	@Override
	public String[] getSaveData() {

		return null;
	}

	@Override
	public void loadFrom(String[] saveData) {

	}
}
