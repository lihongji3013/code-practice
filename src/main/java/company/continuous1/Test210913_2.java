package company.continuous1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hongji
 * @Date: 2021-09-13 10:56
 */
public class Test210913_2 {
    public static Integer maxArea(List<List<Integer>> a){
        int rows = a.size();
        int res = 0;
        for(int i = 0; i < rows; i++){
            int cols = a.get(i).size();
            for(int j = 0; j < cols; j++){
                if(a.get(i).get(j) == 1){
                    res = Math.max(res,dfs(i,j,a));
                }
            }
        }
        return res;
    }

    public static int dfs(int i, int j, List<List<Integer>> a){
        int rows = a.size();
        if(i < 0 || i >= rows){
            return 0;
        }

        int cols = a.get(i).size();
        if(j < 0 || j >= cols || a.get(i).get(j) == 0){
            return 0;
        }

        int sum = 1;
        a.get(i).set(j,0);
        sum += dfs(i -1, j , a);
        sum += dfs(i, j -1, a);
        sum += dfs(i + 1, j, a);
        sum += dfs(i, j+1, a);
        return sum;
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
