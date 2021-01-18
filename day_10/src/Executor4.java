import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* udelas array kterej je stejne velkej jako ten s tema cislama..
na poslednim miste udelas jednicku
pak jedes od predposledniho dolu
pokazdy nastavis ze array[i] = array[i + 1]         (AKA defaultni hodnota je stejna jako predchozi radek)
potom udelas dva na sobe nezavysli ify

prvni kotroluje jestli puvodniArray[i + 3] <= puvodniArray[i] + 3
    pokud ano tak array[i] += array[i+3]
druhej kotroluje jestli puvodniArray[i + 2] <= puvodniArray[i] + 3
   pokud ano tak array[i] += array[i+2]


az dojedes na nulu tak vytisknes jeji hodnotu...

matematicky to funguje tak ze pokud se vejdes do tech +3 od ty predchozi tak prictes ty predchozi
pocet moznejch vysledku zacne exponencialne stoupat
*
*
*
*
*
*
* */



public class Executor4 {
	List<Integer> processedInput;
	List<Long> lastInput = new ArrayList<>();

	public void run(){
		processedInput = Arrays.asList(InputLoader.getArray());
		System.out.println("gud");
		for(int x = 0; x < processedInput.size(); x++){
			lastInput.add(0L);
		}
		System.out.println("gud");
		lastInput.set(lastInput.size() - 1, 1L);
		System.out.println("gud");
		System.out.println(solve());
	}

	public long solve(){
		for(int elementPos = lastInput.size() - 2; elementPos >= 0; elementPos--){
			lastInput.set(elementPos,lastInput.get(elementPos + 1));
			if(elementPos + 3 < processedInput.size() && processedInput.get(elementPos + 3) <= processedInput.get(elementPos) + 3 ){
				lastInput.set(elementPos, lastInput.get(elementPos) + lastInput.get(elementPos + 3));
			}
			if(elementPos + 2 < processedInput.size() && processedInput.get(elementPos + 2) <= processedInput.get(elementPos) + 3 ){
				lastInput.set(elementPos, lastInput.get(elementPos) + lastInput.get(elementPos + 2));
			}
		}
		return lastInput.get(0);
	}
}
