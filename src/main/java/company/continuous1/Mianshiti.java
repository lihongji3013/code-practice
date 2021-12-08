package company.continuous1;

import java.util.ArrayList;
import java.util.List;

/**
 *     [1, 0, 0, 1, 0],
 *     [1, 0, 1],
 *     [0, 0, 1, 0, 1],
 *     [1, 0, 1, 0, 1],
 *     [1, 0, 1, 1]
 */
public class Mianshiti {
    public static void main(String[] args) {
        List<List<Integer>>  a = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        one.add(1);
        one.add(0);
        one.add(0);
        one.add(1);
        one.add(0);
        a.add(one);
        List<Integer> two = new ArrayList<>();
        two.add(1);
        two.add(0);
        two.add(1);
        a.add(two);
        List<Integer> three = new ArrayList<>();
        three.add(0);
        three.add(0);
        three.add(1);
        three.add(0);
        three.add(1);
        a.add(three);
        List<Integer> four = new ArrayList<>();
        four.add(1);
        four.add(0);
        four.add(1);
        four.add(0);
        four.add(1);
        a.add(four);
        List<Integer> five = new ArrayList<>();
        five.add(1);
        five.add(0);
        five.add(1);
        five.add(1);
        a.add(five);
        System.out.println(maxArea(a));


    }
    public static int getNumber(List<List<Integer>> arr, int  i, int j){

        int num = 1;
        arr.get(i).set(j,0);
        if(i-1>=0&&arr.get(i-1).size()>j&& arr.get(i-1).get(j)==1){  //上边
            num += getNumber(arr,i - 1, j);
        }

        if(i+1<arr.size()&&arr.get(i+1).size()>j&&arr.get(i+1).get(j)==1){  //下边
            num += getNumber(arr,i + 1, j);
        }

        if(i<arr.size()&&j-1>=0&&arr.get(i).size()>j&&arr.get(i).get(j-1)==1){   //左边
            num += getNumber(arr,i, j - 1);
        }

        if(i<arr.size()&&j+1<arr.get(i).size()&&arr.get(i).get(j+1)==1){   //右边
            num += getNumber(arr,i, j + 1 );
        }
        return num;
    }
    public static int maxArea(List<List<Integer>> a){
        int Maxnumber = 0;
        for(int i =0 ;i<a.size();i++){
            for(int j = 0; j< a.get(i).size(); j++){
                int flag = a.get(i).get(j);
                if(flag == 1){
                    int cur = getNumber(a, i,j);
                    if(Maxnumber<cur){
                        Maxnumber = cur;
                    }

                }
            }
        }
        return Maxnumber;


    }
}
