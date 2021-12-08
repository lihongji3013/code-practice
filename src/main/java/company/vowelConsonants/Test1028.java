package company.vowelConsonants;

/**
 * @Author: hongji
 * @Date: 2021-10-28 16:00
 */
public class Test1028 {
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

    /**
     * 检查字符串是否符合规则
     * @param str 字符串
     * @return 检查结果
     */
    private static boolean check(String str) {
        int vowelCount = 0;
        int length = str.length() < 3 ? str.length() : str.length()-2;
        for (int i = 0; i < length; i++) {
            int continuityVowelCount = 0;
            int continuityConsonantCount = 0;
            for (int j = i; j < i+3; j++) {
                char ch = str.charAt(j);
                if ("aeiou".contains(String.valueOf(ch))) {
                    vowelCount++;
                    continuityVowelCount++;
                } else {
                    continuityConsonantCount++;
                }

                if (str.length() == j+1) {
                    break;
                }

                if (!"eo".contains(String.valueOf(ch)) && ch == (str.charAt(j+1))) {
                    return false;
                }
            }

            if (3 == continuityConsonantCount || 3 == continuityVowelCount) {
                return false;
            }
        }
        return vowelCount != 0;
    }
}
