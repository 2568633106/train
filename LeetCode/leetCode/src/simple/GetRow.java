package simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetRow {
    public static void main(String[] args) {
        int rowIndex = 3;
        getRow(rowIndex);
        System.out.println("111");
    }
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> integers = new ArrayList<>();
        Integer[][] ints = new Integer[rowIndex+1][];
        for (int i = 0; i < rowIndex+1; i++) {
            ints[i]=new Integer[i+1];
            for (int j = 0; j <= i; j++) {
                if(j==0||j==i){
                    ints[i][j]=1;
                }else{
                    ints[i][j]=ints[i-1][j]+ints[i-1][j-1];
                }
                integers.add(ints[i][j]);
            }
        }
        int num=0;
        for (int i = 1; i <= rowIndex; i++) {
            num+=i;
        }
        return integers.subList(num,num+rowIndex+1);
    }
}
