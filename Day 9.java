/*
 Word Ladder
Given two words beginWord and endWord, and a dictionary wordList, return the length of the shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list.
Return 0 if there is no such transformation sequence.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 

Constraints:

1 <= beginWord.length <= 100
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the strings in wordList are unique.
*/
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
   Set<String> set = new HashSet<>();
        int n = wordList.size();
        boolean ifEndWordPresent = false;
        
        for(int i = 0; i < n; i++){
            if(wordList.get(i).equals(endWord))
                ifEndWordPresent = true;
            set.add(wordList.get(i));
        }
        
        if(!ifEndWordPresent)
            return 0;
        
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        
        int ans = 0;
        
        while(!q.isEmpty()){
            ans += 1;
            int currSize = q.size();
            
            while(currSize-- > 0){
                String currWord = q.poll();
                
                for(int i=0; i<currWord.length(); i++){
                    StringBuilder tempWord = new StringBuilder();
                    tempWord.append(currWord);
                    
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        tempWord.setCharAt(i, ch);
                        
                        if(tempWord.toString().equals(currWord))
                            continue;
                        
                        if(tempWord.toString().equals(endWord))
                            return ans + 1;
                        
                        if(set.contains(tempWord.toString())){
                            q.offer(tempWord.toString());
                            set.remove(tempWord.toString());
                        }
                               
                    }
                    
                }
            }
        }
        
        return 0;
    }
}