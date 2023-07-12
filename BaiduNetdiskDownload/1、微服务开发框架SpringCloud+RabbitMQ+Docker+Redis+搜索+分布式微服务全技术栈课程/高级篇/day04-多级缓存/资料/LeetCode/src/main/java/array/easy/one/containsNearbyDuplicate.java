package array.easy.one;

//219. 存在重复元素 II
//给你一个整数数组nums 和一个整数k ，判断数组中是否存在两个 不同的索引i和j ，
//        满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。


public class containsNearbyDuplicate {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,2,3};
        int k=2;
        System.out.println(containsNearbyDuplicate(arr, k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <= i+k; j++) {
            if (j>nums.length-1) break;
                if(nums[i]==nums[j])
                    return true;
           }
        }
        return false;
    }
}
