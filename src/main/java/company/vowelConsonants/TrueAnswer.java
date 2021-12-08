package company.vowelConsonants;

/*
    1.判断一个全是小写字母的字符串是否符合规律
    2.至少包含一个元音字母：a、e、i、o、u
    3.不能有三个连续的字母都是元音字母
    4.不能有三个连续的字母都是辅音字母
    5.不能有两个一样连续的字母，但除了 e、o
 */

public class TrueAnswer {
    public static void main(String[] args) {
        //String str = "a";
        //String str = "tv";
        //String str = "ptoui";
        //String str = "bontres";
        //String str = "zoggax";
        //String str = "wiinq";
        //String str = "eep";
        //String str = "Aouctuh";
        //String str = null;
        //String str = "";
        System.out.println(check("a"));
        System.out.println(check("tv"));
        System.out.println(check("ptoui"));
        System.out.println(check("bontres"));
        System.out.println(check("zoggax"));
        System.out.println(check("wiinq"));
        System.out.println(check("eep"));
        System.out.println(check("houctuh"));

    }

    public static boolean check(String str){
        if (str == null){
            return false;
        }

        if (str.length() >= 0){

            int vowelsCount = 0;    //元音个数
            int vowelsCountcontinue = 0;    //连续的元音个数

            int consonantsContinue = 0;    //连续的辅音个数

            for (int i = 0; i < str.length(); i++){

                //是否全是小写
                if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                    return false;   //不是全部小写字母
                }

                //判断连续两个字母是否相等
                if (!(i == str.length() - 1)){
                    if (str.charAt(i) == str.charAt(i + 1)){
                        if (!(str.charAt(i) == 'e' || str.charAt(i) == 'o')){
                            return false;
                        }
                    }
                }

                //是否有元音
                if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i'
                        ||str.charAt(i) == 'o' || str.charAt(i) == 'u'){
                    vowelsCount++;
                    consonantsContinue = 0;     //辅音连续个数清零

                    if (++vowelsCountcontinue == 3){
                        return false;
                    }
                }else{
                   //辅音
                    vowelsCountcontinue = 0;    //元音连续个数清零

                    if (++consonantsContinue == 3){
                        return false;
                    }
                }
            }

            if (vowelsCount == 0){
                return false;   //没有元音字母
            }
        }

        return true;
    }
}
