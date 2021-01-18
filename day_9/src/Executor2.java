public class Executor2 {
	Executor executor = new Executor();
	long notValidNum = executor.run();
	long[] myInput = InputLoader.getInput();
	long[] numSet = new long[myInput.length];
	int posCounter = 0;

	public void run() {
		outerFor:
		for (int startingLine = 0; startingLine < myInput.length; startingLine++) {
			for (int numPos = startingLine; numPos < myInput.length; numPos++) {
				if (myInput[numPos] == notValidNum) {
					removeElements(numSet);
					numPos++;
				}
				if (summarize(numSet) > notValidNum) {
					removeElements(numSet);
				} else if (summarize(numSet) == notValidNum) {
					System.out.print("RESULT: ");
					printResult(numSet);
					break outerFor;
				}
				numSet[posCounter] = myInput[numPos];
				posCounter++;
			}
			removeElements(numSet);

		}
	}

	public long summarize(long[] arr) {
		long sum = 0;
		for (long num : arr) {
			sum += num;
		}
		return sum;
	}

	public void removeElements(long[] arr) {
		for (int x = 0; x < arr.length; x++) {
			arr[x] = 0;
		}
		posCounter = 0;
	}

	public void printResult(long[] arr) {
		long result = 0;
		long tempNum = 0;
		for (int x = 0; x < arr.length; x++) {
			if (arr[x] > tempNum) {
				tempNum = arr[x];
			}
		}

		result += tempNum;
		for (int x = 0; x < arr.length; x++) {
			if (arr[x] < tempNum && arr[x] != 0) {
				tempNum = arr[x];
			}
		}

		result += tempNum;
		System.out.println(result);
	}
}
