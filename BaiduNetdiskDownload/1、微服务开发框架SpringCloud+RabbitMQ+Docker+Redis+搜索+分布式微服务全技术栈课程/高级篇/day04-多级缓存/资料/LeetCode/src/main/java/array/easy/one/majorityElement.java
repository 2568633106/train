package array.easy.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
//169. 多数元素
//给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
//        你可以假设数组是非空的，并且给定的数组总是存在多数元素。
public class majorityElement {
    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr));
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else {
                Integer num = map.get(nums[i]);
                map.replace(nums[i],++num);
            }
        }
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,(o1,o2)->(o2.getValue()-o1.getValue()));
        return list.get(0).getKey();

    }
}
