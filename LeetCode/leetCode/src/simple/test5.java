package simple;

public class test5 {
    public static void main(String[] args) {
        int[][] ints = new int[101][101];
        for (int i = 1; i <=100; i++) {
            for (int j = 1; j <=100; j++) {
                ints[i][j]=i+(j-1)*2;
            }
        }

        int sum=0,num=0;
        for (int i = 100,j=100; i >= 1 ; i--, j--) {
            for (int k = 100; k >= i; k--) {

            }

        }
    }
}
