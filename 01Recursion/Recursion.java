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
	if(n == 0.0){
	    return 0.0;
	}
	if(Math.abs((ans*ans - n) / (n * 100)) < .000000000001){
	    return ans;
	}else{
	    return sqrtHelp(n,((n / ans) + ans) / 2);
	}
    }
}
