package simple;

public class test9 {
    public static void main(String[] args) {
        String str="AAAA" +
                "ALAQ" +
                "ALQQ";
        int sum=0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(i)==str.charAt(j)){
                    int i1=j,i2=j;
                    while (true){
                        if(str.charAt(i)==str.charAt(j)){
                            sum++;
                        }else{
                            break;
                        }
                        i++;j--;
                    }
                }
            }
        }
    }
}
