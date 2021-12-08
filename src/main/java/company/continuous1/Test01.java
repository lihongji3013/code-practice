package company.continuous1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:
 * @Date: 2021-06-30 09:37
 * 错误答案，未考虑左右连续
 */
public class Test01 {
    private static int dfs(List<List<Integer>> a, int i, int j) {
        int num = 1;
        a.get(i).set(j, 0);
        // 上面
        if (i > 0 && j <= a.get(i - 1).size() - 1 && a.get(i - 1).get(j) == 1) {
            num += dfs(a, i - 1, j);
        }
        // 下面
        if (i < a.size() - 1 && j <= a.get(i + 1).size() - 1 && a.get(i + 1).get(j) == 1) {
            num += dfs(a, i + 1, j);
        }
        // 左面
        if (j > 0 && a.get(i).get(j - 1) == 1) {
            num += dfs(a, i, j - 1);
        }
        // 右面
        if (j < a.get(i).size() - 1 && a.get(i).get(j + 1) == 1) {
            num += dfs(a, i, j + 1);
        }
        return num;
    }

    private static Integer maxArea(List<List<Integer>> a) {
        int num = 0;
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                int temp = 0;
                if (a.get(i).get(j) == 1) temp = dfs(a, i, j);
                if (temp > num) num = temp;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);list1.add(0);list1.add(0);list1.add(1);list1.add(0);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);list2.add(0);list1.add(1);

        List<Integer> list3 = new ArrayList<>();
        list3.add(0);list3.add(0);list3.add(1);list3.add(0);list3.add(1);

        List<Integer> list4 = new ArrayList<>();
        list4.add(1);list4.add(0);list4.add(1);list4.add(0);list4.add(1);

        List<Integer> list5 = new ArrayList<>();
        list5.add(1);list5.add(0);list5.add(1);list5.add(1);

        List<List<Integer>> lists = new ArrayList<>();
        lists.add(list1);lists.add(list2);lists.add(list3);lists.add(list4);lists.add(list5);

        System.out.println(maxArea(lists));
    }

}
