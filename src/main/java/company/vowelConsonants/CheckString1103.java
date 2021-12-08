package company.vowelConsonants;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: hongji
 * @Date: 2021-11-03 10:54
 */
public class CheckString1103 {
    private static List<Character> yuanyin = new ArrayList<>();
    private static List<Character> eo = new ArrayList<>();
    static {
        yuanyin.add('a');
        yuanyin.add('e');
        yuanyin.add('i');
        yuanyin.add('o');
        yuanyin.add('u');

        eo.add('e');
        eo.add('o');
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
        System.out.println(check("aecoo"));
    }

    private static boolean check(String str) {
        char[] chars = str.toCharArray();
        List<Character> characterList = new ArrayList<>();
        for(int i = 0; i < chars.length; i ++){
            characterList.add(chars[i]);
        }
        boolean check1 = check1(characterList);
        boolean check2 = check2(characterList);
        boolean check3 = check3(characterList);
        //有一个不满足就返回false
        if(check1 == false || check2 == false || check3 == false){
            return false;
        }
        return true;
    }

    /**
     * 4：不能有两个连续字母是一样的(e,o除外)
     * @param characterList
     * @return
     */
    private static boolean check3(List<Character> characterList) {
        if(characterList.size() < 2){
            //一个字符
            return true;
        }
        for(int i = 0; i < characterList.size(); i++){
            if(i == 0){
                continue;
            }
            Character c1 = characterList.get(i - 1);
            Character c2 = characterList.get(i);
            if(c1.equals(c2) && !eo.contains(c1)){
                return false;
            }
        }
        return true;
    }

    /**
     * 2，3：每三个连续字母都包含元音字母（不能有三个连续字母都是元音，不能有三个连续字母都是辅音）
     * @param characterList
     * @return
     */
    private static boolean check2(List<Character> characterList) {
        if(characterList.size() <= 2){
            //只有两个或一个字符，其中一个是元音字母
            return true;
        }
        //超过三个字母
        for(int i = 0; i < characterList.size(); i++){
            if(i < 1){
                continue;
            }
            if(Integer.valueOf(i).equals(characterList.size() - 1)){
                break;
            }
            Character ichar1 = characterList.get(i-1);
            boolean b1 = yuanyin.contains(ichar1);
            Character ichar2 = characterList.get(i);
            boolean b2 = yuanyin.contains(ichar2);
            Character ichar3 = characterList.get(i+1);
            boolean b3 = yuanyin.contains(ichar3);
            //三个true 都是元音字母
            if(b1 == true && b2 == true && b3 == true){
                return false;
            }
            //三个false 都是辅音字母
            if(b1 == false && b2 == false && b3 == false){
                return false;
            }
        }
        return true;
    }

    /**
     * 1:至少包含一个元音字母
     * @param characterList
     * @return
     */
    private static boolean check1(List<Character> characterList) {
        List<Character> collect = yuanyin.stream().filter(x -> characterList.contains(x)).collect(Collectors.toList());
        return collect.size() > 0;
    }
}
