/*
 * Runtime: 2 ms, faster than 99.97% of Java online submissions for Median of Two Sorted Arrays.
 * Memory Usage: 47.2 MB, less than 84.72% of Java online submissions for Median of Two Sorted Arrays.`
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        double result = new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalSize = nums1.length + nums2.length;
        boolean isEven = totalSize%2 == 0;
        boolean nums1NotEmpty = nums1.length != 0;
        boolean nums2NotEmpty = nums2.length != 0 ;
        int medianIndex = totalSize / 2;
        int targetIndex = -1;
        int targetValue = 0;
        int i = 0, j = 0;
        while (++targetIndex < medianIndex) {
            if (nums1NotEmpty && nums2NotEmpty) {
                if (nums1[i] < nums2[j]) {
                    targetValue = nums1[i];
                    i++;
                    if (i==nums1.length) nums1NotEmpty = false;
                } else {
                    targetValue = nums2[j];
                    j++;
                    if (j==nums2.length) nums2NotEmpty = false;
                }
            } else if (nums1NotEmpty){
                targetValue = nums1[i];
                i++;
                if (i==nums1.length) nums1NotEmpty = false;

            } else if (nums2NotEmpty){
                targetValue = nums2[j];
                j++;
                if (j==nums2.length) nums2NotEmpty = false;
            }
        }
        int nextTarget = 0;
        if (nums1NotEmpty && nums2NotEmpty) {
            nextTarget = Math.min(nums1[i], nums2[j]);
        } else
            nextTarget = nums1NotEmpty ? nums1[i] : nums2[j];

//        System.out.println("targetValue = " + targetValue);
//        System.out.println("nextTarget = " + nextTarget);
        if (isEven) {
            return (double)(targetValue + nextTarget)/2;
        } else {
            return nextTarget;
        }
    }
}
