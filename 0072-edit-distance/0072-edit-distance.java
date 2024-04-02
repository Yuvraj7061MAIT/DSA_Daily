class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        if(n == 0){
            return m;
        }
        else if(m == 0){
            return n;
        }

        // Create two arrays to store the previous and current rows of minimum edit distances
        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];

        // Initialize the first row with their respective indices
        for (int j = 0; j <= m; j++) {
            prev[j] = j;
        }

        // Fill the cur array using a bottom-up approach
        for (int i = 1; i <= n; i++) {
            cur[0] = i;
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // If the characters match, no edit is needed, so take the value from the diagonal.
                    cur[j] = prev[j - 1];
                } else {
                    // If the characters don't match, take the minimum of three possibilities:
                    // 1. Replace the character in word1 with the character in word2 (diagonal).
                    // 2. Delete the character in word1 (left).
                    // 3. Insert the character from word2 into word1 (up).
                    cur[j] = 1 + Math.min(prev[j - 1], Math.min(prev[j], cur[j - 1]));
                }
            }
            // Update prev array to store the current values
            prev = cur.clone();
        }

        return cur[m];
    }
}
