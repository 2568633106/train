package simple;

import java.util.Scanner;

public class test7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        for (int i = 0; i < str.length(); i++) {
                str=str.replace('a','A')
                .replace('e','E')
                .replace('i','I')
                .replace('o','O')
                .replace('u','U');
        }
        System.out.println(str);
    }
}
