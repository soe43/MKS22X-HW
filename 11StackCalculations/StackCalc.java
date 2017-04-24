import java.util.Stack;

public class StackCalc{
public static double eval(String s){
    String[] tokens = s.split(" ");
    Stack<Double> values = new Stack<Double>();

    if(tokens.length == 1){
	return Double.parseDouble(tokens[0]);
    }
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
    switch(s){
    case "+": return true;
    case "-": return true;
    case "*": return true;
    case "/": return true;
    case "%": return true;
    default: return false;
    }
}

private static double perform(String op,double n1,double n2){
    double sol = 0;
    if(op.equals("+")){
	sol = n1 + n2;
    }
    if(op.equals("-")){
	sol = n1-n2;
    }
    if(op.equals("/")){
	sol = n1/n2;
     }
    if(op.equals("*")){
	sol = n1*n2;
    }
    if(op.equals("%")){
	sol = n1%n2;
    }
    return sol;
}

}
	
       
