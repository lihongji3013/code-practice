package company.vowelConsonants;

/**
 * @Author: hongji
 * @Date: 2021-06-28 15:36
 */
public class Test1 {

    //字符串判断至少一个元音，不能三个连续元音，不能三个联系辅音，不能两个字母重复，e和o除外
    //元音字母：a,e,i,o,u除外都是
    // 辅音字母b,c,d,f,g,h,j,k,l,m,n,p,q,r,s,t,v,w,x,y,z。
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
    public static boolean check(String s){
        //元音
        char[] vowel={'a','e','i','o','u'};
        //传入字符串的字符数组
        char[] chars=s.toCharArray();
        //至少包含一个元音判断
        int a=0;
        for (int i = 0; i < chars.length; i++) {
            //字母重复判断
            if(i+1<chars.length&&chars[i]==chars[i+1] && chars[i]!='e' && chars[i]!='o')
                return false;

            //当前字符是否存在于元音数组中
            a+=String.valueOf(vowel).indexOf(chars[i])>-1?1:0;

            //三个元辅字母连续判断
            int b=0;
            if(chars.length-i>=3){
                for (int j = i; j < i+3; j++)
                    b+=String.valueOf(vowel).indexOf(chars[j])>-1?1:-1;
                if(b>=3)
                    return false;
                if(b<=-3)
                    return false;
            }
        }
        return a != 0;
    }
}
