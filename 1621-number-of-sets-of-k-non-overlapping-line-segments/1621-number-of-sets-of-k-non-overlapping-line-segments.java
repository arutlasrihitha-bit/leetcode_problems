class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfSets(int n, int k) {
        int N = n + k - 1;
        int R = 2 * k;

        long ans = 1;

        for (int i = 1; i <= R; i++) {
            ans = (ans * (N - R + i)) % MOD;
            ans = (ans * modPow(i, MOD - 2)) % MOD;
        }

        return (int) ans;
    }

    private long modPow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }
}