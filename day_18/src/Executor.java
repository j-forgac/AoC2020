public class Executor {
	String[] input = InputLoader.getInput();
	int position;
	String equation = " ";

	public void run() {
		long result = 0L;
		for (String s : input) {
			position = 0;
			equation = s;
			result += evaluate();
		}
		System.out.println("JE TO:"+result);
	}

	public long evaluate() {
		char operation = '+';
		long count = 0L;
		while (position<equation.length()){
			switch (equation.charAt(position)){
				case '(':
					position++;
					if(operation == '*'){
						count *= evaluate();;
					} else {

						count += evaluate();;
					}
					operation = '+';
					break;
				case ')':
					return count;
				case '*':
					operation = '*';
					break;
				case '+':
					operation = '+';
					break;
				default:
					if(operation == '*'){
						count *= Long.parseLong(Character.toString(equation.charAt(position)));
					} else {
						count += Long.parseLong(Character.toString(equation.charAt(position)));
					}
			}
			position++;
		}
		return count;
	}
}
