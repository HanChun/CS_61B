import java.util.HashMap;
import java.util.Arrays;
import java.util.*;

/**
 * Return triplets [nums[i],nums[j],nums[k]] such that i!=j,i+!k, and j =!k, and nums[i]+nums[j]+nums[k] ==0
 * @author hanchun
 *
 */
public class threeSum {
	public static List<List<Integer>> threeSum_index(int[] nums, int target) {
		
		Arrays.sort(nums);
		int length = nums.length;
		List<List<Integer>> result = new ArrayList<>();
		
		for(int i = 0; i< length ; i++) {
			int sum = target - nums[i];
			int left = i+1;
			int right = length-1;
			while(left < right) {
				int interRes = nums[left] + nums[right] ;
				
				if( interRes == sum) { 
					result.add( Arrays.asList(nums[i],nums[left],nums[right]) ) ; 
					left = left +1;
					while( left<right && nums[left] == nums[left-1]) left=left+1 ;
				}
				else if( interRes < sum) { left = left + 1 ; }
				else if( interRes > sum ) {right =  right-1 ; }
			}
			while( i+1<length && nums[i]==nums[i+1] )  i = i+1;
		}		
		return result;
	}
	
	
	public static void main(String[] args) {
		
		List<List<Integer>> res = threeSum_index(new int[]{-6,-3,-3,-3,-2,-2,0,0,0,2,2,2,3,3,3,3,4,6}, 0) ;
		System.out.print(res);
		
	}
}