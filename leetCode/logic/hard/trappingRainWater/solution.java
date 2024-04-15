class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length -1;
        int left_max = height[left];
        int right_max = height[right];
        int count = 0;
        while (left < right) {
          if (left_max < right_max) {
            if (left_max >= height[left+1]) {
                count += (left_max - height[left + 1]);
                
            } else {
                left_max = height[left+1];
            }
            left++;

          } else {
            if (right_max > height[right -1]) {
                count += (right_max - height[right - 1]);
            } else {
                right_max = height[right - 1];
            }
            right--;

          }
        }
        return count;
    }
}