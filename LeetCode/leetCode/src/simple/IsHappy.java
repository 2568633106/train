package simple;

import java.util.HashSet;

public class IsHappy {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        HashSet<Integer> integers = new HashSet<>();
        return isHappy2(n+"",integers)==1;
    }
    public static int isHappy2(String n,HashSet<Integer> hash) {

        int sum=0;
        for (int i = 0; i < n.length(); i++) {
            sum+=Integer.parseInt(n.charAt(i)+"")*Integer.parseInt(n.charAt(i)+"");
        }
        if(hash.contains(sum)){
            return -1;
        }else
        hash.add(sum);

        if(sum==1) return 1;
        else{
            return isHappy2(sum+"",hash);
        }
    }
}
