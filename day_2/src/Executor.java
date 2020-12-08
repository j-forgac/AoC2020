public class Executor {
	public void run() {
		int counter = 0;
		String[] myInput = InputLoader.getInput();
		for(int x =0; x < myInput.length;x++){
			if(checkValidityOfPassword(myInput[x])){
				counter++;
			}
		}
		System.out.println(counter);
	}

	private boolean checkValidityOfPassword(String password) {
		int bottomLimit;
		int upperLimit;
		int count;

		String checkedChar;
		String checkedPassword;
		String[] str = password.split(" ");

		bottomLimit = Integer.parseInt(str[0].split("-")[0]);
		upperLimit = Integer.parseInt(str[0].split("-")[1]);

		checkedChar = Character.toString(str[1].charAt(0));
		checkedPassword = str[2];

		count = checkedPassword.length() - checkedPassword.replace(checkedChar,"").length();

		return count <= upperLimit && count >= bottomLimit;
	}
}
