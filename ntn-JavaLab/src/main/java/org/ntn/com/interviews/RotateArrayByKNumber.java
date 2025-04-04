package org.ntn.com.interviews;

import java.util.Arrays;

public class RotateArrayByKNumber {

    public static void main(String[] args) {

        int[] numbers = new int[]{1,2,3,4,5,6,7};
        int k=5;
        // 5,6,7,1,2,3,4

        rotate(numbers,k);


    }

    private static void rotate(int[] nums , int k){

        k = k % nums.length;

        reverse(nums, 0 , nums.length-1);
        Arrays.stream(nums).forEach(value -> System.out.print(" "+value));

        reverse(nums,0, k-1);
        System.out.println();
        Arrays.stream(nums).forEach(value -> System.out.print(" "+value));

        reverse(nums ,k , nums.length-1);
        System.out.println();
        Arrays.stream(nums).forEach(value -> System.out.print(" "+value));

    }

    private static void reverse(int[] nums , int start ,int end){

        while(start < end){

            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] =temp;

            start++;
            end--;
        }
    }
}
