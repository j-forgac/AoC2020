public class Executor {
	public void run() {
		char[][] myMap = InputLoader.getInput();
		int counter = 0;
		int column = 0;
		for (int row = 0; row < myMap.length; row = row + 2) {
			if (myMap[row][column] == '#') {
				counter++;
			}
			if (column + 1 < myMap[row].length) {
				column = column + 1;
			} else {
				column = column + 1 - myMap[row].length;
			}
			System.out.println(row + " : " + counter);
		}
	}
}
