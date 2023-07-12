package array.easy.two;

import java.util.*;


//496. 下一个更大元素 I
//        nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
//
//        给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
//
//        对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，
//        并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
//
//        返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
//方法二：单调栈解法


public class nextGreaterElement {
    public static void main(String[] args) {
        int[] arr1 = {4,1,2};
        int[] arr2 = {1,3,4,2};

        System.out.println(Arrays.toString(nextGreaterElement(arr1, arr2)));
    }

//    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        Deque<Integer> stack = new ArrayDeque<Integer>();
//        for (int i = nums2.length - 1; i >= 0; --i) {
//            int num = nums2[i];
//            while (!stack.isEmpty() && num >= stack.peek()) {
//                stack.pop();
//            }
//            map.put(num, stack.isEmpty() ? -1 : stack.peek());
//            stack.push(num);
//        }
//        int[] res = new int[nums1.length];
//        for (int i = 0; i < nums1.length; ++i) {
//            res[i] = map.get(nums1[i]);
//        }
//        return res;
//    }


    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int p=0;
        int[] ints = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if(j+1>= nums2.length) ints[p++]=-1;
                else if (nums1[i]==nums2[j]){
                    while (j+1< nums2.length&&nums2[j+1]<=nums1[i]){
                        j++;
                    }
                    if(j+1< nums2.length){
                        ints[p++]=nums2[j+1];
                    }else {
                        ints[p++]=-1;
                    }
                    break;
                }
            }
        }
        return ints;
    }
}
