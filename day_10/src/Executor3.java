/*Takes several weeks - recursion*/

import java.util.ArrayList;

public class Executor3 {
	ArrayList<Integer> rawInput = InputLoader.getInput();
	ArrayList<Integer> processedInput = new ArrayList<>();
	long oldCount = 1;
	long[] tripleAndDouCounter = new long[2];

	public void run() {
		tripleAndDouCounter[0] = 0;
		tripleAndDouCounter[1] = 0;
		int smallestAvailableNum;
		for (int x = 0; x < rawInput.size(); x++) {
			smallestAvailableNum = rawInput.size() * 3;
			for (int y = 0; y < rawInput.size(); y++) {
				if (rawInput.get(y) < smallestAvailableNum && !processedInput.contains(rawInput.get(y))) {
					smallestAvailableNum = rawInput.get(y);
				}
			}
			processedInput.add(smallestAvailableNum);
		}
		long[] myArr = solve(0);
		System.out.println(tripleAndDouCounter[0]);
		System.out.println(tripleAndDouCounter[1]);

		long result = myArr[0] + myArr[1] * 2 + 1;
		System.out.println(result);

	}

	/*--------------------------------------------------------------------------------------------------------*/


	public long[] solve(int adapterPos) {
		int children = 0;
		for (int candidatePos = adapterPos + 1; candidatePos <= adapterPos + 3; candidatePos++) {
			if (candidatePos < processedInput.size() && processedInput.get(adapterPos) + 3 >= processedInput.get(candidatePos)) {
				children++;
				solve(candidatePos);
			}
		}
		if (children == 2) {
			tripleAndDouCounter[0]++;
		} else if (children == 3) {
			tripleAndDouCounter[1]++;
		}
		print(tripleAndDouCounter);
		return tripleAndDouCounter;
	}

	private void print(long[] input){
		if(input[0] + input[1] > oldCount * 2){
			oldCount = input[0] + input[1];
			System.out.println(oldCount);
		}
	}

}
