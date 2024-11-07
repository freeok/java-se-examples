package org.pcdd.leetcode;

class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;

        while (i < j) {
            // height * width
            int area = Math.min(height[i], height[j]) * (j - i);
            max = Math.max(area, max);
            if (height[i] < height[j]) i++;
            else j--;
        }

        return max;
    }
}
