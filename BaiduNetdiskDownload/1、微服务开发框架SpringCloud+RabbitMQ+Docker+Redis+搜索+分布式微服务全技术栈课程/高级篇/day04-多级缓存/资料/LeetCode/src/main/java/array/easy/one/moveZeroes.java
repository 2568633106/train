package array.easy.one;

import java.util.Arrays;


//283. 移动零
//        给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
//        请注意 ，必须在不复制数组的情况下原地对数组进行操作。
//法二：双指针
//public void moveZeroes(int[] nums) {
//        int indexNow = 0;
//        int indexNum = 0;
//        int m = nums.length;
//
//        while(indexNum<m){
//        if(nums[indexNum] != 0) {
//        nums[indexNow++] = nums[indexNum];
//        }
//        ++indexNum;
//        }
//
//        for(int i = indexNow; i < m; i++){
//        nums[i] = 0;
//        }
//        }
public class moveZeroes {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        moveZeroes(arr);
    }

    public static void moveZeroes(int[] nums) {
        int flag=0;
        for (int i = nums.length-1; i >= 0 ; i--) {
            if(nums[i]==0){
                flag++;
                for (int j = i; j < nums.length-1; j++) {
                    nums[j]=nums[j+1];
                }
                nums[nums.length-flag]=0;
            }
        }
        return;
    }
}
