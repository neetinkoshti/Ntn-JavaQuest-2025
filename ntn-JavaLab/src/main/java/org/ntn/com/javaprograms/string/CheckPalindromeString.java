package org.ntn.com.javaprograms.string;

public class CheckPalindromeString {


    public static void main(String[] args) {

        String str = "A man, a plan, a canal:Panama";
        String str1 = "Nitin";

        System.out.println(checkPolindrome(str1));

    }

    private static boolean checkPolindrome(String str) {

        String origianlStr = str.toLowerCase().replaceAll(" ","").replaceAll(",","").replaceAll(":","");
        System.out.println("Original String:"+origianlStr);
        String reversedString = reverseAString(origianlStr);

        System.out.println(reversedString);

        return origianlStr.equalsIgnoreCase(reversedString);
    }

    private static String reverseAString(String str) {
        StringBuilder builder = new StringBuilder();

        for(int i = str.length()-1 ;i >= 0 ;i--){
            builder.append(str.charAt(i));
        }
        return builder.toString();

    }
}
