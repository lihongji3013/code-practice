package company.vowelConsonants;

import java.util.ArrayList;
import java.util.List;

class CheckStringDemo
{
    public static void main(String[] args)
    {
//        String str = "ptoui";
//        System.out.println("检查结果:" + (checkString(str) == true ? "符合" : "不符合"));
        System.out.println(checkString("a"));
        System.out.println(checkString("tv"));
        System.out.println(checkString("ptoui"));
        System.out.println(checkString("bontres"));
        System.out.println(checkString("zoggax"));
        System.out.println(checkString("wiinq"));
        System.out.println(checkString("eep"));
        System.out.println(checkString("houctuh"));

    }

    public static boolean checkString(String str)
    {
        List<String> vowelList = new ArrayList<>();
        vowelList.add("a");
        vowelList.add("e");
        vowelList.add("i");
        vowelList.add("o");
        vowelList.add("u");

        System.out.println("规则1: " + (checkRuleOne(str, vowelList) == true ? "符合" : "不符合"));
        System.out.println("规则2: " + (checkRuleTwo(str, vowelList) == true ? "符合" : "不符合"));
        System.out.println("规则3: " + (checkRuleThree(str, vowelList) == true ? "符合" : "不符合"));
        System.out.println("规则4: " + (checkRuleFour(str) == true ? "符合" : "不符合"));
        if (checkRuleOne(str, vowelList) && checkRuleTwo(str, vowelList) && checkRuleThree(str, vowelList) && checkRuleFour(str))
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    public static boolean checkRuleOne(String str, List<String> vowelList)
    {
        String[] split = str.split("");
        for (int i = 0; i < split.length; i++)
        {
            if (vowelList.contains(split[i]))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean checkRuleTwo(String str, List<String> vowelList)
    {
        Integer equalNum = 0;
        String[] strings = str.split("");
        for (int i = 0; i < strings.length - 2; i++)
        {
            equalNum = 0;
            equalNum = getEqualNum(vowelList, equalNum, strings, i);
            if (equalNum >= 3)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean checkRuleThree(String str, List<String> vowelList)
    {
        Integer unequalNum = 0;
        String[] strings = str.split("");
        for (int i = 0; i < strings.length - 2; i++)
        {
            unequalNum = 0;
            unequalNum = getUnEqualNum(vowelList, unequalNum, strings, i);
            if (unequalNum >= 3)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean checkRuleFour(String str)
    {
        return getDuplicateResults(str.split(""));
    }

    private static boolean getDuplicateResults(String[] strings)
    {
        for (int i = 0; i < strings.length - 1; i++)
        {
            String string = strings[i];
            if (string.equals(strings[i + 1]))
            {
                if (!"o".equals(string) && !"e".equals(string))
                {
                    return false;
                }
            }
        }
        return true;
    }


    private static Integer getEqualNum(List<String> vowelList, Integer equalNum, String[] strings, int i)
    {
        if (vowelList.contains(strings[i]))
        {
            equalNum++;
            if (vowelList.contains(strings[i + 1]))
            {
                equalNum++;
                if (vowelList.contains(strings[i + 2]))
                {
                    equalNum++;
                }
            }
        }
        return equalNum;
    }


    private static Integer getUnEqualNum(List<String> vowelList, Integer unequalNum, String[] strings, int i)
    {
        if (!vowelList.contains(strings[i]))
        {
            unequalNum++;
            if (!vowelList.contains(strings[i + 1]))
            {
                unequalNum++;
                if (!vowelList.contains(strings[i + 2]))
                {
                    unequalNum++;
                }
            }
        }
        return unequalNum;
    }
}
