package array.easy.one;

import java.util.Arrays;
import java.util.HashSet;

//268. 丢失的数字
//        给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
public class missingNumber {
    public static void main(String[] args) {
        int[] arr = {0,1};
        System.out.println(missingNumber(arr));
    }
    public static int missingNumber(int[] nums) {
        int n=nums.length;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; i <= n; i++) {
            if (set.add(i)) {
                return i;
            }
        }
        return -1;
    }
}
