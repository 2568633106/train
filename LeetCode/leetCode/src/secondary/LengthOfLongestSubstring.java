package secondary;

import java.util.HashSet;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();
        int ans=0,right=0;
        for (int i = 0; i < s.length(); i++) {
            if(i!=0){
                set.remove(s.charAt(i-1));
            }
            while (right<s.length()&&!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }
            ans=right-i>ans?right-i:ans;
        }

        return ans;
    }
}
