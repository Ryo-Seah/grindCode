class Solution {
    public int removeDuplicates(int[] nums) {
        int previous = -99999999;
        int count = 0;
        int offset = 0;

        for (int i=0; i <nums.length; i++) {
            //first update counts
            if (nums[i] == previous ) {
                count+=1;
            } else {
                count = 0;
            }
            // next update value in array
            if (count > 1) {
                offset+=1;
                continue;
            } else {
                nums[i-offset] = nums[i];
            }

            previous = nums[i];
           
        }
        return nums.length - offset;
    }
}

//Main tecnhnique:
// keep variables of offset, previous value and count of number of times a number has appeared.
// for each loop, if number is to be removed, increase offset. If not, set value at current index to offset index