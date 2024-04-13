class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n==0) return;
        int end_idx = n+m -1;

        while (n>0 && m>0) {
            if (nums1[m-1] > nums2[n-1]) {
                nums1[end_idx] = nums1[m-1];
                m--;
            } else {
                nums1[end_idx] = nums2[n-1];
                n--;
            }
            end_idx--;
        }
        while (n>0) {
            nums1[end_idx] = nums2[n-1];
            n--;
            end_idx--;
        }

    }
       
}