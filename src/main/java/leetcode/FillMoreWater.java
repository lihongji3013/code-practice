package leetcode;

/**
 * @Author: hongji
 * @Date: 2020-10-10 15:20
 */
public class FillMoreWater {
    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/container-with-most-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int maxAreaOn2(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int tempArea;
        for(int i = 0;i<height.length-1;i++){
            for(int j = i+1;j<height.length;j++){
               tempArea = Math.min(height[i],height[j])*(j-i);
               maxArea =  Math.max(maxArea,tempArea);

            }
        }
        return maxArea;
    }

    public static int maxAreaOn(int[] height) {
        int r = height.length-1;
        int l = 0;
        int maxArea = Integer.MIN_VALUE;
        while (l<r){
            maxArea =  Math.max(maxArea,Math.min(height[l],height[r])*(r-l));
           if(height[l]<=height[r]){
               ++l;
           }else {
               --r;
           }
        }
        return maxArea;
    }



    public static void main(String[] args) {
        int height[] = {1,8,6,2,5,4,8,3,7};
        long startMill = System.currentTimeMillis();
        System.out.println(maxAreaOn2(height));
        System.out.println((System.currentTimeMillis()-startMill)+" ms");
    }
}
