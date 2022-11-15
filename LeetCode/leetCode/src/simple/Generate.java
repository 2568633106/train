package simple;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generate {
    public static void main(String[] args) {
        generate(5);
    }

    public static List<List<Integer>> generate(int numRows) {
        Integer[][] array = new Integer[numRows][];
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int j = 0; j < array.length; j++) {
            Integer[] ints = new Integer[j + 1];
            array[j]=ints;
            for (int i = 0; i <= j; i++) {
                if (i==0||j==i){
                    array[j][i]=1;
                }else{
                    array[j][i]=array[j-1][i-1]+array[j-1][i];
                }
            }
            lists.add(Arrays.asList(array[j]));
        }

        return lists;

    }
}
