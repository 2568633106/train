package simple;

public class ClimbStairs {
    public static void main(String[] args) {
        int n=3;
        int[] ints = new int[n+1];
        System.out.println(climbStairs3(n));
    }

    static int climbStairs1(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        return climbStairs1(n-1)+climbStairs1(n-2);
    }

    static int climbStairs2(int n,int[] arr) {
        if(arr[n]>0) return arr[n];
        if(n==1) arr[n]= 1;
        else if(n==2) arr[n]= 2;
        else arr[n]= climbStairs2(n-1,arr)+climbStairs2(n-2,arr);
        return arr[n];
    }

    static int climbStairs3(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        int[] ints = new int[n+1];
        ints[1] = 1;
        ints[2] = 2;
        for (int i = 3; i <= n; i++) {
            ints[i] = ints[i-1]+ints[i-2];
        }
        return ints[n];
    }
}
