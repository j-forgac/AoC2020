public class Executor2 {
	public void run() {

		char[][] myMap = InputLoader.getInput();
		double result = toboggan(1,1, myMap) * toboggan(3,1, myMap) * toboggan(5,1, myMap) * toboggan(7,1, myMap) * toboggan(1,2, myMap);

		System.out.println(toboggan(1,1, myMap));
		System.out.println(toboggan(3,1, myMap));
		System.out.println(toboggan(5,1, myMap));
		System.out.println(toboggan(7,1, myMap));
		System.out.println(toboggan(1,2, myMap));
		System.out.println(result);

	}

	public double toboggan(int right, int down, char myMap[][]){
		int counter = 0;
		int column = 0;
		for (int row = 0; row < myMap.length; row = row + down) {
			if (myMap[row][column] == '#') {
				counter++;
			}
			if (column + right < myMap[row].length) {
				column = column + right;
			} else {
				column = column + right - myMap[row].length;
			}
		}
		return counter;
	}


}
