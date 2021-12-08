package company.vowelConsonants;

/**
 * @Author: hongji
 * @Date: 2021-06-29 15:46
 */
public class Test04 {
    public static void main(String[] args) {
//        System.out.println(check("a"));
//        System.out.println(check("tv"));
//        System.out.println(check("ptoui"));
//        System.out.println(check("bontres"));
//        System.out.println(check("zoggax"));
//        System.out.println(check("wiinq"));
//        System.out.println(check("eep"));
        System.out.println(check("houctuh"));
    }

    public static String check(String sr){

        /*  判断一个全是小写字母的字符串是否符合如下规则：
        1. 至少包含一个元音字母
        2. 不能有三个连续的字母都是元音字母
        3. 不能有三个连续的字母都是辅音字母
        4. 不能有两个连续的字母是一样的，但是 e 字母和 o 字母除外
        元音字母为: a, e, i, o, u，其他都为辅音字母*/

        //判断是否包含元音字母
        String[] s = {"a","e","i","o","u"};

        int count = 0;

        for (String s1 : s) {
            if (sr.contains(s1)) count++;
        }

        if (count<=0) return "字符串不包含元音字母！";


        char[] chars = sr.toCharArray();
        //两个字母不能连续 ee 和 oo 除外
        int x = 0;
        for (int i = 0; i < chars.length; i++) {
            if (x==chars.length-1)break;

            if (chars[i]==chars[i+1]){
                if (chars[i] != 'e' && chars[i] != 'o') {
                    return "两个字母不能连续！";
                }
            }
            x++;
        }


        //不能三个字母都是元音  不能三个字母都是辅音
        StringBuilder builder = null;

        for (int i = 0; i < chars.length; i+=3) {

            try{

                int flag = 0;

                if (chars[i]=='a'
                        || chars[i]=='e'
                        || chars[i]=='i'
                        || chars[i]=='o'
                        || chars[i]=='u' ){
                    flag++;
                }
                if (chars[i+1]=='a'
                        || chars[i+1]=='e'
                        || chars[i+1]=='i'
                        || chars[i+1]=='o'
                        || chars[i+1]=='u' ){
                    flag++;
                }
                if (chars[i+2]=='a'
                        || chars[i+2]=='e'
                        || chars[i+2]=='i'
                        || chars[i+2]=='o'
                        || chars[i+2]=='u' ){
                    flag++;
                }
                if (flag==3) return "三个元音字母不能是连续的!";


                int zz = 0;

                if (chars[i]=='a'
                        || chars[i]!='e'
                        || chars[i]!='i'
                        || chars[i]!='o'
                        || chars[i]!='u' ){
                    flag++;
                }
                if (chars[i+1]!='a'
                        || chars[i+1]!='e'
                        || chars[i+1]!='i'
                        || chars[i+1]!='o'
                        || chars[i+1]!='u' ){
                    flag++;
                }
                if (chars[i+2]!='a'
                        || chars[i+2]!='e'
                        || chars[i+2]!='i'
                        || chars[i+2]!='o'
                        || chars[i+2]!='u' ){
                    flag++;
                }
                //if (flag==3) return "三个元音字母不能是连续的!";
                if (zz==0) return "三个辅音字母不能是连续的!";

            }catch (Exception e){
                int lang =  chars.length;

                builder = new StringBuilder();
                builder.append(chars[i]);
                if (lang%2==0){
                    builder.append(chars[i+1]);
                }
                System.out.println(builder.toString());

            }

        }

        return "满足";
    }
}
