class Solution {
    public int[] productExceptSelf(int[] nums) {
        // left -> right product
        // right -> left product
        int[] res = new int[nums.length];

        int prod = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = prod;
            prod *=nums[i];
        }

        prod = 1;
        
        for (int j = nums.length-1; j >= 0; j--) {
            res[j] = prod * res[j];
            prod *= nums[j];
        }

        return res;
    }
}
