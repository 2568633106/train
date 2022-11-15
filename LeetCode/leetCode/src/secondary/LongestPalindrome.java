package secondary;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome2("cccabac"));
    }

        public static String longestPalindrome1(String s) {
            int len = s.length(),max=1,begin=0;
            if(len<2){
                return s;
            }

            char[] chars = s.toCharArray();
            boolean[][] booleans = new boolean[len][len];

            for (int i = 0; i < len; i++) {
                booleans[i][i]=true;
            }

            for (int L = 2; L <= len; L++) {
                for (int i = 0; i < len; i++) {
                    int j=L+i-1;
                    if(j>=len){
                        break;
                    }
                    if(chars[i]!=chars[j]){
                        booleans[i][j]=false;
                    }else {
                        if(j-i<3){
                            booleans[i][j]=true;
                        }else{
                            booleans[i][j]=booleans[i+1][j-1];
                        }
                    }
                    if(booleans[i][j]&&j-i+1>max){
                        max=j-i+1;
                        begin=i;
                    }
                }
            }
            return s.substring(begin,max+begin);
        }


    public static String longestPalindrome2(String s) {
        int len = s.length(),max=1,begin=0;
        boolean[][] booleans = new boolean[len][len];
        if(len<2) return s;
        for (int i = 0; i < len; i++) {
            booleans[i][i]=true;
        }

        char[] chars = s.toCharArray();
        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len; i++) {
                int j=L+i-1;
                if(j>=len) break;
                if(chars[i]!=chars[j]){
                    booleans[i][j]=false;
                }else{
                    if(j-i<3){
                        booleans[i][j]=true;
                    }else{
                        booleans[i][j]=booleans[i+1][j-1];
                    }
                }

                if(booleans[i][j]&&j-i+1>max){
                    max=j-i+1;
                    begin=i;
                }
            }
        }

        return s.substring(begin,max+begin);
    }
}
