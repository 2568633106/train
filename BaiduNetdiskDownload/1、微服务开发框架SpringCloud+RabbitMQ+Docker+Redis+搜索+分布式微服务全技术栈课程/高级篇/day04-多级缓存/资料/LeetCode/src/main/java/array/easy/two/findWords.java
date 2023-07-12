package array.easy.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Stream;


//500. 键盘行
//        给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
//
//        美式键盘 中：
//
//        第一行由字符 "qwertyuiop" 组成。
//        第二行由字符 "asdfghjkl" 组成。
//        第三行由字符 "zxcvbnm" 组成。
public class findWords {
    public static void main(String[] args) {
        String[] arr2 = {"Hello","Alaska","Dad","Peace"};

        System.out.println(Arrays.toString(findWords(arr2)));
    }

    public static String[] findWords(String[] words) {
        String str1="qwertyuiop";
        String str2="asdfghjkl";
        String str3="zxcvbnm";
        int p=0;
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        HashSet<Character> set3 = new HashSet<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str1.length(); i++) {
            set1.add(str1.charAt(i));
        }
        for (int i = 0; i < str2.length(); i++) {
            set2.add(str2.charAt(i));
        }
        for (int i = 0; i < str3.length(); i++) {
            set3.add(str3.charAt(i));
        }


        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String str="";
            str=words[i].toLowerCase();
            for (int j = 0; j <str.length(); j++) {
                set.add(str.charAt(j));
            }
            if(set1.containsAll(set)||set2.containsAll(set)||set3.containsAll(set)){
                list.add(words[i]);
            }
            set.clear();
        }
        String[] strings = list.toArray(new String[]{});
        return strings;
    }
}
