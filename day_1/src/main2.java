public class main2 {
	public static void main(String[] args) {
		int[] myInput = InputLoader.getInput();
		int firstNum;
		int pairNum;
		int trioNum;
		for (int firstNumPos = 0; firstNumPos < myInput.length; firstNumPos++) {
			firstNum = myInput[firstNumPos];
			for (int pairNumPos = 0; pairNumPos < myInput.length; pairNumPos++) {
				pairNum = myInput[pairNumPos];
				for (int trioNumPos = 0; trioNumPos < myInput.length; trioNumPos++) {
					trioNum = myInput[trioNumPos];
					if (pairNum + firstNum + trioNum == 2020) {
						System.out.println(firstNum);
						System.out.println(pairNum);
						System.out.println(trioNum);
						System.out.println(pairNum * firstNum * trioNum);
					}
				}
			}
		}
	}
}

