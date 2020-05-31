class Solution {
    char[] w1, w2;
    int[][] memo;

    public int minDistance(String word1, String word2) {
        w1 = word1.toCharArray();
        w2 = word2.toCharArray();
        memo = new int[w1.length][w2.length];
        return f(w1.length - 1, w2.length - 1);
    }

    private int f(int i, int j) {
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;
        if (memo[i][j] > 0) return memo[i][j];
        if (w1[i] == w2[j]) return memo[i][j] = f(i - 1, j - 1);
        return memo[i][j] = 1 + Math.min(Math.min(f(i - 1, j), f(i, j - 1)), f(i - 1, j - 1));
    }
}