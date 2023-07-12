package array.easy.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

//350. 两个数组的交集 II
//        给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，
//        应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
//第二种方法：
//双指针(可以先排序为有序数组)

public class intersect {
    public static void main(String[] args) {
        int[] arr1 = {4,9,5};
        int[] arr2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersect(arr1, arr2)));
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if(!map1.containsKey(nums1[i])){
                map1.put(nums1[i],1);
            }else{
                map1.put(nums1[i],(map1.get(nums1[i])+1));
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if(!map2.containsKey(nums2[i])){
                map2.put(nums2[i],1);
            }else{
                map2.put(nums2[i],(map2.get(nums2[i])+1));
            }
        }
        int l=Math.max(nums1.length,nums2.length),p=0;
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer key : map1.keySet()) {
            if(map2.containsKey(key)){
                Integer rkey = map2.get(key);
                if (map2.get(key)>0){
                    if(map1.get(key)>rkey){
                        for (int i = 0; i < rkey; i++) {
                            list.add(key);
                        }
                    }else{
                        for (int i = 0; i < map1.get(key); i++) {
                            list.add(key);
                        }
                    }
                }
            }
        }
        Integer[] arr = list.toArray(new Integer[]{});
        int[] ints = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ints[i]= arr[i];
        }
        return ints;
    }
}
