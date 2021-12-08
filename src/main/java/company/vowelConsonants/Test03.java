package company.vowelConsonants;

/**
 * @Author: hongji
 * @Date: 2021-06-29 14:22
 */
public class Test03 {
    public boolean check(String str) {
        int yuan = 0;
        int fu = 0;
        int same = 0;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            boolean isyuan = c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
            if (isyuan) {
                count++;
                yuan++;
                fu = 0;
            }
            if (yuan >= 3) {
                break;
            }
            if (i < str.length() - 1 && c == str.charAt(i + 1) && c != 'e' && c != 'o') {
                same = 1;
                break;
            }
            if (!isyuan) {
                yuan = 0;
                fu++;
            }
            if (fu >= 3) {
                break;
            }
        }
        if (count == 0 || same == 1 || yuan >= 3 || fu >= 3) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Test03 test03 = new Test03();
        System.out.println(test03.check("a"));
        System.out.println(test03.check("tv"));
        System.out.println(test03.check("ptoui"));
        System.out.println(test03.check("bontres"));
        System.out.println(test03.check("zoggax"));
        System.out.println(test03.check("wiinq"));
        System.out.println(test03.check("eep"));
        System.out.println(test03.check("houctuh"));
    }
}
