package secondary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Convert {
    public static void main(String[] args) {
        System.out.println(convert3("PAYPALISHIRING", 5));
    }
//    public static String convert(String s, int numRows) {
//        int n = s.length(), r = numRows;
//        if (r == 1 || r >= n) {
//            return s;
//        }
//        int t = r * 2 - 2;//周期
//        int c = (n + t - 1) / t * (r - 1);//矩阵列数
//        char[][] mat = new char[r][c];
//        for (int i = 0, x = 0, y = 0; i < n; ++i) {
//            mat[x][y] = s.charAt(i);
//            if (i % t < r - 1) {
//                ++x; // 向下移动
//            } else {
//                --x;
//                ++y; // 向右上移动
//            }
//        }
//        StringBuffer ans = new StringBuffer();
//        for (char[] row : mat) {
//            for (char ch : row) {
//                if (ch != 0) {
//                    ans.append(ch);
//                }
//            }
//        }
//        return ans.toString();
//    }
//
//    public static String convert2(String s, int numRows) {
//        if(numRows < 2) return s;
//        List<StringBuilder> rows = new ArrayList<StringBuilder>();
//        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
//        int i = 0, flag = -1;
//        for(char c : s.toCharArray()) {
//            rows.get(i).append(c);
//            if(i == 0 || i == numRows -1) flag = - flag;
//            i += flag;
//        }
//        StringBuilder res = new StringBuilder();
//        for(StringBuilder row : rows) res.append(row);
//        return res.toString();
//    }

    public static String convert3(String s, int numRows) {

        int len=s.length(),t=(2*numRows-2),columnRows,k=0,i=0,j=0;
        if(numRows==1){
            return s;
        }
        if(len<t){
            columnRows=len-numRows+1;
        } else if(len/(2*numRows-2)>0){
            columnRows=(len/(2*numRows-2)+1)*(numRows-1);
        }else{
            columnRows=(len/(2*numRows-2))*(numRows-1);
        }
        if(len<numRows){
            return s;
        }
        Character[][] arr = new Character[numRows][columnRows];
        while (len>k){
            arr[i][j]=s.charAt(k);
            k++;
            if(k%t==0){
                j++;
                i--;
            }else if(k%t<numRows){
                i++;
            }else{
                j++;
                i--;
            }
        }

        String str="";
        for (int l = 0; l < numRows; l++) {
            for (int m = 0; m < columnRows; m++) {
                if(arr[l][m]!=null){
                    str+=arr[l][m];
                }
            }
        }
        return str;
    }


}
