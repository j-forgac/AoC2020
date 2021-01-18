public class Executor {
	String[][] myInput = InputLoader.getInput();
	String[] values;
	String currentMask;

	public void run() {
		System.out.println("highest" + highestPos());
		values = new String[highestPos()];
		for (int x = 0; x < myInput.length; x++) {
			if (myInput[x][0].contains("mask")) {
				currentMask = myInput[x][1];
			} else {
				maskValue(Integer.parseInt(myInput[x][0]) - 1, x);
			}
		}
		long result = summarize();
		System.out.println("a" + result);


	}

	private void maskValue(int pos, int pos2) {
		String binaryCode = Integer.toBinaryString(Integer.parseInt(myInput[pos2][1]));
		System.out.println(binaryCode);
		String beginning = "";
		for (int x = 0; x < currentMask.length() - binaryCode.length(); x++) {
			beginning += "0";
		}
		StringBuilder entireCode = new StringBuilder(beginning + binaryCode);
		for (int x = 0; x < currentMask.length(); x++) {
			if (currentMask.charAt(x) != 'X') {
				entireCode.setCharAt(x, currentMask.charAt(x));
			}
		}
		values[pos] = entireCode.toString();
	}

	private long summarize() {
		long sum = 0L;
		long decimal;
		for (String value : values) {
			if (value != null){
				decimal = Long.parseLong(value,2);
				sum += decimal;
			}
		}
		return sum;
	}

	private int highestPos() {
		int pos = 0;
		for(String[] cell : myInput){
			if(!cell[0].contains("mask") && Integer.parseInt(cell[0]) > pos){
				pos = Integer.parseInt(cell[0]);
			}
		}
		return pos;
	}
}
