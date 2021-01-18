public class Executor2 {
	static int cycles = 6;

	static String[] input = InputLoader.getInput();
	static char[][][][] cubes = new char[3 + 2 * cycles][3 + 2 * cycles][2 + input.length + 2 * cycles][2 + input.length + 2 * cycles];
	static char[][][][] newMap = new char[3 + 2 * cycles][3 + 2 * cycles][2 + input.length + 2 * cycles][2 + input.length + 2 * cycles];

	public void run() {
		setStartingCubes();
		for (int times = 0; times < cycles; times++) {
			for (int w = 1; w < cubes.length - 1; w++) {
				for (int z = 1; z < cubes[w].length - 1; z++) {
					for (int x = 1; x < cubes[w][z].length - 1; x++) {
						for (int y = 1; y < cubes[w][z][x].length - 1; y++) {
							checkRules(w, z, x, y);
						}
					}
				}
			}
			copy(newMap, cubes);
		}
		System.out.println("RESULT: " + count());
	}

	private void setStartingCubes() {
		for (int w = 0; w < cubes.length; w++) {
			System.out.println("W = " + w);
			for (int z = 0; z < cubes[w].length; z++) {
				System.out.println("Z = " + z);
				for (int x = 0; x < cubes[w][z].length; x++) {
					for (int y = 0; y < cubes[w][z][x].length; y++) {
						if (x > cycles && x <= cycles + input.length && y > cycles && y <= cycles + input.length && z == cycles + 1 && w == cycles + 1) {
							cubes[w][z][x][y] = input[x - cycles - 1].charAt(y - cycles - 1);
						} else {
							cubes[w][z][x][y] = '.';
						}
						System.out.print(cubes[w][z][x][y]);
					}
					System.out.println();
				}
			}
		}
	}

	public void checkRules(int w, int z, int x, int y) {
		int activeCounter = 0;
		for (int virtualLayer = w - 1; virtualLayer < w + 2; virtualLayer++) {
			for (int layer = z - 1; layer < z + 2; layer++) {
				for (int row = x - 1; row < x + 2; row++) {
					for (int column = y - 1; column < y + 2; column++) {
						if (!(row == x && column == y && layer == z && virtualLayer == w)) {
							if (cubes[virtualLayer][layer][row][column] == '#') {
								activeCounter++;
							}
						}
					}
				}
			}
		}
		if (activeCounter == 3 || (activeCounter == 2 && cubes[w][z][x][y] == '#')) {
			newMap[w][z][x][y] = '#';
		} else {
			newMap[w][z][x][y] = '.';
		}
	}

	private void copy(char[][][][] from, char[][][][] to) {
		for (int w = 0; w < from.length; w++) {
			for (int z = 0; z < from[w].length; z++) {
				for (int x = 0; x < from[w][z].length; x++) {
					for (int y = 0; y < from[w][z][x].length; y++) {
						to[w][z][x][y] = from[w][z][x][y];
					}
				}
			}
		}
	}

	private int count() {
		int counter = 0;
		for (int w = 0; w < cubes.length; w++) {
			for (int z = 0; z < cubes[w].length; z++) {
				for (int x = 0; x < cubes[w][z].length; x++) {
					for (int y = 0; y < cubes[w][z][x].length; y++) {
						if (cubes[w][z][x][y] == '#') {
							counter++;
						}
					}
				}
			}
		}
		return counter;
	}
}
