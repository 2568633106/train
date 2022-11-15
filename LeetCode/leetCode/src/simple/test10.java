package simple;

public class test10 {
    public static void main(String[] args) {
        String str="DCBA";
        StringBuffer stringBuffer = new StringBuffer(str);
        String[] strings = {"A", "B", "C", "D", "E", "F"};
        String str1="";
        int sum=0,min=0;
        int index=0;
        for (int i = 0; i < str.length(); i++) {
            str1="";
            str1+=str.charAt(i);
            sum=0;
            for (int j = 0; j < 1000; j++) {
                int i1 = stringBuffer.indexOf(str1.charAt(j) + "");
                if((str1.charAt(j)+"").equals("A")) index=1;
                if((str1.charAt(j)+"").equals("B")) index=2;
                if((str1.charAt(j)+"").equals("C")) index=3;
                if((str1.charAt(j)+"").equals("D")) index=4;
                if((str1.charAt(j)+"").equals("E")) index=5;
                if(str1.equals("F")) index=6;
                str1+=str.charAt((i1+index)%str.length());
                sum++;
            }
            if(sum<min){
                min=sum;
            }
        }
        System.out.println(min);

    }
}
