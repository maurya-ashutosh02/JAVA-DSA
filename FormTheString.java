import java.util.*;

public class FormTheString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Number of substrings
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        // List to store substrings and their  costofString
        List<String> substrings = new ArrayList<>();
        List<Integer>  costofString = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            substrings.add(parts[0]);
             costofString.add(Integer.parseInt(parts[1]));
        }

        // Input: Main string
        String mainString = sc.nextLine();

        int m = mainString.length();
        int[] dp = new int[m + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; 
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                String sub = substrings.get(j);
                int cost =  costofString.get(j);

                
                if (i >= sub.length() && mainString.substring(i - sub.length(), i).equals(sub)) {
                    dp[i] = Math.min(dp[i], dp[i - sub.length()] + cost);
                }
            }
        }

       
        if (dp[m] == Integer.MAX_VALUE) {
            System.out.println("Impossible");
        } else {
            System.out.println(dp[m]);
        }
    }
}

