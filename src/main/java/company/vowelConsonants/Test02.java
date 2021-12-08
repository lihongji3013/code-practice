package company.vowelConsonants;

import java.util.HashMap;
import java.util.Map;

public class Test02 {

    private final Map<Character,Character> map = new HashMap<>();

    {
        map.put('a','a');
        map.put('e','e');
        map.put('i','i');
        map.put('o','o');
        map.put('u','u');
    }

    public static void main(String[] args) {
        Test02 test02 = new Test02();

        System.out.println(test02.check("a"));
        System.out.println(test02.check("tv"));
        System.out.println(test02.check("ptoui"));
        System.out.println(test02.check("bontres"));
        System.out.println(test02.check("zoggax"));
        System.out.println(test02.check("wiinq"));
        System.out.println(test02.check("eep"));
        System.out.println(test02.check("houctuh"));
    }


    /**
     * 判断一个全是小写字母的字符串是否符合如下规则：
     * 1. 至少包含一个元音字母
     * 2. 不能有三个连续的字母都是元音字母
     * 3. 不能有三个连续的字母都是辅音字母
     * 4. 不能有两个连续的字母是一样的，但是 e 字母和 o 字母除外
     * 说明：元音字母为: a, e, i, o, u，其他都为辅音字母
     */
    public boolean check(String str){
        //上一个字母
        char preE = 'A';
        //连续原因数量
        int yNum = 0;
        //连续辅音数量
        int fNum = 0;
        //是否包含元音字母
        boolean isOk = false;

        for (char e : str.toCharArray()) {
            //条件一
            if (isVowel(e)){
                isOk = true;
                yNum++;
                fNum = 0;
            }else {
                fNum++;
                yNum = 0;
            }
            //条件2，3 ,4
            if (yNum>=3||fNum>=3||(e!='e'&&e!='o'&&preE==e))
                return false;
            preE = e;
        }
        return isOk;
    }

    /**
     * 判断字母是否是元音
     * @param e 字母字符
     * @return true 是 ， false 否
     */
    public boolean isVowel(char e){
        return map.get(e)!=null;
    }
}
