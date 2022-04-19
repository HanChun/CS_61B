public class judge_Prime {
	public static boolean isDivisible(int x, int k) {
		//System.out.println("Dividend : " + x + "; "+ "Divisor : " + k +" ;");
		if( k >= x ) {
			 //System.out.println("false"); 
			 return false;}
		else if( x % k == 0) {
			 //System.out.println("true"); 
			 return true; }
		else {
			//System.out.println("flase");
			return isDivisible(x,k+1);	
		}
				
	}
	/**
	 * optimize isDivisible;
	 * limit < Math.round(Math.sqrt(x))
	 */
	public static boolean isDivisible_optimize(int x, int k) {
		int limit = (int)Math.round(Math.sqrt(x));
		for (int k1 = k ; k1 <= limit ; k1 = k1+1) {
			if( x%k1 == 0 )
				return true;
		}
		
		return false;
	}
	
	public static boolean isPrime(int x) {
		if( x<=1 )
			return false;
		else
			return !isDivisible(x,2);
	}
	
	public static void printPrimes(int limit) {
		for (int p =2; p<=limit ;  p=p+1) {
			if(isPrime(p)) {
				System.out.print(p + ",");
			}
		}
		
	}
	
	public static void main(String[] args) {
		boolean res = isPrime(13);
		System.out.println(res);
	}
}