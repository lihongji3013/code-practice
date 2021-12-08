package company.vowelConsonants;

import java.util.*;

/**
 * @ProjectName:dataStructruesPractice
 * @Package:com.zlq.common.test
 * @ClassName: CheckStr1102
 * @description:
 * @author: LiQun
 * @CreateDate:2021/11/1 6:17 下午
 */
/*
判断一个全是小写字母的字符串是否符合如下规则：
1. 至少包含一个元音字母
2. 不能有三个连续的字母都是元音字母
3. 不能有三个连续的字母都是辅音字母
4. 不能有两个连续的字母是一样的，但是 e 字母和 o 字母除外
说明：元音字母为: a, e, i, o, u，其他都为辅音字母
示例：
check('a'); //满足
check('tv'); //不满足
check('ptoui'); //不满足
check('bontres'); //不满足
check('zoggax'); //不满足
check('wiinq'); //不满足
check('eep'); //满足
check('houctuh'); //满足
 */
public class CheckStr1102 {
    public static void main(String[] args) {
//        String str = "oo";
//        existVowel(str);
//        System.out.println(threeConsecutiveVowel(str));
//        System.out.println(threeConsecutiveConsonants(str));
//        System.out.println(twoConsecutiveSame(str));
        System.out.println(check("a"));
        System.out.println(check("tv"));
        System.out.println(check("ptoui"));
        System.out.println(check("bontres"));
        System.out.println(check("zoggax"));
        System.out.println(check("wiinq"));
        System.out.println(check("eep"));
        System.out.println(check("houctuh"));
        System.out.println(check("aecoo"));

    }

    public static List<Character> consonantsList = Arrays.asList('a', 'e', 'i', 'o', 'u');   // 将元音字母放到list中
    public static int firstVowelCharacterIndex = -1;   // 寻找第一个元音字母

    public static boolean check(String str) {
        if (!existVowel(str) || threeConsecutiveConsonants(str)
        || threeConsecutiveVowel(str) || twoConsecutiveSame(str)){
            return false;
        }
        return true;
    }


    /**
     * 判断是否包含元音字母
     *
     * @param str
     * @return
     */
    public static boolean existVowel(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (consonantsList.contains(str.charAt(i))) {
                firstVowelCharacterIndex = i;
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否有三个连续的字母都是元音字母
     *
     * @param str
     * @return
     */
    public static boolean threeConsecutiveVowel(String str) {
        int length = str.length();
        if (firstVowelCharacterIndex > length - 3) return false;  // 如果第一个元音字母出现在str.length() - 3之后肯定不可能会有连续三个元音字母
        int left = firstVowelCharacterIndex, right = left + 2; // 滑动窗口，窗口的起始点是从第一个元音字母开始
        boolean res = false;  // 定义窗口内三个字母是否都为元音字母，默认为false
        while (right <= length - 1) {
            for (int i = left; i <= right; i++) {
                if (isAllVowel(left, right, str)) {
                    res = true;
                    break;
                }
            }
            left++;
            right++;
        }
        return res;
    }

    /**
     * 判断是否有三个连续的字母都是辅音字母
     *
     * @param str
     * @return
     */
    public static boolean threeConsecutiveConsonants(String str) {
        int left = 0, right = left + 2; // 滑动窗口
        boolean res = false;  // 定义窗口内三个字母是否都为辅音字母，默认为false
        while (right <= str.length() - 1) {
            for (int i = left; i <= right; i++) {
                if (isAllConsonants(left, right, str)) {
                    res = true;
                    break;
                }
            }
            left++;
            right++;
        }
        return res;
    }

    /**
     * 判断是否有两个连续的字母是一样的，但是 e 字母和 o 字母除外
     *
     * @param str
     * @return
     */
    public static boolean twoConsecutiveSame(String str) {
        str = str.replace("e", "").replace("o", "");

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) return true;
        }
        return false;
    }

    /**
     * 判断窗口内的字母是否都为元音字母
     *
     * @param left
     * @param right
     * @param str
     * @return
     */
    public static boolean isAllVowel(int left, int right, String str) {
        for (int i = left; i <= right; i++) {
            if (!consonantsList.contains(str.charAt(i))) return false;
        }
        return true;
    }


    /**
     * 判断窗口内的字母是否都为辅音字母
     *
     * @param left
     * @param right
     * @param str
     * @return
     */
    public static boolean isAllConsonants(int left, int right, String str) {
        for (int i = left; i <= right; i++) {
            if (consonantsList.contains(str.charAt(i))) return false;
        }
        return true;
    }
}
