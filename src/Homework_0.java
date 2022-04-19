import java.util.HashMap;
import java.util.Arrays;

public class Homework_0 {
	public static int Max( int[] a) {		
		int flag =  a[0] ;
		for(int i=1 ; i<a.length ; i++) {
			if (flag < a[i]) {
				flag = a[i];
			}
		}		
		return flag ;
	}

	public static boolean threeSum_repeat(int[] nums, int target ) {
		int length = nums.length ;
		//System.out.println(length);
		int[] interNums = Arrays.copyOf(nums, length);
		Arrays.sort(interNums);	
		//System.out.println("interNums"+Arrays.toString(interNums));
		HashMap<Integer, Integer> map = new HashMap();
		
		for(int i=0 ; i< length; i++) {
			//System.out.println("interNums[i] : " + interNums[i]);
			if( map.containsKey( -0.5 * interNums[i]) || map.containsKey(-2 * interNums[i]) || interNums[i]==0 ) {return true;}
			map.put(interNums[i], i);
			//System.out.println(map);
		}
		
		for(int i=0; i<length; i++) {
			int Sum = target - interNums[i] ;
			int left = i + 1 ;
			int right =  length-1 ;
			//System.out.println("sum, left, right : " +Sum +"," + left + "," + right);
			
			while(left < right) {
				//System.out.println("interNums[left] + interNums[right] :" + interNums[left] +","+interNums[right]);
				if( interNums[left]+ interNums[right] == Sum) {return true;}
				else if( interNums[left]+ interNums[right] > Sum) { right = right - 1 ;}
				else if( interNums[left] + interNums[right] < Sum) { left = left + 1 ;}
				
			}		
		}
		return false;
	}
	
	public static boolean threeSum(int[] nums, int target) {
		Arrays.sort(nums);
		int length = nums.length ;
		for( int i=0; i < length ; i++ ) {
			int Sum = target - nums[i];
			int left = i + 1;
			int right = length -1;
			while( left < right ) {
				if( nums[left] + nums[right] == Sum ) { return true ;}
				else if (nums[left]+ nums[right] < Sum) { left = left + 1; }
				else if (nums[left]+ nums[right]> Sum) { right = right - 1;}
			}		
		}		
		return false;
	}
	
	public static void main(String[] args) {
		/** No1. Max
		
		int[] arr = {10,20,30,50,2,3} ;
		int max = Max( arr) ;
		System.out.println("最大值" + max);
		*/
		
		/** */
		int[] arr = {5,1,0,3,6} ;
		int target = 0;
		System.out.println( threeSum(arr,target) );
		
	}
	
}