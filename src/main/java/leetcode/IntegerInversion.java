package leetcode;

import java.util.LinkedList;

/**
 * @Author: hongji
 * @Date: 2020-08-19 14:01
 */
public class IntegerInversion {

    public static Integer getIntegerInversion(int x){
        double reverse;
        boolean flag = false;
        if(x<0){
           flag = true;
           if(x<=Integer.MIN_VALUE|| x>=Integer.MAX_VALUE){
               return 0;
           }
        }
        String a = String.valueOf(Math.abs(x));
        StringBuilder str = new StringBuilder(a);

        String reverseStr = str.reverse().toString();
        if(flag){
            reverseStr = "-"+reverseStr;
        }
        reverse = Double.parseDouble(reverseStr);

        if(reverse>Integer.MAX_VALUE || reverse<Integer.MIN_VALUE){
            return 0;
        }
        return (int)reverse;
    }
    public static void main(String[] args) {
        int result = getIntegerInversion(-2147483648);
        System.out.println(result);
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
    }
}
