package org.ntn.com.javaprograms.string;

import java.util.Arrays;

public class CheckAnagramString {

    public static void main(String[] args) {

        String str1 = "CAT";
        String str2 = "ACT";

        System.out.println(checkAnagram1(str1,str2));
        System.out.println(checkAnagram(str1,str2));

    }

    private static boolean checkAnagram1(String str1, String str2){

        System.out.println("checking using Stream and count");

        if(str1.length() != str2.length()){
            return false;
        }

       long countOfCharInString2 = Arrays.stream(str1.split(""))
                .filter(ch-> str2.contains(ch))
               .distinct()
                .count();

        if(countOfCharInString2 == str1.length()){
            return true;
        }

        return false;
    }


    private static boolean checkAnagram(String str1 , String str2){

        System.out.println("Check Anagram Using Arrays.sort");

        if(str1.length() != str2.length()){
            return false;
        }

        char[] str1CharArray = str1.toCharArray();
        char[] str2CharArray = str2.toCharArray();

        Arrays.sort(str1CharArray);
        Arrays.sort(str2CharArray);

        return Arrays.equals(str1CharArray , str2CharArray);
    }



}
