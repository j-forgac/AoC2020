public class Executor {
	public long run() {
		long[] myInput = InputLoader.getInput();
		long notValid;
		for(int x = 25; x < myInput.length; x++){
			notValid = checkValidity(x,myInput);
			if(notValid != -1){
				System.out.println(notValid);
				return notValid;
			}
		}
		return -1;
	}
	public long checkValidity(int numPos, long[] arr) {
		for(int x = numPos-25; x<numPos; x++){
			for(int z = x + 1; z<numPos;z++){
				if(arr[x] + arr[z] == arr[numPos]){
					return -1;
				}
			}
		}
		return arr[numPos];
	}
}