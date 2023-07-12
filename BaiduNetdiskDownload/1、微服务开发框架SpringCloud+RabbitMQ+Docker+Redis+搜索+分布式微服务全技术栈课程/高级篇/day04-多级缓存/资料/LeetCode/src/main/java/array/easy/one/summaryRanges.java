package array.easy.one;

import java.util.ArrayList;
import java.util.List;

//228. 汇总区间
//返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，
// nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
//
//        列表中的每个区间范围 [a,b] 应该按如下格式输出：
//
//        "a->b" ，如果 a != b
//        "a" ，如果 a == b
public class summaryRanges {
    public static void main(String[] args) {
        int[] arr = {0,1,2,4,5,7};
        System.out.println(summaryRanges(arr));
    }
    public static List<String> summaryRanges(int[] nums) {
        int flag=0;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i+1>=nums.length||nums[i]!=nums[i+1]-1){
                String str=nums[flag]==nums[i]?nums[flag]+"":nums[flag]+"->"+nums[i];
                list.add(str);
                flag=i+1;
            }else {
                continue;
            }
        }
        return list;
    }
}
