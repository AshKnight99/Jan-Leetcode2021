/*
Path With Minimum Effort
You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

 

Example 1:



Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
Output: 2
Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
Example 2:



Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
Output: 1
Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].
Example 3:


Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
Output: 0
Explanation: This route does not require any effort.
 

Constraints:

rows == heights.length
columns == heights[i].length
1 <= rows, columns <= 100
1 <= heights[i][j] <= 106
*/
class Solution {
   int[] dir = new int[]{ 0, 1, 0,-1, 0};
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] efforts = new int[m][n];
        for(int[] effort: efforts){
            Arrays.fill(effort, Integer.MAX_VALUE);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> (a[0]-b[0]));
        efforts[0][0] = 0;
        
        pq.offer(new int[]{0,0,0});
        
        while(!pq.isEmpty()){
            int[] head = pq.poll();
            int x = head[1];
            int y =head[2];
            int currentEffort = head[0];
            if(x == m-1 && y == n-1){
                return currentEffort;
            }
            for(int k=0;k<4;k++){
                int newX = x + dir[k];
                int newY = y + dir[k+1];
                //k= 0 x, y+1
                //k=1 x+1, y 
                // k=2 x, y-1
                // k-3 x-1, y
                if(newX>=0 && newX<m && newY>=0 &&newY<n){
                    int nextEffort = Math.max(currentEffort, Math.abs(heights[newX][newY] - heights[x][y]));
                    
                    if(nextEffort< efforts[newX][newY]){
                        efforts[newX][newY] =nextEffort;
                        pq.offer(new int[]{nextEffort, newX, newY});
                    }
                }
            }
        }
        return 0;
            
    }
}