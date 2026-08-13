class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Initialize result array with all 1s
        int[] result = new int [nums.length];
        Arrays.fill(result,1);

        // Variables to track prefix and postfix products
        int prefix = 1, postfix = 1;

        // First pass: calculate prefix product (product of all elements to the left)
        // result[i] = product of all elements before index i
        for(int i=0; i<nums.length; i++) {
            result[i] = prefix;  // Store product of all elements before i
            prefix = nums[i] * prefix;  // Update prefix for next iteration
        }

        // Second pass: calculate postfix product (product of all elements to the right)
        // Multiply prefix product with postfix product to get final result
        for(int i=nums.length-1; i>=0; i--) {
            result[i] = result[i] * postfix;  // result[i] = prefix * postfix (product except self)
            postfix = nums[i] * postfix;  // Update postfix for next iteration (moving right to left)
        }

        return result;  // O(n) time, O(1) space (excluding output array)
        
    }
}