public class main {
	public static void main(String[] args){
		int[] myInput = InputLoader.getInput();
		int firstNum;
		int pairNum;
		for(int firstNumPos= 0; firstNumPos<myInput.length; firstNumPos++){
			firstNum = myInput[firstNumPos];
			for(int pairNumPos= firstNumPos++; pairNumPos<myInput.length; pairNumPos++){
				pairNum = myInput[pairNumPos];
				if(pairNum + firstNum == 2020){
					System.out.println(firstNum);
					System.out.println(pairNum);
					System.out.println(pairNum*firstNum);
				}
			}
		}
	}
}
