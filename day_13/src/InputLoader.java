public class InputLoader {
	static String[] input = {
			"1002576",
			"13,x,x,x,x,x,x,37,x,x,x,x,x,449,x,29,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,19,x,x,x,23,x,x,x,x,x,x,x,773,x,x,x,x,x,x,x,x,x,41,x,x,x,x,x,x,17",
	};
	static String[] processedInput;
	static int time;

	public static String[] getIDs() {
		processedInput = input[1].split(",");
		return processedInput;
	}

	public static int getTime() {
		time = Integer.parseInt(input[0]);
		return time;
	}

}