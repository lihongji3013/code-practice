package company.vowelConsonants;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: hongji
 * @Date: 2021-10-08 16:24
 */
public class Test1008 {
    public static void main(String[] args) {
        System.out.println("请输入字符串");
        String s = new Scanner(System.in).nextLine();
        Pattern p1=Pattern.compile("[aeiou]");
        Pattern p2=Pattern.compile("([aeiou])\\1{2}");
        Pattern p3=Pattern.compile("([^aeiou])\\1{2}");
        Pattern p4=Pattern.compile("([a-df-np-z])\\1{1}");
        Matcher m1=p1.matcher(s);
        Matcher m2=p2.matcher(s);
        Matcher m3=p3.matcher(s);
        Matcher m4=p4.matcher(s);
        if(m1.find()){
            if(m2.find()){
                System.out.println("不满足");
            }else{
                if(m3.find()){
                    System.out.println("不满足");
                }else{
                    if(m4.find()){
                        System.out.println("不满足");
                    }else{
                        System.out.println("满足");
                    }
                }
            }
        }else{
            System.out.println("不满足");
        }

    }
}
