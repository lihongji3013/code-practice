package company.continuous1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hongji
 * @Date: 2021-09-13 10:49
 */
public class Test210913 {
    Integer maxArea(List<List<Integer>> a) {
        int res = 0;
        for (int r = 0; r < a.size(); r++) {
            for (int c = 0; c < a.get(0).size(); c++) {
                if (a.get(r).get(c) == 1) {
                    int g = area(a, r, c);
                    res = Math.max(res, g);
                }
            }
        }
        return res;
    }

    int area(List<List<Integer>> grid, int r, int c) {
        if (!(0 <= r && r < grid.size()
                && 0 <= c && c < grid.get(0).size())) {
            return 0;
        }
        if (grid.get(r).get(c) != 1) {
            return 0;
        }
        grid.get(r).set(c, 2);

        return 1
                + area(grid, r - 1, c)
                + area(grid, r + 1, c)
                + area(grid, r, c - 1)
                + area(grid, r, c + 1);
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

        Test210913 test210913 = new Test210913();
        System.out.println(test210913.maxArea(lists));
    }

}
