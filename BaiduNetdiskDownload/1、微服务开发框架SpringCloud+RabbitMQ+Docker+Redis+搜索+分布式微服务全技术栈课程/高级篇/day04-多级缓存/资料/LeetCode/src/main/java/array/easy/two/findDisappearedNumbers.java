package array.easy.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//448. 找到所有数组中消失的数字
//        给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
//        请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
public class findDisappearedNumbers {
    public static void main(String[] args) {
        int[] arr1 = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(arr1));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int i=nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int j = 0; j < nums.length; j++) {
            set.add(nums[j]);
        }
        ArrayList<Integer> integers = new ArrayList<>();
        for (int j = 1; j <= nums.length; j++) {
            if(!set.contains(j)) integers.add(j);
        }
        return integers;

    }
}
