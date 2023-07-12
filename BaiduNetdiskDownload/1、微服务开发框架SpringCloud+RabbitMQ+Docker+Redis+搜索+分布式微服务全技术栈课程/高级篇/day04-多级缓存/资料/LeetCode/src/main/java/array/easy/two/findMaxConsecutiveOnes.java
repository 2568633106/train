package array.easy.two;


//485. 最大连续 1 的个数
//        给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
public class findMaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max=0,num=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==1) num++;
            else{
                max=Math.max(num,max);
                num=0;
            }
        }
        return Math.max(num,max);
    }
}
