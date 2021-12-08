package company.continuous1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: hongji
 * @Date: 2021-09-16 17:06
 */
public class Test210916 {

    public static void main(String[] args) {
        List<List<Integer>> a = new ArrayList<>();
        a.add(Arrays.asList(1, 0, 0, 1, 0));
        a.add(Arrays.asList(1, 0, 1));
        a.add(Arrays.asList(0, 0, 1, 0, 1));
        a.add(Arrays.asList(1, 0, 1, 0, 1));
        a.add(Arrays.asList(1, 0, 1, 1));
        maxArea(a);
    }

    public static void maxArea(List<List<Integer>> a) {
        //将list转为二维数组
        Integer[][] arr = new Integer[a.size()][];
        for (int i = 0; i < a.size(); i++) {
            arr[i] = (Integer[]) a.get(i).toArray();
            for (Integer integer : arr[i]) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

        sumNum1(arr);
    }

    public static void sumNum1(Integer[][] arr) {
        int num = 1;
        //统计有多少个1，并且每次把位置上的1替换为num
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    arr[i][j] = num++;
                }
            }
        }
        findMinNumberAndChange(arr);
        HashMap<Integer, Integer> hashMap = countSize(arr);
        System.out.println("共有" + hashMap.keySet().size() + "块连续的1");
    }

    //找到i,j位置的上下左右的值，比较，得到最小值，赋值给上下左右
    public static void findMinNumberAndChange(Integer[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                //找到上下左右的最小值
                if (arr[i][j] != 0) {
                    int min = arr[i][j];
                    //上
                    if (false == (i > 0 && arr[i - 1].length < arr[i].length && j >= arr[i - 1].length)) {
                        if (i > 0 && arr[i - 1][j] != 0) {
                            if (min > arr[i - 1][j]) {
                                min = arr[i - 1][j];
                            }
                        }
                    }
                    //下
                    if (false == (i < arr.length - 1 && arr[i + 1].length < arr[i].length && j >= arr[i + 1].length)) {
                        if (i < arr.length - 1 && arr[i + 1][j] != 0) {
                            if (min > arr[i + 1][j]) {
                                min = arr[i + 1][j];
                            }
                        }
                    }
                    //左
                    if (j > 0 && arr[i][j - 1] != 0) {
                        if (min > arr[i][j - 1]) {
                            min = arr[i][j - 1];
                        }
                    }
                    //右
                    if (j < arr[i].length - 1 && arr[i][j + 1] != 0) {
                        if (min > arr[i][j + 1]) {
                            min = arr[i][j + 1];
                        }
                    }
                    //上下左右都替换为最小值
                    //上
                    if (false == (i > 0 && arr[i - 1].length < arr[i].length && j >= arr[i - 1].length)) {
                        if (i > 0 && arr[i - 1][j] != 0) {
                            arr[i - 1][j] = min;
                        }
                    }
                    //下
                    if (false == (i < arr.length - 1 && arr[i + 1].length < arr[i].length && j >= arr[i + 1].length)) {
                        if (i < arr.length - 1 && arr[i + 1][j] != 0) {
                            arr[i + 1][j] = min;
                        }
                    }
                    //左
                    if (j > 0 && arr[i][j - 1] != 0) {
                        arr[i][j - 1] = min;
                    }
                    //右
                    if (j < arr[i].length - 1 && arr[i][j + 1] != 0) {
                        arr[i][j + 1] = min;
                    }
                }
            }
        }
    }

    //通过hashMap计算连续块的数量，以及连续块存储多少个小块
    public static HashMap<Integer, Integer> countSize(Integer[][] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
                if (arr[i][j] != 0) {
                    if (hashMap.get(arr[i][j]) == null) {
                        hashMap.put(arr[i][j], 1);
                    } else {
                        hashMap.put(arr[i][j], hashMap.get(arr[i][j]) + 1);
                    }
                }
            }
            System.out.println();
        }
        return hashMap;
    }

}
