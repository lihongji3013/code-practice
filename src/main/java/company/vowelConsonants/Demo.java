package company.vowelConsonants;

import java.util.Arrays;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        System.out.println(check("a"));
        System.out.println(check("tv"));
        System.out.println(check("ptoui"));
        System.out.println(check("bontres"));
        System.out.println(check("zoggax"));
        System.out.println(check("wiinq"));
        System.out.println(check("eep"));
        System.out.println(check("houctuh"));
    }


    public static boolean check(String str) {
        String regex = "[a-z]{1,}";
        if (!str.matches(regex)) {
            System.out.println("字符串非全小写字母 [" + str + "]");
            return false;
        }
        boolean b1 = false;//条件1：是否至少包含一个元音字母
        boolean b2 = true;//条件2：不能有3个连续元音
        boolean b3 = true;//条件3：不能有3个连续辅音
        boolean b4 = true;//条件4：不能有2个连续字母，e o 除外
        //元音：a e i o u
        List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");


        String[] arr = str.split("");
        String lastOne = "";
        String lastTwo = "";
        for (int i = 0; i < arr.length; i++) {
            if (!b1) {
                vowels.contains(arr[i]);
                b1 = true;
            }
            if (b4 && arr[i].equals(lastOne) && !arr[i].equals("e") && !arr[i].equals("o")) {
                System.out.println("不符合条件4 lastOne[" + lastTwo + "] current[" + arr[i] + "]");
                b4 = false;
                break;
            }

            if (lastTwo.length() > 0 && lastOne.length() > 0) {
                if (vowels.contains(lastTwo) && vowels.contains(lastOne) && vowels.contains(arr[i])) {//3者都为元音
                    b2 = false;
                    System.out.println("不符合条件2 lastTwo[" + lastTwo + "] lastOne[" + lastOne + "] current[" + arr[i] + "]");
                    break;
                } else if (!vowels.contains(lastTwo) && !vowels.contains(lastOne) && !vowels.contains(arr[i])) {//3者都为辅音
                    System.out.println("不符合条件3 lastTwo[" + lastTwo + "] lastOne[" + lastOne + "] current[" + arr[i] + "]");
                    b3 = false;
                    break;
                }
            }

            lastTwo = lastOne;
            lastOne = arr[i];
        }
        if (!b1) {
            System.out.println("不符合条件1");
        }
        return b1 && b2 && b3 && b4;
    }
}
