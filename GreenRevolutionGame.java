import java.util.*;

class Resource {
    int id, activationCost, periodicCost, activeTurns, downtime, lifeCycle, powerCapacity;
    char type;
    int effect;

    public Resource(int id, int activationCost, int periodicCost, int activeTurns, int downtime,
                    int lifeCycle, int powerCapacity, char type, int effect) {
        this.id = id;
        this.activationCost = activationCost;
        this.periodicCost = periodicCost;
        this.activeTurns = activeTurns;
        this.downtime = downtime;
        this.lifeCycle = lifeCycle;
        this.powerCapacity = powerCapacity;
        this.type = type;
        this.effect = effect;
    }
}

public class GreenRevolutionGame {
    static int budget, numResources, numTurns;
    static List<Resource> resources = new ArrayList<>();
    static List<int[]> turns = new ArrayList<>();
    static List<String> output = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read initial budget, number of resources, and turns
        budget = scanner.nextInt();
        numResources = scanner.nextInt();
        numTurns = scanner.nextInt();

        // Read resources
        for (int i = 0; i < numResources; i++) {
            int id = scanner.nextInt();
            int activationCost = scanner.nextInt();
            int periodicCost = scanner.nextInt();
            int activeTurns = scanner.nextInt();
            int downtime = scanner.nextInt();
            int lifeCycle = scanner.nextInt();
            int powerCapacity = scanner.nextInt();
            char type = scanner.next().charAt(0);
            int effect = scanner.nextInt();

            resources.add(new Resource(id, activationCost, periodicCost, activeTurns, downtime, lifeCycle, powerCapacity, type, effect));
        }

        // Read turns
        for (int i = 0; i < numTurns; i++) {
            int TM = scanner.nextInt();
            int TX = scanner.nextInt();
            int TR = scanner.nextInt();
            turns.add(new int[]{TM, TX, TR});
        }

        scanner.close();

        // Solve the game
        simulateGame();

        // Print the output in the required format
        for (String line : output) {
            System.out.println(line);
        }
    }

    private static void simulateGame() {
        List<Resource> activeResources = new ArrayList<>();
        int totalProfit = 0;

        for (int t = 0; t < numTurns; t++) {
            int TM = turns.get(t)[0];
            int TX = turns.get(t)[1];
            int TR = turns.get(t)[2];

            // Step 1: Remove expired resources
            Iterator<Resource> iterator = activeResources.iterator();
            while (iterator.hasNext()) {
                Resource r = iterator.next();
                r.lifeCycle--;
                if (r.lifeCycle <= 0) {
                    iterator.remove(); // Remove expired resources
                }
            }

            // Step 2: Calculate current power capacity
            int totalPower = activeResources.stream().mapToInt(r -> r.powerCapacity).sum();

            // Step 3: If not enough power, buy new resources
            List<Integer> purchasedResources = new ArrayList<>();
            while (totalPower < TM) {
                Resource bestResource = findBestResource();
                if (bestResource == null || budget < bestResource.activationCost) break;

                budget -= bestResource.activationCost;
                activeResources.add(new Resource(bestResource.id, bestResource.activationCost,
                        bestResource.periodicCost, bestResource.activeTurns, bestResource.downtime,
                        bestResource.lifeCycle, bestResource.powerCapacity, bestResource.type, bestResource.effect));
                totalPower += bestResource.powerCapacity;
                purchasedResources.add(bestResource.id);
            }

            // Step 4: Apply periodic costs
            int totalMaintenance = activeResources.stream().mapToInt(r -> r.periodicCost).sum();
            budget -= totalMaintenance;

            // Step 5: Calculate profit
            if (totalPower >= TM) {
                int buildingsPowered = Math.min(totalPower, TX);
                int turnProfit = buildingsPowered * TR;
                totalProfit += turnProfit;
                budget += turnProfit;
            }

            // Step 6: Store output for purchases
            if (!purchasedResources.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append(t).append(" ").append(purchasedResources.size());
                for (int id : purchasedResources) {
                    sb.append(" ").append(id);
                }
                output.add(sb.toString());
            }
        }
    }

    private static Resource findBestResource() {
        return resources.stream()
                .filter(r -> r.activationCost <= budget)
                .max(Comparator.comparingInt(r -> r.powerCapacity / Math.max(1, r.activationCost))) // Best cost-to-power ratio
                .orElse(null);
    }
}
