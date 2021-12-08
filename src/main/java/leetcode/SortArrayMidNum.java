package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: hongji
 * @Date: 2019-10-18 18:23
 */
public class SortArrayMidNum {

    //给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
       if(s.length()!=0){
           char[] chs = s.toCharArray();
           for(int i=0;i<chs.length;i++){
               StringBuilder ss = new StringBuilder();
               for (int j=i;j<chs.length;j++){
                   String chstr = String.valueOf(chs[j]);
                   if(!ss.toString().contains(chstr)){
                       ss.append(chstr);
                       if(max<ss.length()){
                           max = ss.length();
                       }
                   }else {
                       break;
                   }
               }
           }
       }
        return max;
    }
    //寻找两个有序数组的中位数
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        if(nums1!=null){
            for(int num1:nums1){
                list.add(num1);
            }
        }
        if(nums2!=null){
            for (int num2:nums2){
                list.add(num2);
            }
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        if(list.size()%2==0){
            double midStart = list.get(list.size()/2-1);
            double midEnd = list.get((list.size()/2));
            return (midStart+midEnd)/2;
        }else {
            Integer midIndex = list.size()/2;
            return list.get(midIndex);
        }
    }
    public static void main(String[] args) {
        int[] nums1 = {1,4,6};
        int[] nums2 = {2};
        System.out.println(5/2);
        System.out.println(findMedianSortedArrays(nums1,nums2));
        System.out.println(lengthOfLongestSubstring("abd3dch"));
    }
}
