import java.util.*;

public class help_Ritika {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline
        List<String> substrings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            substrings.add(sc.nextLine());
        }
        String mainString = sc.nextLine();
        int k = sc.nextInt();

        int m = mainString.length();
        int[] dp = new int[m + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // To track the farthest point in the main string we can form
        int maxLength = 0;

        for (int i = 0; i < m; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;

            for (String sub : substrings) {
                int deletions = 0, j = i, subIndex = 0;

                // Check how far we can match the main string with the current substring
                while (j < m && subIndex < sub.length()) {
                    if (mainString.charAt(j) == sub.charAt(subIndex)) {
                        j++;
                        subIndex++;
                    } else {
                        deletions++;
                        subIndex++;
                    }
                }

                // If the substring is used and matches a portion of the main string
                if (subIndex == sub.length()) {
                    int lengthFormed = j - i;
                    if (dp[i] + deletions <= k) {
                        dp[j] = Math.min(dp[j], dp[i] + deletions);
                        maxLength = Math.max(maxLength, j);
                    }
                }
            }
        }

        // Output the result based on how far we could form the main string
        if (dp[m] <= k) {
            System.out.println("Possible");
        } else if (maxLength == 0) {
            System.out.println("Nothing");
        } else if (maxLength < m) {
            System.out.println(mainString.substring(0, maxLength));
        } else {
            System.out.println("Impossible");
        }
    }
}
