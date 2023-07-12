package array.easy.two;

import java.util.*;

//349. 两个数组的交集
//        给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
public class intersection {
    public static void main(String[] args) {
        int[] arr1 = {4,7,9,7,6,7};
        int[] arr2 = {5,0,0,6,1,6,2,2,4};
        System.out.println(Arrays.toString(intersection(arr1, arr2)));
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        int l1=nums1.length,l2=nums2.length;
        int l= Math.max(l1, l2);
        for (int i = 0; i < l; i++) {
            if(i<l1)set1.add(nums1[i]);
            if(i<l2)set2.add(nums2[i]);
        }
        Integer[] s2 = set2.toArray(new Integer[]{});
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < s2.length; i++) {
            if (!set1.add(s2[i])){
                set.add(s2[i]);
            }
        }
        Integer[] ints = set.toArray(new Integer[]{});
        int[] arr = new int[ints.length];
        for (int i = 0; i < ints.length; i++) {
            arr[i]=ints[i];
        }
        return arr;
    }
}
