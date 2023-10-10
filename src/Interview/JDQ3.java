package Interview;

public class JDQ3 {

    static class ExamOptimizer {

        private int[] fullTime;
        private int[] fullMarks;
        private int[] partialTime;
        private int[] partialMarks;

        public ExamOptimizer(int[] fullTime, int[] fullMarks, int[] partialTime, int[] partialMarks) {
            this.fullTime = fullTime;
            this.fullMarks = fullMarks;
            this.partialTime = partialTime;
            this.partialMarks = partialMarks;
        }

        public int maximizeMarks(int T) {
            int n = fullTime.length;

            int[][] dp = new int[n][T + 1];

            // Base case initialization
            for (int j = 1; j <= T; j++) {
                if (j < partialTime[0]) {
                    dp[0][j] = 0;
                } else if (j >= partialTime[0] && j < fullTime[0]) {
                    dp[0][j] = partialMarks[0];
                } else {
                    dp[0][j] = fullMarks[0];
                }
            }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j <= T; j++) {
                    if (j < partialTime[i]) {
                        dp[i][j] = dp[i - 1][j];
                    } else if (j >= partialTime[i] && j < fullTime[i]) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - partialTime[i]] + partialMarks[i]);
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j],
                                Math.max(dp[i - 1][j - partialTime[i]] + partialMarks[i],
                                        dp[i - 1][j - fullTime[i]] + fullMarks[i]));
                    }
                }
            }

            return dp[n - 1][T];
        }

        public static void main(String[] args) {
            int[] fullTime = {3, 5, 2};
            int[] fullMarks = {10, 15, 7};
            int[] partialTime = {2, 3, 1};
            int[] partialMarks = {5, 8, 4};

            ExamOptimizer examOptimizer = new ExamOptimizer(fullTime, fullMarks, partialTime, partialMarks);
            int maxMarks = examOptimizer.maximizeMarks(8);  // Sample Time constraint
            System.out.println("Maximum Marks: " + maxMarks);
        }
    }

}
