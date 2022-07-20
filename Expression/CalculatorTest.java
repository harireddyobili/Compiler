
import java.util.Scanner;

public class CalculatorTest {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Calculator a=new Calculator();
		
	try {
	

	
	//talking input expression
	String Str= input.nextLine(); 

	System.out.println("The Output vaue after calculation is  : " +Double.valueOf(a.Calculator1(Str)));	
	
	}
	
	catch(Exception e) {
		
		System.out.println("Given expression is not valid");
		
	}

	
		}
		
		
	}
	
	

