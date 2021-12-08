package first.section01;

/**
 * @Author: hongji
 * @Date: 2020-10-11 19:42
 */
public class Subsequence {
    public boolean isSibence(String s, String t) {
        if (s.contains(t)) {
            return true;
        }
        if (s.length() > t.length()) {
            String temp = s;
            s = t;
            t = temp;

        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        int angle = Integer.MIN_VALUE;
        for (int i = 0; i < chars1.length - 1; i++) {

            if (t.contains(String.valueOf(chars2[i]))) {
                if (angle > t.indexOf(String.valueOf(chars2[i]))) {
                    return false;
                } else {
                    angle = t.indexOf(String.valueOf(chars2[i]));
                }

            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
