package leetcode;

/**
 * https://leetcode.com/problems/count-numbers-with-unique-digits/
 */
public class Problem357 {
    public int countNumbersWithUniqueDigits(int n) {
        return countNumbersWithUniqueDigits(n, 0, new boolean[10]);
    }

    private int countNumbersWithUniqueDigits(int n, int m, boolean[] visited) {
        if (n == m) {
            return 1;
        }
        int count = 1;
        for (int i = (m == 0) ? 1 : 0; i <= 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                count += countNumbersWithUniqueDigits(n, m + 1, visited);
                visited[i] = false;
            }
        }
        return count;
    }
}
