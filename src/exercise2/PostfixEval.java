package exercise2;

import java.util.LinkedList;

public class PostfixEval {
	
	private static LinkedList<Double> stack = new LinkedList<>();
	
	public static void evaluation(String[] str) {
		
		double result = 0;
		
		for(String s : str) {
		
			while(s != null) {
				
				if(isNumeric(s)) {
					
					stack.push(Double.parseDouble(s));
					break;
					
				}else {
					
					double op1 = stack.pop();
					double op2 = stack.pop();
					
					if(op1 == 0 || op2 == 0) {
						
						System.out.println("Eroare expresia postfixata este gresita");
						return;
						
					}
					
					result = mathOperation(s, op2, op1); 
					stack.push(result);
					break;
				}
			}
		}
		
		result = stack.pop();
		
		if(!stack.isEmpty()) {
			
			System.out.println("Eroare expresia postfixata este gresita");
			return;
			
		}
		
		System.out.println((int)result);
	}
	
	public static boolean isNumeric(String strNum) {
		
	    
	    try {
	    	
	         Integer.parseInt(strNum);
	        
	    } catch (NumberFormatException nfe) {
	    	
	        return false;
	        
	    }
	    return true;
	}
	
	public static double mathOperation(String s, double op2, double op1) {
		
		switch(s) {
			case "+":
				return op2 + op1;
			case "-":
				return op2 - op1;
			case "*":
				return op2 * op1;
			case "/":
				return op2 / op1;
			case "^":
				return Math.pow(op2, op1);
			default:
				return 0;

		}
		
		
	}
}
