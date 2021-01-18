public class InputLoader {
	static String[] input = {
			"F10",
			"N3",
			"F7",
			"R90",
			"F11",
	};
	static String[][] processedInput = new String[input.length][2];

	public static String[][] getInput() {
		for (int x = 0; x < input.length; x++) {
			processedInput[x][0] = input[x].substring(0, 1);
			processedInput[x][1] = input[x].substring(1);
		}
		return processedInput;
	}
}



