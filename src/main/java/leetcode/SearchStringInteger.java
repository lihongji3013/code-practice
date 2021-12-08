package leetcode;

/**
 * @Author: hongji
 * @Date: 2020-08-20 13:36
 */
public class SearchStringInteger {
    public static int myAtoi(String str) {
        String trimStr = str.trim();
        char[] chs = trimStr.toCharArray();
        try{
            String firstChar = String.valueOf(chs[0]);
            if("-".equals(firstChar)||"+".equals(firstChar)||Character.isDigit(chs[0])){
                StringBuilder sb = new StringBuilder();
                sb.append(chs[0]);
                for (int i=1;i<=chs.length-1;i++){
                    if((chs[i]<= '9' && chs[i]>= '0')){
                        sb.append(chs[i]);
                        if(Double.parseDouble(sb.toString())>Integer.MAX_VALUE){
                            return Integer.MAX_VALUE;
                        }else if(Double.parseDouble(sb.toString())<Integer.MIN_VALUE){
                            return Integer.MIN_VALUE;
                        }
                    }else {
                        return Integer.parseInt(sb.toString());
                    }
                }
                return Integer.parseInt(sb.toString());
            }else {
                return 0;
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return 0;
        }

    }
    public static void main(String[] args) {
        System.out.println(myAtoi("4193 with words"));

    }
}
