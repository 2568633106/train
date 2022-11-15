package simple;

import java.util.HashMap;

public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,1}));
    }
    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count=1;
        for (int i = 0; i < nums.length; i++) {
            count=1;
            if(map.containsKey(nums[i])){
                count++;
            }
            map.put(nums[i],count);
        }
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i])==1){
                return nums[i];
            }
        }
        return -1;
    }
}
