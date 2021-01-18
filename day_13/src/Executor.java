public class Executor {
	int time = InputLoader.getTime();
	String[] busIDs = InputLoader.getIDs();

	public void run(){
		int id;
		int shortestTime = 9999999;
		int shortestTimeID = 9999999;
		for(int x =0; x < busIDs.length; x++){
			if(!busIDs[x].equals("x")){
				id = Integer.parseInt(busIDs[x]);
				if(id - time%id< shortestTime){
					shortestTime = id - time%id;
					shortestTimeID = id;
				}
			}
		}
		System.out.println(shortestTime * shortestTimeID);
	}
}
