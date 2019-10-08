import java.util.*;
import java.util.stream.Stream;

/*
https://leetcode.com/problems/3sum/
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Note:
The solution set must not contain duplicate triplets.
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        //int[] nums = new int[]{0,0,0,0};
        //int[] nums = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.println(new Solution().threeSum(nums));
    }
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            Set<Integer> numSet = new HashSet<>();
            for (int i=0; i<nums.length; i++) {
                numSet.add(nums[i]);
            }

            Arrays.sort(nums);
            int lastI = nums.length - 2;
            int lastJ = nums.length - 1;

            Set<String> ansSet = new HashSet<>();
            for (int i=0; i<lastI; i++) {
                for (int j=i+1; j<lastJ; j++) {
                    int ii = nums[i];
                    int jj = nums[j];
                    int target = 0 - ii - jj;
                    if (target >= nums[j+1] && numSet.contains(target) && !ansSet.contains(ii+"0"+jj)) {
                        ans.add(new ArrayList<>(Arrays.asList(ii,jj,target)));
                        ansSet.add(ii + "0" + jj);
                    }
                }
            }
            return ans;
        }
    }
}
