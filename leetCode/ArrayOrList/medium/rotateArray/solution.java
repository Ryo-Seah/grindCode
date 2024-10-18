class Solution {
    public void rotate(int[] nums, int k) {
        int size = nums.length
        int temp1;
        int temp2;
        int index = 0;
        for (int i=0; i<length; i++) {
            if (i ==0) {
                temp = nums[i];
                nums[i] = num[size-k+i];
                index =size-k+i;
            } else {
                temp2 = nums[index];
                nums[index] = temp1;
                

            }

            }
        }
    }
}