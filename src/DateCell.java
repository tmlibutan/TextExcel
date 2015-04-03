
public class DateCell extends Cell{
	public DateCell(int month, int day, int year, String label) {
		String fullVal = "";
		
		if (month < 10) {
			fullVal += "0" + month;
		}
		else {
			fullVal += month + "";
		}
		
		if (day < 10) {
			fullVal += "/0" + day;
		}
		else {
			fullVal += "/" + day;
		}
		
		fullVal += "/" + year;
		String shortVal = "";
		for (int k = 1; k <= ((12 - fullVal.length()) / 2); k++) {
			shortVal += " ";
		}
		shortVal += fullVal;
		while (shortVal.length() < 12) {
			shortVal += " ";
		}
		super.setValue(fullVal, shortVal);
		setPosition(label);
	}
}
