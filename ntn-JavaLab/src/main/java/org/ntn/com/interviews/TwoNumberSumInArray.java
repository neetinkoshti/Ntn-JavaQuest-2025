package org.ntn.com.interviews;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoNumberSumInArray {

    public static void main(String[] args) {

        int[] array = new int[]{2,5,4,3,1,6};
        int total = 7;

        usingBySetMethod(array, total);

        usingByMapMethod(array,total);

    }

    private static void usingByMapMethod(int[] array, int total) {
        Map<Integer,Integer> map = new HashMap<>();

        System.out.println("Two numbers sum using MAP method");
        for(int i=0;i<=array.length-1 ;i++){

            int secondNum = total - array[i];
            if(map.containsKey(secondNum)){
                System.out.println("Numbers which sum equals to Target :"+total + "("+array[i]+","+secondNum+") and its index : ("+i +","+map.get(secondNum)+")" );
            }else{
                map.put(array[i], i);
            }
        }
    }

    private static void usingBySetMethod(int[] array, int total) {
        Set<Integer> set = new HashSet<>();
        System.out.println("Two numbers sum using Set method");
        for (int num : array) {

            int secondNum = total - num;
            if (set.contains(secondNum)) {
                System.out.println("Numbers which sums equals to target :" + total + " (" + num + "," + secondNum + ")");
            } else {
                set.add(num);
            }
        }
    }
}
