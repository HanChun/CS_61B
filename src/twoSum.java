import java.util.Arrays;
import java.util.HashMap;

public class twoSum {
	/**
	 * Given an array of intergers nums and an integer target, return indices of the two numbers such
	 * that they add up to target.
	 * Input: int[] nums, int target;
	 */ 
		
	public static HashMap<Integer,Integer> twoSum_Brute(int[] nums, int target) {
		/**
		 * Brute force : 2loop;
		 * Outer loop : i=0, i=n-2;
		 * Inner loop : j=i+1, j=n-1;
		 */
		HashMap<Integer,Integer> i_VS_j = new HashMap<>();
		for (int i=0; i < nums.length-1; i++) {
			for (int j=i+1; j< nums.length; j++) {
				if (nums[i]+nums[j] == target ) {
					//int[] result = {i,j};
					i_VS_j.put(i, j);
					//System.out.println(i+","+j);
					//System.out.println(i_VS_j);
				}
			}			
		}
		System.out.println(i_VS_j);			
		return i_VS_j;
	} 
	
	public static HashMap<Integer, Integer> twoSum_map(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap(); 
		HashMap<Integer, Integer> result = new HashMap();
		// < value, key >; storing value in the position of index is a trick，easier for check;
		
		for(int i=0 ; i<nums.length; i++) {			
			int aim = target - nums[i] ;		
			if (map.containsKey(aim)) {
				result.put(i, map.get(aim));
			}
			map.put(nums[i], i);
		}
		System.out.println(result);		
		return result;
	}
	
	public static HashMap<Integer, Integer> twoSum_index(int[] nums, int target) {
		HashMap<Integer, Integer> result = new HashMap();
		
		int[] interNums = Arrays.copyOf(nums, nums.length);
		Arrays.sort(interNums);
		
		int left = 0;
		int right = interNums.length - 1;
		
		while(left< right) {
			int sum = interNums[left]+ interNums[right];
			if( sum < target) { left = left + 1;}
			else if (sum > target ) { right = right - 1;}
			if (sum == target) { result.put(interNums[left], interNums[right]) ; left = left + 1 ;}	
		}
			
		return result;
	}
	
	public static void main(String[] args) {
		int target= 9;
		//int[] nums = {2,7,3,6,9,1,8};
		//HashMap<Integer,Integer> i_VS_j = twoSum_Brute(new int[]{2,7,3,6,9,1,8}, target);
		//HashMap<Integer,Integer> i_VS_j = twoSum_map(new int[]{2,7,3,6,9,1,8}, target);
		HashMap<Integer,Integer> i_VS_j = twoSum_index(new int[]{2,7,3,6,9,1,8}, target);
		System.out.println(i_VS_j);
		
		//System.out.println(twoSum_map(nums,target)); // Printing array will only show location of that array;
	}
}








