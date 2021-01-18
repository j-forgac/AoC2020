public class Executor {
	static int cycles = 6;

	static String[] input = InputLoader.getInput();
	static char[][][] cubes = new char[3 + 2 * cycles][2 + input.length + 2 * cycles][2 + input.length + 2 * cycles];
	static char[][][] newMap = new char[3 + 2 * cycles][2 + input.length + 2 * cycles][2 + input.length + 2 * cycles];

	public void run() {
		setStartingCubes();
		for (int a = 0; a < cycles; a++) {
			System.out.println("CYCLES: " + a);
			for (int z = 1; z < cubes.length - 1; z++) {
				for (int x = 1; x < cubes[z].length - 1; x++) {
					for (int y = 1; y < cubes[z][x].length - 1; y++) {
						checkRules(z, x, y);
						System.out.print(cubes[z][x][y]);
					}
					System.out.println("");
				}
				System.out.println("Z = " + z);
			}
			copy(newMap, cubes);
		}
		System.out.println("RESULT: "+count());
	}

	private void setStartingCubes() {
		for (int z = 0; z < cubes.length; z++) {
			System.out.println("Z = " + z);
			for (int x = 0; x < cubes[z].length; x++) {
				for (int y = 0; y < cubes[z][x].length; y++) {
					if (x > cycles && x <= cycles + input.length && y > cycles && y <= cycles + input.length && z == cycles + 1) {
						cubes[z][x][y] = input[x - cycles - 1].charAt(y - cycles - 1);
					} else {
						cubes[z][x][y] = '.';
					}
					System.out.print(cubes[z][x][y]);
				}
				System.out.println();
			}
		}
	}

	public void checkRules(int z, int x, int y) {
		int activeCounter = 0;
		for (int layer = z - 1; layer < z + 2; layer++) {
			for (int row = x - 1; row < x + 2; row++) {
				for (int column = y - 1; column < y + 2; column++) {
					if (!(row == x && column == y && layer == z)) {
						if (cubes[layer][row][column] == '#') {
							activeCounter++;
						}
					}
				}
			}
		}
		if (activeCounter == 3 || (activeCounter == 2 && cubes[z][x][y] == '#')) {
			newMap[z][x][y] = '#';
		} else {
			newMap[z][x][y] = '.';
		}
	}

	private void copy(char[][][] from, char[][][] to) {
		for (int z = 0; z < from.length; z++) {
			for (int x = 0; x < from[z].length; x++) {
				for (int y = 0; y < from[z][x].length; y++) {
					to[z][x][y] = from[z][x][y];
				}
			}
		}
	}

	private int count() {
		int counter = 0;
		for (int z = 0; z < cubes.length; z++) {
			for (int x = 0; x < cubes[z].length; x++) {
				for (int y = 0; y < cubes[z][x].length; y++) {
					if (cubes[z][x][y] == '#') {
						counter++;
					}
				}
			}
		}
		return counter;
	}
}
