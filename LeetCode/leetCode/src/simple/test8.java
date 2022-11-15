package simple;

import java.util.Scanner;

public class test8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt(),sum=0;
        String[][] strings = new String[num][3];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 3; j++) {
                strings[i][j]=scanner.next();
            }
        }

        for (int i = 0; i < num-1; i++) {
            String s1 = strings[i][0];
            String s2 = strings[i+1][0];
            int u = Integer.parseInt(strings[i][1]);
            int i1 = Integer.parseInt(strings[i][2]);
            int h1 = Integer.parseInt(s1.split(":")[0]);
            int m1 = Integer.parseInt(s1.split(":")[1]);
            int se1 = Integer.parseInt(s1.split(":")[2]);
            int h2 = Integer.parseInt(s2.split(":")[0]);
            int m2 = Integer.parseInt(s2.split(":")[1]);
            int se2 = Integer.parseInt(s2.split(":")[2]);
            sum+=((h2-h1)*3600+(m2-m1)*60+(se2-se1))*u*i1;
        }

        System.out.println(sum);
    }
}
