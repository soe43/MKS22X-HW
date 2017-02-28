public class Recursion{

    public static String name(){
	return "Soe,William";
    }

    public static double sqrt(double n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}else{
	return sqrtHelp(n,n/2);
	}
    }

    public static double sqrtHelp(double n, double ans){
	if(Math.abs((ans*ans - n) / (n * 100)) < .000000000001){
	    return ans;
	}else{
	    return sqrtHelp(n,((n / ans) + ans) / 2);
	}
    }

    public static void main(String[]args){
	System.out.println(sqrt(100));
	System.out.println(sqrt(105));
	System.out.println(sqrt(1));
	System.out.println(sqrt(7));
	System.out.println(sqrt(1024));
	System.out.println(sqrt(0));
    }
}
