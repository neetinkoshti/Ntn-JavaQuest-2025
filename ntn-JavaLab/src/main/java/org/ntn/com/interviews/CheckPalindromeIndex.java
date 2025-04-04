package org.ntn.com.interviews;

public class CheckPalindromeIndex {

    public static void main(String[] args) {

        String str = "nitinb";

        System.out.println(checkPalindromeIndex(str));

    }

    private static int checkPalindromeIndex(String str) {

        int firstIndex = 0;
        int lastIndex = str.length();

        boolean isPalindrome = checkPalindromeString(str);
        System.out.println(isPalindrome);

        if(isPalindrome){
            return -1;
        }else if(checkPalindromeString(str.substring(firstIndex+1 , lastIndex))){
            System.out.println("remove "+firstIndex+" index to made string as palindrome");
            return firstIndex;
        }else if(checkPalindromeString(str.substring(firstIndex,lastIndex-1))){
            System.out.println("remove "+lastIndex+" index to made string as palindrome");
            return lastIndex;
        }
        return 0;
    }

    private static boolean checkPalindromeString(String str){

        int length = str.length();
        int mid = length/2;

        for(int i=0 , j = length ; i < mid ;i++ , j--){

            if(str.charAt(i) != str.charAt(j-1)){
                return false;
            }
        }

        return true;
    }
}
