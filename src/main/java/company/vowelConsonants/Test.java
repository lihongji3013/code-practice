package company.vowelConsonants;
/**
 * 判断一个全是小写字母的字符串是否符合如下规则：
 * 1. 至少包含一个元音字母
 * 2. 不能有三个连续的字母都是元音字母
 * 3. 不能有三个连续的字母都是辅音字母
 * 4. 不能有两个连续的字母是一样的，但是 e 字母和 o 字母除外
 * 说明：元音字母为: a, e, i, o, u，其他都为辅音字母
 */
public class Test {


    //判断是否包含元音字母
    public static boolean isVowel(String str){
        return str.contains("a")||str.contains("e")||str.contains("i")||str.contains("o")||str.contains("u");
    }

    public static boolean check(String str){
        boolean flag = true;
        String[] arr = str.split("");

        for(int i = 0;i<arr.length - 2;i++){
//            如果有三个连续得元音字母 false
            if (isVowel(arr[i])&&isVowel(arr[i+1])&&isVowel(arr[i+2])){
                flag = false;
            };
//            如果有三个连续得辅音字母 false
            if (!isVowel(arr[i])&&!isVowel(arr[i+1])&&!isVowel(arr[i+2])){
                flag = false;
            };
        };

        for(int i = 0;i<arr.length - 1;i++){
            //如果俩个连续得字母相同，并且不是e和o false
            if(arr[i].equals(arr[i+1]) && !"e".equals(arr[i]) && !"o".equals(arr[i])){
                flag = false;
            }
        };

        return flag;
    }

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

}