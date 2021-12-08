package leetcode;

/**
 * @Author: hongji
 * @Date: 2020-08-21 13:48
 */
public class RegularExpressionMatch {
    public static boolean isMatch(String s, String p) {
        if(s.equals(p)||s.trim().equals(p.trim())||p.equals("*")||p.equals(".")&&s.trim().length()>1)
            return true;
        if(p.contains(".")&& p.contains("*")){
            String[] strs = p.split(".");
            for (String s1 : strs){
                if(s1.contains("*")){
                    String[] strs2 = s1.split("\\*");
                    for (String s2:strs2) {
                        if(isMatch(s,s2)){
                            return false;
                        }
                    }

                }else {
                    if(!s.contains(s1)){
                        return false;
                    }
                }
            }
        }else if(p.contains(".")&& !p.contains("*")){
            return s.contains(p.replaceAll(".",""));

        }else if(!p.contains(".")&& p.contains("*")){
            String[] strs3 = p.split("\\*");
            for(String s3 : strs3){
//                return f
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(isMatch("aab","c*a*b"));
    }
}
