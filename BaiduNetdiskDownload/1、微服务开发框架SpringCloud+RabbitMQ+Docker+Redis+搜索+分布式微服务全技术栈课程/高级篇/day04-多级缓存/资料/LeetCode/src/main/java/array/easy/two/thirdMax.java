package array.easy.two;

import java.util.* ;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//414. 第三大的数
//        给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
public class thirdMax {
    public static void main(String[] args) {
        int[] arr1 = {2,1};
        System.out.println(thirdMax(arr1));
    }
    public static int thirdMax(int[] nums) {
            IntStream stream = Arrays.stream(nums);
            Stream<Integer> st = stream.boxed();
            Integer[] arr = st.toArray(Integer[]::new);
            Set<Integer> set = Arrays.stream(arr).collect(Collectors.toSet());//适用于JDK>=1.8
            Integer[] integers = set.toArray(new Integer[]{});
            Arrays.sort(integers);
            int result=integers.length<3? integers.length-1: integers.length-3;
            return integers[result];
    }
}
