import java.util.Arrays;

public class InputLoader {
	static long[] processedInput = new long[2020];
	static long[] input = {0,3,6};

	static public long[] getInput(){
		int x =0;
		Arrays.fill(processedInput, -1);
		for(long element:input){
			processedInput[x] = element;
			x++;
		}
		return processedInput;
	}
}
