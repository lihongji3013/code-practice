package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hongji
 * @Date: 2020-05-06 16:06
 */

public class ConvertString2Z {
    public static String convert(int num,String s) {
        if(num<2|| s.equals(null)){
            return s;
        }
        String[] strs = s.split("");
        List<StringBuilder> builderList = new ArrayList<>();
        int flag = -1;
        int currentRow = 0;
        for (int i = 0; i<num; i++){
            builderList.add(new StringBuilder());
        }
        for (int i=0;i<strs.length;i++){
            builderList.get(currentRow).append(strs[i]);
            if(currentRow==0||currentRow==num-1){
                flag = -flag;
            }
            currentRow+=flag;


        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : builderList) {
            res.append(row);
        }
        return res.toString();
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");list.add("b");list.add("c");list.add("d");list.add("e");list.add("f");list.add("g");
        System.out.println(list.subList(0,3));
        System.out.println(ConvertString2Z.convert(4,"LEETCODEISHIRING"));

    }
}
