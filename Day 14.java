/*
Minimum Operations to Reduce X to Zero
You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.

Return the minimum number of operations to reduce x to exactly 0 if it's possible, otherwise, return -1.

 

Example 1:

Input: nums = [1,1,4,2,3], x = 5
Output: 2
Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
Example 2:

Input: nums = [5,6,7,8,9], x = 4
Output: -1
Example 3:

Input: nums = [3,2,20,1,1,3], x = 10
Output: 5
Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 104
1 <= x <= 109
*/
class Solution {
    public int minOperations(int[] nums, int x) {
        
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        HashMap<Integer, Integer> suffixSum = new HashMap<>();

        int n = nums.length;
        int leftSum = 0;
        int rightSum = 0;
        for(int i = 0, j = n - 1; i < n ; i++, j--) {
            int picked = i + 1;
            prefixSum.put(leftSum + nums[i], picked);
            suffixSum.put(rightSum + nums[j], picked);

            leftSum += nums[i];
            rightSum += nums[j];
        }

        int minPicks = 100001;
        leftSum = 0;
        rightSum = 0;
        for(int i = 0, j = n - 1; i < n ; i++, j--) {
            int picked = i + 1;
            leftSum += nums[i];
            rightSum += nums[j];

            if(suffixSum.containsKey(x - leftSum)) 
                minPicks = Math.min(minPicks, picked + suffixSum.get(x - leftSum));

            if(prefixSum.containsKey(x - rightSum)) 
                minPicks = Math.min(minPicks, picked + prefixSum.get(x - rightSum));

            if(leftSum == x || rightSum == x)
                minPicks = Math.min(minPicks, picked);
        }

        return (minPicks > n ? -1 : minPicks);
    }
}