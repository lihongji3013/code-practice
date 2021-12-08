package leetcode;

/**
 * @Author: hongji
 * @Date: 2020-08-20 14:56
 */
public class PalindromeInteger {
    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(x));
        return stringBuilder.reverse().toString().equals(String.valueOf(x));
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
