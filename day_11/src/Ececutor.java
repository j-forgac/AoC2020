public class Ececutor {
	String[][] newMap = InputLoader.getInput();
	String[][] currentMap = InputLoader.getInput();
	String[][] prevMap = InputLoader.getInput();

	int debug = 0;

	public void run(){
		print(currentMap);
		int hail = 0;
		while(differs()){
			System.out.println("");
			System.out.println("ROUND: " + hail);
			for(int x = 1; x < currentMap.length - 1;x++){
				for(int y = 1; y < currentMap[x].length - 1; y++){
					if(!currentMap[x][y].equals(".")){
						checkRules(x,y);
					}
				}
			}
			copy(currentMap, prevMap);
			copy(newMap, currentMap);
			print(currentMap);
			hail++;
		}
		System.out.println("ROUNDS: " + hail);
		System.out.println("COUNTER: "+count());
	}

	private void checkRules(int row, int column){
		int occupiedSeatsCounter = 0;
		String checkedSeat = currentMap[row][column];
		for(int x = row - 1; x <= row + 1; x++){
			for(int y = column -1; y <= column +1; y++){
				if(!(x == row && y == column)){
					if(currentMap[x][y].equals("#")){
						occupiedSeatsCounter++;
						if (debug == 1) {
							System.out.println(row + ":" +  column + "--->" + x + ":" + y + currentMap[x][y]);
						}
					} else if (debug == 1) {
						System.out.println(row + ":" +  column + "--->" + x + ":" + y + " not occupied");
					}
				} else if (debug ==1) {
					System.out.println(row + ":" +  column + "--->" + x + ":" + y + " not checked");
				}
			}
		}
		if(checkedSeat.equals("L") && occupiedSeatsCounter == 0){
			newMap[row][column] = "#";
		}else if(checkedSeat.equals("#") && occupiedSeatsCounter >= 4){
			newMap[row][column] = "L";
		}
		if (debug == 1) {
			System.out.println(row + ":" + column + " adjacent occupied tiles: " + occupiedSeatsCounter);
		}
	}

	private void copy(String[][] from, String[][] to){
		for(int x = 0; x < from.length; x++){
			for(int y = 0; y < from[x].length; y++){
				to[x][y] = from[x][y];
			}
		}
	}

	private boolean differs(){
		for(int x = 0; x < prevMap.length; x++){
			for(int y = 0; y < prevMap[x].length; y++){
				if(prevMap[x][y] != currentMap[x][y]){
					return true;
				}
			}
		}
		return false;
	}

	private int count(){
		int counter = 0;
		for(int x = 0; x < currentMap.length; x++){
			for(int y = 0; y < currentMap[x].length; y++){
				if(currentMap[x][y].equals("#")){
					counter++;
				}
			}
		}
		return counter;
	}

	private void print(String arr[][]){
		for(int j = 0; j < arr.length;j++){
			for(int y = 0; y < arr[j].length; y++){
				System.out.print(arr[j][y]);
			}
			System.out.println(" ");
		}
	}
}
