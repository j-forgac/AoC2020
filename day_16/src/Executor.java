public class Executor {
	String myInput[][] = InputLoader.getRules();
	int tickets[][] = InputLoader.getTickets();
	String limits[][][] = new String[myInput.length][2][2];
	long errorCode = 0;

	public void run() {
		setIntervalLimits();
		for (int x = 0; x < tickets.length; x++) {
			for (int y = 0; y < tickets[x].length; y++) {
				errorCode += checkValidity(tickets[x][y]);
			}
		}
		System.out.print(errorCode);
	}

	public void setIntervalLimits() {
		for (int x = 0; x < myInput.length; x++) {
			limits[x][0] = myInput[x][1].split("-");
			limits[x][1] = myInput[x][2].split("-");
		}
	}

	public int checkValidity(int num) {
		for (int x = 0; x < limits.length; x++) {
			for (int y = 0; y < limits[x].length; y++) {
				if (num >= Integer.parseInt(limits[x][y][0]) && num <= Integer.parseInt(limits[x][y][1])) {
					System.out.println(limits[x][y][0]);
					System.out.println(limits[x][y][1]);
					System.out.println("this is ok" + x + " " + y + " " + num);
					return 0;
				}
			}
		}
		return num;
	}
}
