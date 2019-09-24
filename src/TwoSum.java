import java.util.*;

//https://leetcode.com/problems/two-sum/
/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class TwoSum {
    public static void main(String[] args) {
//        int[] nums = new int[]{2,7,11,15};
//        int target = 9;
//        int[] nums = new int[]{2,5,5,11};
//        int target = 10;
        int[] nums = new int[]{3,2,4};
        int target = 6;
        int[] result = new Solution().twoSum(nums, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        boolean possibleEven = false;
        boolean hasHalf = false;
        int half = -1;
        if(target%2==0){
            half = target/2;
            possibleEven = true;
        }
        Map<Integer, Integer> numValueKey = new HashMap<>();
        Set<Integer> valueSet = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            if(possibleEven && nums[i]==half){
               if (hasHalf) return new int[]{numValueKey.get(half), i};
               else hasHalf = true;
            }
            numValueKey.put(nums[i], i);
            valueSet.add(nums[i]);
        }
        for(Integer value : valueSet) {
            int pair = target - value;
            if (valueSet.contains(pair)) {
                int ans1 = numValueKey.get(value);
                int ans2 = numValueKey.get(pair);
                return ans1<ans2? new int[]{ans1, ans2} : new int[]{ans2, ans1};
            }
        }
        return null;
    }
}
