class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int[] first = new int[26];
        int[] last = new int[26];

        for (int i = 0; i < 26; i++) {
            first[i] = -1;
            last[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';

            if (first[c] == -1) {
                first[c] = i;
            }

            last[c] = i;
        }

        List<String> result = new ArrayList<>();
        int previousEnd = -1;

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';

            if (i != first[c]) {
                continue;
            }

            int end = last[c];
            boolean valid = true;

            for (int j = i; j <= end; j++) {
                int current = s.charAt(j) - 'a';

                if (first[current] < i) {
                    valid = false;
                    break;
                }

                end = Math.max(end, last[current]);
            }

            if (valid) {
                if (i <= previousEnd) {
                    result.set(result.size() - 1, s.substring(i, end + 1));
                } else {
                    result.add(s.substring(i, end + 1));
                }

                previousEnd = end;
            }
        }

        return result;
    }
}