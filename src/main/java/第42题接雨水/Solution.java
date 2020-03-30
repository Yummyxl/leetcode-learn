package 第42题接雨水;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/3/28
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class Solution {

    // 一行一行求
    public int trap1(int[] height) {

        if (height == null || height.length <= 1) {
            return 0;
        }

        int max = getMax(height);
        int result = 0;
        for (int i=1; i<=max; i++) {
            int temp = 0;
            boolean start = false;
            for (int j=0; j<height.length; j++) {
                if ( start && height[j] < i) {
                    temp++;
                }
                if (height[j] >= i) {
                    result += temp;
                    temp = 0;
                    start = true;
                }
            }
        }

        return result;

    }

    public int getMax(int[] height) {
        int max = 0;
        for (int i=0; i<height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
        }
        return max;
    }

    // 找出当前正在求的列的左边和右边最高的墙
    public int trap2(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }

        int result = 0;

        for (int i=1; i<height.length - 1; i++) {
            int maxLeft = 0;
            for (int j=0; j<i; j++) {
                if (height[j] < maxLeft) {
                    maxLeft = height[j];
                }
            }

            int maxRight = 0;
            for (int j=i+1; j<height.length; j++) {
                if (height[j] > maxRight) {
                    maxRight = height[j];
                }
            }

            if (height[i] < maxLeft && height[i] < maxRight) {
                result += (Math.min(maxLeft, maxRight) - height[i]);
            }
        }
        return result;
    }

    //动态规划
    public int trap3(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }

        int result = 0;
        // i 左边或者右边最高的列
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        for (int i=1; i<height.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1], height[i - 1]);
        }
        for (int i=height.length - 2; i>=0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }

        for (int i=1; i<height.length - 1; i++) {
            if (height[i] < maxLeft[i] && height[i] < maxRight[i]) {
                result += (Math.min(maxLeft[i], maxRight[i]) - height[i]);
            }
        }

        return result;
    }

    // 双指针
    public int trap4(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }

        int result = 0;
        int left = 1;
        int maxLeft = 0;
        int right = height.length - 2;
        int maxRight = 0;

        while (left <= right) {

            if (height[left - 1] < height[right + 1]) {
                maxLeft = Math.max(height[left - 1], maxLeft);
                if (maxLeft > height[left]){
                    result += maxLeft - height[left];
                }
                left++;
            } else {
                maxRight = Math.max(height[right + 1], maxRight);
                if (maxRight > height[right]) {
                    result += maxRight - height[right];
                }
                right--;
            }
        }
        return result;
    }
}
