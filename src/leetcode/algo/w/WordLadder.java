package leetcode.algo.w;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
// TLE Simple BFS
public class WordLadder {
    public int ladderLength(String startWord, String endWord, List<String> wordList) {
        if (startWord.equals(endWord))
            return 0;
        Queue<String> queue = new LinkedList<String>();
        queue.add(startWord);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.remove();
                if (cur.equals(endWord)) {
                    return level + 1;
                }
                for (int j = 0; j < cur.length(); j++) {
                    char[] word = cur.toCharArray();
                    for (char ch = 'a'; ch < 'z'; ch++) {
                        word[j] = ch;
                        String check = new String(word);
                        if (!check.equals(cur) && wordList.contains(check)) {
                            queue.add(check);
                            wordList.remove(check);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
