import java.util.ArrayList;

public class Executor {
	ArrayList<Integer> rawInput = InputLoader.getInput();
	ArrayList<Integer> processedInput = new ArrayList<>();
	int oneJoltCounter = 0;
	int threeJoltCounter = 0;
	public void run(){
		int smallestAvailableNum;
		for(int x =0; x< rawInput.size(); x++){
			smallestAvailableNum = rawInput.size() * 3;
			for(int y = 0; y < rawInput.size(); y++){
				if(rawInput.get(y) < smallestAvailableNum && !processedInput.contains(rawInput.get(y))){
					smallestAvailableNum = rawInput.get(y);
				}
			}
			processedInput.add(smallestAvailableNum);
		}
		int previousDevice = 0;
		for(int x = 0; x < processedInput.size(); x++){
			if(processedInput.get(x) - 1 == previousDevice){
				oneJoltCounter++;
			} else if (processedInput.get(x) - 3 == previousDevice){
				threeJoltCounter++;
			}
			previousDevice = processedInput.get(x);
		}
		threeJoltCounter++;
		System.out.println(threeJoltCounter * oneJoltCounter);
	}


}
