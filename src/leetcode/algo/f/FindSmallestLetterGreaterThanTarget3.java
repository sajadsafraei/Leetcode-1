package leetcode.algo.f;

/**
 * Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.
 * <p>
 * Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
 * <p>
 * Examples:
 * Input:
 * letters = ["c", "f", "j"]
 * target = "a"
 * Output: "c"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "c"
 * Output: "f"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "d"
 * Output: "f"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "g"
 * Output: "j
 * <p>
 * <p>
 * "
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "j"
 * Output: "c"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "k"
 * Output: "c"
 * Note:
 * letters has a length in range [2, 10000].
 * letters consists of lowercase letters, and contains at least 2 unique letters.
 * target is a lowercase letter.
 */
public class FindSmallestLetterGreaterThanTarget3 {
    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0, hi = letters.length;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (letters[mi] <= target)
                lo = mi + 1;
            else
                hi = mi;
        }
        return letters[lo % letters.length];
    }
}
