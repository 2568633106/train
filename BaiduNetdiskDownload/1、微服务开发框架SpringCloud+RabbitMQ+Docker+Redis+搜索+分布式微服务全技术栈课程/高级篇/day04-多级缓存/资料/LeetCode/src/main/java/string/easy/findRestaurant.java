package string.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//效率不高，原因：不知道hash表的clear方法清除所有表中数据
//599. 两个列表的最小索引总和
//        假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
//
//        你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。
//        你可以假设答案总是存在。


public class findRestaurant {
    public static void main(String[] args) {
        String[] arr1 = {"S","TEXP","BK","KFC"};
        String[] arr2 = {"KFC","BK","S"};
        System.out.println(Arrays.toString(findRestaurant(arr1,arr2)));
    }
    public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        int min=Integer.MAX_VALUE,flag=1;
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i],i);
        }
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])&&min>=i+Integer.parseInt(map.get(list2[i]).toString())) {
                if (min==i+Integer.parseInt(map.get(list2[i]).toString())){
                    flag++;
                }else {
                    flag=1;
                }
                ans.add(list2[i]);
                min=i+Integer.parseInt(map.get(list2[i]).toString());
            }
        }
        int j=1;
        String[] strings = new String[flag];
        for (int i = 0; i < flag; i++) {
            strings[i]=ans.get(ans.size()-j);
            j++;
        }
        return strings;
    }
}
