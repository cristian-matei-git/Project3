package exercise1;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class ShuntingYard {
	
	private static ArrayDeque<String> stack = new ArrayDeque<>();
	private static LinkedList<String> outputQueue = new LinkedList<>();
	
	public static String[] postFixedMethod(String[] str) {
		
		for(String s : str) {
			
			
		
			while(s != null ) {	
				
				if(isNumeric(s)) {
					
					outputQueue.offer(s);
					break;
					
				}
				
				
				if(!isNumeric(s) && !s.equals("(") && !s.equals(")")) {
					
					String o2 = stack.peek();
	
					try {
						while(!isNumeric(o2) && o2 != null && !o2.equals("(") &&
							(precedence(s) < precedence(o2) || precedence(s) == precedence(o2) && !o2.equals("^"))) {
							
								outputQueue.offer(stack.pop());

							
						}
					}catch (NoSuchElementException e) {}
				
					
					stack.push(s);
					
					break;
					
				}

				if(s.equals("(")) {
					
					stack.push(s);
					break;
					
				}
				
				if(s.equals(")")) {
					
					while(!stack.isEmpty() && !stack.peek().equals("(")) {
							
						outputQueue.offer(stack.pop());
									
					}
					
					if(stack.isEmpty()){
						
						System.out.println("error paranteze gresite");
						break;
						
					}
					
					
					stack.pop();
					break;
				}
					
				
			}
			
			
		}
		
		while(!stack.isEmpty()) {
			
			String o = stack.peek();
			
			outputQueue.offer(stack.pop());
			
			if(o.equals("(")) {
				System.out.println("Expresia avea paranteze gresit6");
				break;
			}
				
			
			
		}
		
		String[] result = new String[outputQueue.size()];
		int i = 0;
		for(String s : outputQueue) {
			
			result[i] = s;
			i++;
			
		}
		
	
		return result;
		
		
	}
	
	private static int precedence(String ch) {
		
		switch(ch) {
			case "+":
			case "-":
				return 11;
			case "*":
			case "/":
				return 12;
			case "^":
				return 13;
			default:
				return 15;
		}	
		
	}
		
	public static boolean isNumeric(String strNum) {
		
	    
	    try {
	    	Integer.parseInt(strNum);
	        
	    } catch (NumberFormatException nfe) {
	    	
	        return false;
	        
	    }
	    return true;
	}
	
	
}
