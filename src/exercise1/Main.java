package exercise1;


public class Main {
	
	public static void showArray(String[] str) {
		
		for(String s : str) {
			
			System.out.print(s + " ");
			
		}
		
	}

	public static void main(String[] args) {
				
		String[] test = "3+(2+1)*2^3^2-8/(5-1*2/2)".split("");
		
		showArray(test);
		
		System.out.println();
		
		String[] result = ShuntingYard.postFixedMethod(test);
			
		showArray(result);
		
	}

	
}
