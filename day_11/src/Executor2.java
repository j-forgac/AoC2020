public class Executor2 {
	String[][] newMap = InputLoader.getInput();
	String[][] currentMap = InputLoader.getInput();
	String[][] prevMap = InputLoader.getInput();
	int occupiedSeatsCounter;
	int debug = 0;

	public void run() {
		print(currentMap);
		int hail = 0;
		while (differs()) {
			System.out.println("");
			System.out.println("ROUND: " + hail);
			for (int x = 1; x < currentMap.length - 1; x++) {
				for (int y = 1; y < currentMap[x].length - 1; y++) {
					if (!currentMap[x][y].equals(".")) {
						checkRules(x, y);
					}
				}
			}
			copy(currentMap, prevMap);
			copy(newMap, currentMap);
			print(currentMap);
			hail++;
		}
		System.out.println(hail);
		System.out.println(count());
	}

	private void checkRules(int row, int column) {
		occupiedSeatsCounter = 0;
		String checkedSeat = currentMap[row][column];

		moveChecker(1, 0, row, column);
		moveChecker(1, 1, row, column);
		moveChecker(0, 1, row, column);
		moveChecker(-1, 1, row, column);
		moveChecker(-1, 0, row, column);
		moveChecker(-1, -1, row, column);
		moveChecker(0, -1, row, column);
		moveChecker(1, -1, row, column);

		if (checkedSeat.equals("L") && occupiedSeatsCounter == 0) {
			newMap[row][column] = "#";
		} else if (checkedSeat.equals("#") && occupiedSeatsCounter >= 5) {
			newMap[row][column] = "L";
		}
	}

	public void moveChecker(int y, int x, int row, int column) {
		int checkerPosX = column;
		int checkerPosY = row;
		while (true) {
			checkerPosX += x;
			checkerPosY += y;
			if (currentMap[checkerPosY][checkerPosX].equals("#")) {
				occupiedSeatsCounter++;
				break;
			} else if (currentMap[checkerPosY][checkerPosX].equals("L") || currentMap[checkerPosY][checkerPosX].equals("*")) {
				break;
			}
		}
	}

	private void copy(String[][] from, String[][] to) {
		for (int x = 0; x < from.length; x++) {
			for (int y = 0; y < from[x].length; y++) {
				to[x][y] = from[x][y];
			}
		}
	}

	private boolean differs() {
		for (int x = 0; x < prevMap.length; x++) {
			for (int y = 0; y < prevMap[x].length; y++) {
				if (prevMap[x][y] != currentMap[x][y]) {
					return true;
				}
			}
		}
		return false;
	}

	private int count() {
		int counter = 0;
		for (int x = 0; x < currentMap.length; x++) {
			for (int y = 0; y < currentMap[x].length; y++) {
				if (currentMap[x][y].equals("#")) {
					counter++;
				}
			}
		}
		return counter;
	}

	private void print(String arr[][]) {
		for (int j = 0; j < arr.length; j++) {
			for (int y = 0; y < arr[j].length; y++) {
				System.out.print(arr[j][y]);
			}
			System.out.println(" ");
		}
	}
}



