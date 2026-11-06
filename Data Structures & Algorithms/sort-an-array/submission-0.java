class Solution {
    public int[] sortArray(int[] nums) {
        // Base case: arrays with 0 or 1 element are already sorted
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        // Find the midpoint to divide the array
        int mid = left + (right - left) / 2;

        // Recursively sort the left and right halves
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        // Merge the sorted halves back together
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        // Determine sizes of the two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays to hold copies of the data
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            L[i] = nums[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = nums[mid + 1 + j];
        }

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray
        int k = left;

        // Merge elements back into the original array in sorted order
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                nums[k] = L[i];
                i++;
            } else {
                nums[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements of L[] if there are any
        while (i < n1) {
            nums[k] = L[i];
            i++;
            k++;
        }

        // Copy any remaining elements of R[] if there are any
        while (j < n2) {
            nums[k] = R[j];
            j++;
            k++;
        }
    }
}
