import java.util.*;

public class segmentdisplay {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input (simulating sys.stdin.read())
        List<String> data = new ArrayList<>();
        while (scanner.hasNextLine()) {
            data.add(scanner.nextLine());
        }

        // Define alphabet patterns
        Map<String, String> alphabetPatterns = new HashMap<>();
        alphabetPatterns.put("A", "111111001010010111111100010001000010001");
        alphabetPatterns.put("B", "111111001010010111111100010001111111");
        alphabetPatterns.put("C", "111110000010000100001000010000111110");
        alphabetPatterns.put("D", "111111001010010010010100101001111111");
        alphabetPatterns.put("E", "111111000010000100001111110000111111");
        alphabetPatterns.put("F", "111111000010000100001111110000100000");
        alphabetPatterns.put("G", "111110000010000100001111110001100011");
        alphabetPatterns.put("H", "1000110001101111111000110001100010001");
        alphabetPatterns.put("I", "111110010000100001100001000010111110");
        alphabetPatterns.put("J", "111110000100000110001100011111100001");
        alphabetPatterns.put("K", "1000110010101001100001111100010001100");
        alphabetPatterns.put("L", "100001000010000100001000010001111111");
        alphabetPatterns.put("M", "111111101011101010101010101000101010");
        alphabetPatterns.put("N", "100011100101101101011100011101010101");
        alphabetPatterns.put("O", "011101000100010001000100010001000111");
        alphabetPatterns.put("P", "111111001010010111111100010000100000");
        alphabetPatterns.put("Q", "111111001010010111111100010000111000");
        alphabetPatterns.put("R", "111111001010010111111100011101000100");
        alphabetPatterns.put("S", "111111000010000100001111111000011111");
        alphabetPatterns.put("T", "111110010000100001000010100000000001");
        alphabetPatterns.put("U", "100010001000100010001000010001111111");
        alphabetPatterns.put("V", "100010001000100010001000101000010100");
        alphabetPatterns.put("W", "100010001000100010001010101010111111");
        alphabetPatterns.put("X", "100010000010101000000010100001010001");
        alphabetPatterns.put("Y", "100010001000100010001111100000010001");
        alphabetPatterns.put("Z", "111111000010100001000010100001111111");

        // Convert patterns to a single string for easier comparison
        for (String key : alphabetPatterns.keySet()) {
            StringBuilder sb = new StringBuilder();
            String pattern = alphabetPatterns.get(key);
            for (int i = 0; i < pattern.length(); i++) {
                sb.append(pattern.charAt(i));
            }
            alphabetPatterns.put(key, sb.toString());
        }

        // Define variables for processing
        int cols = data.get(0).length();
        List<Character> result = new ArrayList<>();

        // Start processing each segment
        int i = 0;
        while (i < cols) {
            StringBuilder subGrid = new StringBuilder();
            for (String row : data) {
                subGrid.append(row.substring(i, Math.min(i + 5, cols)));
            }

            // If the subgrid is all zeros, skip it
            if (subGrid.toString().equals("00000")) {
                i++;
                continue;
            }

            // Check for matching patterns
            String flattened = subGrid.toString();
            boolean matched = false;
            for (Map.Entry<String, String> entry : alphabetPatterns.entrySet()) {
                if (flattened.equals(entry.getValue())) {
                    result.add(entry.getKey().charAt(0));
                    matched = true;
                    break;
                }
            }

            if (matched) {
                i += 5; // Move 5 characters forward after a match
            } else {
                i++; // If no match, just move 1 character forward
            }
        }

        // Print the result
        for (Character c : result) {
            System.out.print(c);
        }
    }
}
