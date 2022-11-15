package simple;

import java.util.Scanner;

public class test6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i1 = scanner.nextInt();
        int i2 = scanner.nextInt();
        if(i1>i2)
        System.out.println(i1-i2+1);
        else
            System.out.println(i2-i1);
    }
}
