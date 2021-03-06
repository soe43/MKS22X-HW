import java.util.Stack;

public class StackCalc{
public static double eval(String s){
    String[] tokens = s.split(" ");
    Stack<Double> values = new Stack<Double>();

    for(String token : tokens){
	if(isOp(token)){
	    values.push(perform(token,values.pop(),values.pop()));
	}
	else{
	    values.push(Double.parseDouble(token));
	}
    }
    return values.pop();
}

private static boolean isOp(String s){
    char ch = s.charAt(0);
    switch(ch){
    case '+': return true;
    case '-': return true;
    case '*': return true;
    case '/': return true;
    case '%': return true;
    default: return false;
    }
}

private static double perform(String op,double n1,double n2){
    double sol = 0;
    if(op.equals("+")){
	sol = n2 + n1;
    }
    if(op.equals("-")){
	sol = n2 - n1;
    }
    if(op.equals("/")){
	sol = n2/n1;
     }
    if(op.equals("*")){
	sol = n2*n1;
    }
    if(op.equals("%")){
	sol = n2%n1;
    }
    return sol;
}

public static void main(String[] args)
{
    System.out.println(StackCalc.eval("10 2 +"));//12.0
    System.out.println(StackCalc.eval("10 2 -"));//8.0
    System.out.println(StackCalc.eval("10 2.0 +"));//12.0
    System.out.println(StackCalc.eval("11 3 - 4 + 2.5 *"));//30.0
    System.out.println(StackCalc.eval("8 2 + 99 9 - * 2 + 9 -"));//893.0
    System.out.println(StackCalc.eval("10 2 + 10 * 1 + 1 1 1 + + + 10 10 + -"));//104.0
}
}
	
       
