class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();

        // dp[i][j] = true if s[i...j] is a palindrome
        boolean[][] dp = new boolean[n][n];

        // Build palindrome table
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {

                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }

        int count = 0;
        int start = 0;

        // Find palindrome with the earliest ending position
        while (start + k <= n) {

            boolean found = false;

            for (int end = start + k - 1; end < n; end++) {

                // Check all possible starting positions
                for (int i = start; i <= end - k + 1; i++) {

                    if (dp[i][end]) {
                        count++;
                        start = end + 1;
                        found = true;
                        break;
                    }
                }

                if (found) {
                    break;
                }
            }

            if (!found) {
                break;
            }
        }

        return count;
    }
}