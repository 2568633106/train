package simple;

public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }
    public static boolean isPalindrome(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if(Character.isLetterOrDigit(s.charAt(i))){
                stringBuffer.append(s.charAt(i));
            }
        }

        int j=stringBuffer.length()-1;
        for (int i = 0; i < stringBuffer.length()/2; i++) {
            char c1 = Character.toLowerCase(stringBuffer.charAt(j));
            char c2 = Character.toLowerCase(stringBuffer.charAt(i));
            if(Character.isLetterOrDigit(c1)&&Character.isLetterOrDigit(c2)&&c2!=c1){
                return false;
            }
            j--;
        }
        return true;
    }
}
