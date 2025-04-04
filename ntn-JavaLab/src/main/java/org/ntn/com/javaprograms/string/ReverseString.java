package org.ntn.com.javaprograms.string;

import java.util.*;
import java.util.stream.Collectors;

public class ReverseString {

    public static void main(String[] args) {

        String str = "java is a programming lang";

        reverseStringUsingLoop(str);

        reverseStringBySwapingChar(str);

        reverseStringByBuiltInMethodOfStringBuilder(str);

        System.out.println("Using recursive method : ");
        usingRecursive(str);

        reverseStringUsingCollectionsReverse(str);

        reverseStringUsingStringJoiner(str);

        reverseStringUsingDeque(str);

    }

    private static void reverseStringUsingDeque(String str) {

        Deque<String> deque = new ArrayDeque<>();
        for(int i = 0 ;i<= str.length()-1 ;i++){
            deque.push(String.valueOf(str.charAt(i)));
        }
        StringBuilder reverseString = new StringBuilder();

        while(!deque.isEmpty()){
            reverseString.append(deque.pop());
        }

        System.out.println("by Deque: "+reverseString);

    }

    private static void reverseStringUsingStringJoiner(String str) {
        StringJoiner stringJoiner = new StringJoiner("");
        for(int i = str.length()-1; i >= 0 ; i--){
            stringJoiner.add(String.valueOf(str.charAt(i)));
        }
        System.out.println("by String joiner: "+stringJoiner);
    }

    private static void reverseStringUsingCollectionsReverse(String str) {
        List<String> list = Arrays.asList(str.split(""));
        Collections.reverse(list);
        System.out.println("\n by CollectionReverse : "+list.stream().collect(Collectors.joining()));
    }

    private static void usingRecursive(String str){

        if(str.length() ==1){
            System.out.print(str);
        }else{
            System.out.print(str.substring(str.length()-1));
            usingRecursive(str.substring(0,str.length()-1));
        }


    }

    private static void reverseStringByBuiltInMethodOfStringBuilder(String str) {
        StringBuilder sb = new StringBuilder(str);
        String reverseString = sb.reverse().toString();
        System.out.println("by StringBuilder built-in method :"+reverseString);
    }

    private static void reverseStringUsingLoop(String originalString){
        StringBuilder reverseString = new StringBuilder();
        for(int i = originalString.length()-1 ; i>=0 ; i--){
            reverseString.append(originalString.charAt(i));
        }
        System.out.println("By Loop: "+reverseString.toString());
    }

    private static void reverseStringBySwapingChar(String originalString){

        char[] chArray = originalString.toCharArray();
        for(int i=0 , j = chArray.length-1 ; i< j ;i++ ,j--){

            char ch = chArray[i];
            chArray[i] = chArray[j];
            chArray[j] =ch;
        }
        System.out.println("By Swap: "+String.valueOf(chArray));

    }
}
