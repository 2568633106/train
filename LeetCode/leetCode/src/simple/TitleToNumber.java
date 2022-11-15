package simple;

public class TitleToNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));
    }
    public static int titleToNumber(String columnTitle) {
        int length = columnTitle.length();
        int mul = length - 1,sum=0,num=1;
        for (int i = 0; i < length; i++) {
            for (int j = mul; j >0; j--) {
                num*=26;
            }
            sum += (columnTitle.charAt(i) - 64) * num;
            mul--;
            num=1;
        }
        return sum;
    }

}
