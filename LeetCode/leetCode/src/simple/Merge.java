package simple;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] num1 = new int[]{0,0,3,0,0,0,0,0,0};
        int[] num2 = new int[]{-1,1,1,1,2,3};
//        merge(num1,num1.length-num2.length,num2,num2.length);
//        merge1(num1,num1.length-num2.length,num2,num2.length);
        merge2(num1,num1.length-num2.length,num2,num2.length);
        System.out.println(Arrays.toString(num1));
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {


        int alen=m+n,j=0;
        for (int i = 0; i < nums1.length; i++) {
            if(j<n&&nums2[j]<nums1[i]){
                for (int k = alen-1; k > i; k--) {
                    nums1[k]=nums1[k-1];
                }
                nums1[i]=nums2[j];
                j++;
            }
        }

        int k=j;
        for (int i = m+k; i < alen; i++) {
            nums1[i]=nums2[j];
            j++;
        }
        return;
    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int j=0;
        for (int i = m ; i < n+m; i++) {
            nums1[i]=nums2[j];
            j++;
        }
        Arrays.sort(nums1);
        return;
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];
        int i=0,j=0;
        int cur=0;
        while (i<m||j<n){
            if(i==m){
                cur=nums2[j++];
            } else if (j == n) {
                cur=nums1[i++];
            }else if(nums1[i]<=nums2[j]){
                cur=nums1[i++];
            } else {
                cur=nums2[j++];
            }
            nums[i+j-1]=cur;
        }

        for (int l = 0; l < m + n; l++) {
            nums1[l]=nums[l];
        }
        return;
    }

    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int l = 0; l < m + n; l++) {
            nums1[l]=sorted[l];
        }
    }
}
