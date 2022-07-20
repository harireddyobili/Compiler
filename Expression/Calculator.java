//Obili Hari Chandra Reddy
//CWID:20009149

//Calculator using recursive decent parsing



//Calculator class which has parsing functions according to the grammar to follow recursive decent parsing

public class Calculator {
	
String a="0";
String d;
char next;
int i =0;
String w="0";
String str;

//token value is the each character we pass through in an given expression


public String tokenValue;



//parameter less constructor


public Calculator() {
	
	
}

//Parameterised constructor for calculator class


public Calculator(String tokenValue) {
 
	
  this.tokenValue = tokenValue;
  
  
}


//A helper method to call expression fucntion from where string parsing starts



String Calculator1(String k)  throws Exception {		
	
	
	//given string expression is assigned to str
	
	str= k;	
	
	//the string parsing starts from here
	
	return expression();
}


//the expression method which implements following grammar

// Expression---->Term
//Expression----->Term+term
//Expression----->Term-term 

String expression()  {
	Calculator left=new Calculator(term());	
	while(1>0) {
		 if(i<str.length()) {
		next=str.charAt(i);
		if(next=='+') {
			i=i+1;
			Calculator right=new Calculator(term());			
			double c=Double.valueOf(left.tokenValue)+Double.valueOf(right.tokenValue);
			System.out.println("Type:addition  "+left.tokenValue+"+"+right.tokenValue);
			left.tokenValue= Double.toString(c);
		}
			else if( next=='-') {
				i=i+1;
				Calculator right=new Calculator(term());
				
				double c=Double.valueOf(left.tokenValue)-Double.valueOf(right.tokenValue);
				
				System.out.println("Type:Subtraction  "+left.tokenValue+"-"+right.tokenValue);
				
				left.tokenValue= Double.toString(c);		
		}
				else
				 return left.tokenValue;				
		 }		 
 else 
	return left.tokenValue;		
}
}

//The term method which implements following grammar
//term()--->factor()

//Term---->term^term

//Term---->term*term
//term----->term/term

String term() {
	Calculator left1=new Calculator(factor());
	while(1>0) {
	if(i<str.length()) {
	char d=str.charAt(i);	

	if(d=='^') {
		i=i+1;
		Calculator right1=new Calculator(factor());		
		double k=Math.pow(Double.valueOf(left1.tokenValue),Double.valueOf(right1.tokenValue));
		System.out.println("Type:EXPONENTIATION  "+left1.tokenValue+"*"+right1.tokenValue);
		left1.tokenValue=Double.toString(k);	
		
	}
//	
	else if(d=='*') {
		i=i+1;
		Calculator right1=new Calculator(factor());
		while(1>0) {
		if(i<str.length()) {
			if(str.charAt(i)=='^') {
			i=i+1;
			Calculator right2=new Calculator(factor());
			double k=Math.pow(Double.valueOf(right1.tokenValue),Double.valueOf(right2.tokenValue));
			System.out.println("Type:EXPONENTIATION  "+right1.tokenValue+"^"+right2.tokenValue);
			right1.tokenValue=Double.toString(k);				
		}
		else
			break;
		}
		else
			break;
		}
		 System.out.println("Type:Multiplication  "+left1.tokenValue+"*"+right1.tokenValue);
		double m=Double.valueOf(left1.tokenValue)*Double.valueOf(right1.tokenValue);	
		 left1.tokenValue= Double.toString(m);		
	 
	}
		else if(d=='/') {
				//scan;
			i=i+1;		
			Calculator right1=new Calculator(factor());
			while(1>0) {
				if(i<str.length()) {
					if(str.charAt(i)=='^') {
					i=i+1;
					Calculator right2=new Calculator(factor());
					double k=Math.pow(Double.valueOf(right1.tokenValue),Double.valueOf(right2.tokenValue));
					System.out.println("Type:EXPONENTIATION   "+right1.tokenValue+"^"+right2.tokenValue);
					right1.tokenValue=Double.toString(k);		
				}
				else
					break;
				}
				else
					break;
				}
				 
				double m=Double.valueOf(left1.tokenValue)/Double.valueOf(right1.tokenValue);
				System.out.println("Type:Division   "+left1.tokenValue+"/"+right1.tokenValue);
				 left1.tokenValue= Double.toString(m);
	}
		else
			return left1.tokenValue;	
	}
	else
		return left1.tokenValue;
		}	
}

// a factor method which implements following grammar

//Factor------>number()
//factor------>'('Expression')'
//factor------> negating a number()
String factor() {

	
	if(i<str.length()) {
	char k=str.charAt(i);	
	
	if(Character.isDigit(k)) {
		w="0";
		Calculator left1=new Calculator(number());
		return left1.tokenValue;
	}
	else if(k=='(') {
		i=i+1;
		Calculator right1=new Calculator(expression());

		if(right1.tokenValue==null) {			
			return null;	
		}
		else if(str.charAt(i)==')') {
			i=i+1;	
			return right1.tokenValue ;
		}	
		
		else 
			return null;	
	}
	
	else if(k=='-') {
		i=i+1;
		w="0";
		Calculator left2=new Calculator(number());
		
		return "-"+left2.tokenValue;
	}
	else 
		return null;
	}
		return null;

}
//Number method which implements following grammar

//number()----->digit()
//number()---->number()'.'number()
//number()----->number()
String number() {
	char c=str.charAt(i);	
	
	
	if(digit(c)!=null) {
		w=w+digit(c);
		i=i+1;
		if(i==str.length()) { 
			
			return w;
		}
		number();
		return w;
		

	}	

		return w;
	
}



//digit method which returns 0 to 9	

String digit(char b){
	if(b=='2')
	{
		
		return "2";
	}
	else if(b=='0')
	{
		
		return "0";
	}
	else if(b=='1')
	{

		return "1";
	}
	else if(b=='3')
	{
		
		return "3";
	}
	else if(b=='4')
	{
	
		return "4";
	}
	else if(b=='5')
	{
	
		return "5";
	}
	else if(b=='6')
	{
		
		return "6";
	}
	else if(b=='7')
	{
		
		return "7";
	}
	else if(b=='8')
	{
	
		return "8";
	}
	else if(b=='9')
	{
	
		return "9";
	}
	else if(b=='.')
	{
	
		return ".";
	}
	else
		return null;
	

}
}
