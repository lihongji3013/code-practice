package offer;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: hongji
 * @Date: 2021-12-07 17:03
 */
public class TwoDArraySearch {
    public static void main(String[] args) {
        int[][] matrix =new int[][]{{1,2,3},{3,4,5,6},{16,7}};
        boolean flag = false;
        for(int i = 0;i<matrix.length;i++){

//            System.out.println();
            if(Arrays.stream(matrix[i]).boxed().collect(Collectors.toList()).contains(10)){
                flag = true;
            }else if(i==1){

            }
        }
//        List<Integer> list = new ArrayList<>();
//        list.add(0);
//        list.add(15);
//        list.add(8);
//        list.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1-o2;
//            }
//        });
//        System.out.println(list.size());

        System.out.println(flag);

    }
}
