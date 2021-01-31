/*
 Next Permutation

Solution
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
Example 4:

Input: nums = [1]
Output: [1]
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100
*/
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return;
        int index = 0;
       for(int i = n - 1; i > 0; i--) {
        if(nums[i - 1] < nums[i]) {
            index = i;
            break;
        }
    }
        if(index == 0){
            reverse(nums,0, n - 1);
            return;
        }
        
        for(int i = n - 1; i >= index; i--) {
        if(nums[index - 1] < nums[i]) {
            int temp = nums[index - 1];
            nums[index - 1] = nums[i];
            nums[i] = temp;
            break;
        }
    }
         reverse(nums, index , n - 1);
            return;
        
    }
    private void reverse(int nums[],int start,int end){
        while(start < end){
            int temp = nums[start];
            nums[start ++] = nums[end];
            nums[end --] = temp;
        }
    }
}
