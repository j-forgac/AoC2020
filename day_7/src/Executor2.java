import java.util.ArrayList;

public class Executor2 {
	String[] rawInput = InputLoader.getInput();
	String[][] processedInput = new String[rawInput.length][5];
	int[][] processedInputValues = new int[rawInput.length][5];

	public void run() throws Exception{
		int shorten = 0;
		int[][] bagRoute = new int[rawInput.length][2];
		ArrayList<String> bagsContainingGoldenBag = new ArrayList<>();
		bagsContainingGoldenBag.add("shiny gold bag");
		for (int x = 0; x < rawInput.length; x++) {
			rawInput[x] = rawInput[x].replaceAll("contain", "#");
			rawInput[x] = rawInput[x].replaceAll(",", "#");

			processedInput[x] = rawInput[x].split("#");
			processedInputValues[x][0] = -1;

			for (int y = 0; y < processedInput[x].length; y++) {
				if (y == 0) {
					processedInput[x][y] = processedInput[x][y].substring(0, processedInput[x][y].length() - 2);
				} else {
					if (processedInput[x][y].charAt(1) == '1') {
						shorten = 0;
					} else {
						shorten = 1;
					}
					if (processedInput[x][y].charAt(1) != 'n') {
						processedInputValues[x][y] = Integer.parseInt(processedInput[x][y].substring(1, 2));
						if (y == processedInput[x].length - 1) {
							processedInput[x][y] = processedInput[x][y].substring(3, processedInput[x][y].length() - 1 - shorten);
						} else {
							processedInput[x][y] = processedInput[x][y].substring(3, processedInput[x][y].length() - shorten);
						}
					} else {
						processedInputValues[x][y] = 0;
					}
					System.out.println(processedInput[x][y]);
				}
			}
		}
		/*--------------------------------------------------------------------------------------------------------------------*/
		print();
		int currentRowNum = findBagRow("shiny gold bag");
		int result = countBags(currentRowNum,1) - 1;
		System.out.println(result);

	}
	private int countBags (int currentRowNum, int bagCount) throws Exception{
		String childBagName;
		int counter = 1;
		for(int bagNum = 1; bagNum < processedInput[currentRowNum].length; bagNum++){
			 childBagName = processedInput[currentRowNum][bagNum];
			 int childBackCount = processedInputValues[currentRowNum][bagNum];
			 if(!childBagName.equals(" no other bags.")){
				 counter += childBackCount * countBags(findBagRow(childBagName), childBackCount);
			 } else {
				 counter = 1;
			 }
		}
		return counter;
	}


	private int findBagRow(String bag) throws Exception{
		for(int rowNum =0; rowNum < this.processedInput.length; rowNum++) {
			if(processedInput[rowNum][0].equals(bag)){
				return rowNum;
			}
		}
		throw new Exception("Didn't find the bag '" +bag + "'");
	}

	/*--------------------------------------------------------------------------------------------------------------------*/


	private void print(){
		for(int  x = 0; x < processedInput.length; x++){
			for(int  y = 0; y < processedInput[x].length; y++){
				System.out.print(processedInput[x][y] + ", ");
			}
			System.out.println("");
		}

		for(int  x = 0; x < processedInputValues.length; x++){
			for(int  y = 0; y < processedInputValues[x].length; y++){
				System.out.print(processedInputValues[x][y] + ", ");
			}
			System.out.println("");
		}
	}
}
