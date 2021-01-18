public class Executor {
	public void run() {
		String myInput[][] = InputLoader.getInput();
		int coos[] = new int[2];
		String action;
		int value;
		int facing = 90;
		for (int x = 0; x < myInput.length; x++) {
			action = myInput[x][0];
			value = Integer.parseInt(myInput[x][1]);
			if (action.equals("N")) {
				coos[1] += value;
			} else if (action.equals("S")) {
				coos[1] -= value;
			} else if (action.equals("E")) {
				coos[0] += value;
			} else if (action.equals("W")) {
				coos[0] -= value;
			} else if (action.equals("L")) {
				if(facing == 360){
					facing = 0;
				}
				if (facing >= 360 - value) {
					facing += value - 360;
				} else {
					facing += value;
				}
			} else if (action.equals("R")) {
				if(facing == 0){
					facing = 360;
				}
				if (facing <= value) {
					facing += 360 - value;
				} else {
					facing -= value;
				}
			} else if (action.equals("F")) {
				if (facing == 180) {
					coos[1] += value;
				} else if (facing == 0 || facing == 360) {
					coos[1] -= value;
				} else if (facing == 90) {
					coos[0] += value;
				} else if (facing == 270) {
					coos[0] -= value;
				}
			}
		}
		System.out.println(Math.abs(coos[0]) + Math.abs(coos[1]));
	}
}
