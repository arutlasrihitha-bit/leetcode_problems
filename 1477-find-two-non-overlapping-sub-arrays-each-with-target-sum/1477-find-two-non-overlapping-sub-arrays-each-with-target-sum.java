class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] best = new int[n];

        int INF = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            best[i] = INF;
        }

        int left = 0;
        int sum = 0;
        int minLength = INF;
        int answer = INF;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {
                int length = right - left + 1;
                if (left > 0 && best[left - 1] != INF) {
                    answer = Math.min(answer, length + best[left - 1]);
                }

                minLength = Math.min(minLength, length);
            }
            if (right > 0) {
                best[right] = best[right - 1];
            }

            if (minLength != INF) {
                best[right] = Math.min(best[right], minLength);
            }
        }

        return answer == INF ? -1 : answer;
    }
}