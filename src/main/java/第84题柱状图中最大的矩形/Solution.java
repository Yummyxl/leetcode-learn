package 第84题柱状图中最大的矩形;

import java.util.Stack;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/4/5
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *  
 *
 *
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 *  
 *
 *
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 *  
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class Solution {
    public int largestRectangleArea1(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }

        int max = 0;
        int[] leftI = new int[heights.length];
        leftI[0] = -1;
        for (int i=1; i<heights.length; i++) {
            int tmp = i - 1;
            while (tmp >= 0 && heights[i] <= heights[tmp]) {
                tmp = leftI[tmp];
            }
            leftI[i] = tmp;
        }

        int[] rightI = new int[heights.length];
        rightI[heights.length-1] = heights.length;

        for (int i=heights.length-2; i>=0; i--) {
            int tmp = i + 1;
            while (tmp < heights.length && heights[i] <= heights[tmp]) {
                tmp = rightI[tmp];
            }
            rightI[i] = tmp;
        }

        for (int i=0; i<heights.length; i++) {
            max = Math.max((rightI[i] - leftI[i] - 1) * heights[i], max);
        }
        return max;
    }

    public int largestRectangleArea(int[] heights) {

        if (heights == null || heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;

        for (int i=0; i<heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                max = Math.max(max, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            max = Math.max(max, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return max;
    }

}
