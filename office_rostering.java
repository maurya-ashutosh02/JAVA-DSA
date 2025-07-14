import java.util.*;

public class office_rostering {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Number of employees and friendships
        int N = sc.nextInt(); // Number of employees
        int M = sc.nextInt(); // Number of friendships

        // Adjacency list to represent friendships
        List<List<Integer>> friends = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            friends.add(new ArrayList<>());
        }

        // Input friendships
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            friends.get(a).add(b);
            friends.get(b).add(a);
        }

        // Rostering value target
        int K = sc.nextInt();

        // Initialize statuses: 1 = WFO, 0 = WFH
        int[] statuses = new int[N];
        Arrays.fill(statuses, 1); // Day 1: Everyone starts WFO

        // Initialize rostering count and day tracker
        int totalRosters = N; // Rostering value on Day 1
        int days = 1;

        // Simulate until rostering value reaches K
        while (totalRosters < K) {
            int[] nextStatuses = new int[N];
            int dailyWFO = 0;

            for (int i = 0; i < N; i++) {
                int wfoFriends = 0;
                for (int friend : friends.get(i)) {
                    if (statuses[friend] == 1) {
                        wfoFriends++;
                    }
                }

                // Update next status based on rules
                if (statuses[i] == 1) { // WFO today
                    if (wfoFriends == 3) {
                        nextStatuses[i] = 1; // Continue WFO
                        dailyWFO++;
                    } else {
                        nextStatuses[i] = 0; // Switch to WFH
                    }
                } else { // WFH today
                    if (wfoFriends < 3) {
                        nextStatuses[i] = 1; // Switch to WFO
                        dailyWFO++;
                    } else {
                        nextStatuses[i] = 0; // Continue WFH
                    }
                }
            }

            // Update rostering value and prepare for next day
            totalRosters += dailyWFO;
            statuses = nextStatuses; // Move to the next day
            days++;

            // Safety check to avoid infinite loop in rare cases
            if (days > 1000) { // Arbitrary large limit
                    return;
            }
        }

        // Output the number of days required
        System.out.println(days);
    }
}
