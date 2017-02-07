public class Recursion{

    public static String name(){
	return "Soe,William";
    }

    public static double sqrt(double n){
	return sqrtHelp(n,n/2);
    }

    public static double sqrtHelp(double n, double ans){
	if(((Math.abs(((ans*ans) - n)) / n) * 100) < .0000000001){
	    return ans;
	}
	return sqrtHelp(n,((n / ans) + ans) / 2);
    }

    public static void main(String[]args){
    System.out.println(sqrt(100));
    System.out.println(sqrt(25));
    System.out.println(sqrt(16));
    System.out.println(sqrt(9));
    System.out.println(sqrt(5));
    System.out.println(sqrt(4));
    }
}
