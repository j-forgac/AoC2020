import java.util.ArrayList;
import java.util.HashMap;

public class Executor {
	HashMap<Integer, ArrayList<String>> inputRules = InputLoader.getRules();
	String[] expressions = InputLoader.getExpressions();
	HashMap<Integer, ArrayList<String>> rulesCases = new HashMap<Integer, ArrayList<String>>();

	public void run() {
		System.out.println();
		evaluate(0);
	}

	public void evaluate(int ruleKey) {
		int operation = 1;
		int checkRule = -1;
		ArrayList<Integer> firstHalf = new ArrayList<>();
		ArrayList<String> secondHalf = new ArrayList<>();
		if (rulesCases.get(ruleKey) == null) {
			System.out.println("neni v zaznamu");
			for (int x = 0; x < inputRules.get(ruleKey).size(); x++) {
				if (!inputRules.get(ruleKey).get(x).equals("|")) {
					checkRule = Integer.parseInt(inputRules.get(ruleKey).get(x));
					if (rulesCases.get(ruleKey) == null) {
						evaluate(checkRule);
					}
					if (operation == 1) {
						firstHalf.add(checkRule);
					} else {
						secondHalf.add(checkRule);
					}
				} else {
					operation = 0;
				}
			}
		} else {
			System.out.println("je v zaznamu");
			return;
		}
		System.out.println("je v zaznamu");

	}

	public void combine(ArrayList<Integer> input, ArrayList<String> target) {

	}
}
