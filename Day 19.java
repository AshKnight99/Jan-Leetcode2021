/*
Longest Palindromic Substring
Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters (lower-case and/or upper-case),
*/
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length(), i, j, max = 1, start = 0;
        
        int[][] dp = new int[n][n];
        
        for(i = 0; i < n; i ++)
            dp[i][i] = 1;
        
        for(i = 0; i < n - 1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i + 1] = 1;
                max = 2;
                
                start = i;
            }
        }
        
        for(i = n - 1; i >= 0; i --){
            for(j = n - 1; j - i >= 2; j --){
                if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1){
                    dp[i][j] = 1;
                    
                    int len = j - i + 1;
                    if(len > max){
                        max = len;
                        start = i;
                    }
                }
            }
        }
        
        return s.substring(start, start + max);
        
    }
}