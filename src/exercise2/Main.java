package exercise2;

public class Main {
	
	public static void showArray(String[] str) {
		
		for(String s : str) {
			
			System.out.print(s + " ");
			
		}
		
	}

	public static void main(String[] args) {
		
		String[] test = "321+232^^*+8512*2/-/-".split("");
		
		showArray(test);
		
		System.out.println();
		
		PostfixEval.evaluation(test);
		

	}

}
