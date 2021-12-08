package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: hongji
 * @Date: 2019-10-18 16:41
 */
public class chaji {
    public static void main(String[] args) {
        String str1 = "adbbc";
        String str2 = "ac";
        System.out.println(chaji.chaji2(str1, str2));
        int[] num = {9, -5, 3, -8, 11};
        System.out.println(maxSubArray(num));
    }

    //数组O(n2)
    public static String chaji1(String str1, String str2) {
        String result = null;

        String longStr = str1;
        String shortStr = str2;
        if (str2.length() > str1.length()) {
            longStr = str2;
            shortStr = str1;
        }

        List<Character> list1 = new ArrayList<Character>();

        for (int i = 0; i < longStr.length(); i++) {
            char c = longStr.charAt(i);
            list1.add(c);
        }
        List<Character> list2 = new ArrayList<Character>();

        for (int i = 0; i < shortStr.length(); i++) {
            char c = shortStr.charAt(i);
            list2.add(c);
        }
        System.out.println(list1.toString());
        System.out.println(list2.toString());

        for (int i = 0; i < list2.size(); i++) {
            if (list1.contains(list2.get(i)))
                list1.remove(list2.get(i));
        }
        String str = "";
        for (int i = 0; i < list1.size(); i++) {
            str = str + list1.get(i);
        }
        return str;
    }

    // O(n)
    static String chaji2(String str1, String str2) {

        Map<Character, Integer> map = new HashMap();
        List list = new ArrayList();
        for (int i = 0; i < str1.length(); i++) {
            if (map.get(str1.charAt(i)) == null){
                map.put(str1.charAt(i), 1);
                System.out.println("1:"+map);
            }else{
                map.put(str1.charAt(i), map.get(str1.charAt(i)) + 1);
                System.out.println("2:"+map);
            }

        }
        System.out.println("3:"+map);
        for (int i = 0; i < str2.length(); i++) {

            if (map.get(str2.charAt(i)) != null)
                map.put(str2.charAt(i), map.get(str2.charAt(i)) - 1);

        }
        String str = "";
        System.out.println("4:"+map);
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            int n = e.getValue();
            for (int i = 0; i < n; i++)
                str += e.getKey();
        }

        return str;
    }
    //最大子数组
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }

}
