package array.easy.two;


//303. 区域和检索 - 数组不可变
//        给定一个整数数组  nums，处理以下类型的多个查询:
//
//        计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
public class NumArray {

    public static void main(String[] args) {
        int[] ints = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(ints);
        System.out.println(numArray.sumRange(0, 5));

    }
    private int[] sums;

//    public NumArray(int[] nums) {
//        int n = nums.length;
//        sums = new int[n + 1];
//        for (int i = 0; i < n; i++) {
//            sums[i + 1] = sums[i] + nums[i];
//        }
//    }
//
//    public int sumRange(int i, int j) {
//        return sums[j + 1] - sums[i];
//    }

    public NumArray(int[] nums) {
        sums=new int[nums.length+1];
        sums[0]=0;
        for (int i = 0; i < nums.length; i++) {
            sums[i+1]=sums[i]+nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return sums[right+1]-sums[left];
    }
}
