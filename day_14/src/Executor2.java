import java.util.ArrayList;
import java.util.HashMap;

public class Executor2 {
	String[][] myInput = InputLoader.getInput2();
	HashMap<String, String> memory = new HashMap<String, String>();
	HashMap<Integer, String> binaryXOptions = new HashMap<Integer, String>();
	ArrayList<Integer> positions = new ArrayList<Integer>();
	String currentMask;

	public void run() {
		for (int x = 0; x < myInput.length; x++) {
			if (myInput[x][0].contains("mask")) {
				setMask(x);
			} else {
				maskKey(x);
			}
		}
		System.out.println(summarize());
	}

	public void maskKey(int x) {
		int floatingXCounter = 0;
		positions.clear();
		StringBuilder maskedValue = new StringBuilder(myInput[x][0]);
		for(int numAt = 0; numAt < currentMask.length(); numAt++){
			if (currentMask.charAt(numAt) == '1'){
				maskedValue.setCharAt(numAt,'1');
			} else if (currentMask.charAt(numAt) == 'X'){
				positions.add(numAt);
			}
		}

		for(int variant = 0; variant < binaryXOptions.size(); variant++){ /*Floating X -> new options created here*/
			for(int numAt = 0; numAt < positions.size(); numAt++){
				maskedValue.setCharAt(positions.get(numAt),binaryXOptions.get(variant).charAt(numAt));
			}
			memory.put(maskedValue.toString(),myInput[x][1]);
		}
	}

	public void setMask(int x){
		binaryXOptions.clear();
		currentMask = myInput[x][1];
		int count = currentMask.length() - currentMask.replace("X", "").length();
		int counter = 0;
		String beginning;
		String binaryNum;
		for(double options = 0; options < Math.pow(2, count);options++){
			beginning = "";
			binaryNum = Integer.toBinaryString(counter);
			for(int space = 0; space < count - binaryNum.length(); space++){
				beginning += "0";
			}
			binaryNum = beginning + binaryNum;
			binaryXOptions.put(counter,binaryNum);
			counter++;
		}
	}

	public long summarize(){
		long sum = 0;
		for (String value : memory.values()) {
			sum += Integer.parseInt(value);
		}
		return sum;
	}
}
