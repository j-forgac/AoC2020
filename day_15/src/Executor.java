public class Executor {
	long[] myInput = InputLoader.getInput();

	public void run() {
		for (int turn = 0; turn < myInput.length; turn++) {
			if (myInput[turn] == -1) {
				myInput[turn] = findOccurrence(turn - 1);
			}
		}
		System.out.println(myInput[myInput.length-1]);
	}

	public int findOccurrence(int pos) {
		long wantedNum = myInput[pos];
		for (int x = pos - 1; x >= 0; x--) {
			if (myInput[x] == wantedNum) {
				return pos - x;
			}
		}
		return 0;
	}
}
