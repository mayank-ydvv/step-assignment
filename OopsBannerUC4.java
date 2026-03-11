/**
 * UC4 - String Arrays and Looping Structures
 *
 * Drawback of UC3:
 * - UC3 still required individual variables for each banner line.
 * - This makes the code repetitive and harder to maintain or scale.
 *
 * UC4 Solution:
 * - Store all banner lines in a String array (centralized data structure).
 * - Use an enhanced for-loop to iterate and print each line.
 * - This improves modularity, reusability, and maintainability.
 *
 * Key Java Concepts Used:
 * - String array population
 * - String.join() method
 * - Enhanced for-loop (for-each)
 */
public class OopsBannerUC4 {

    /**
     * Builds the "OOPS" banner lines and stores them in a String array.
     * Uses String.join() to populate each row from individual character segments.
     *
     * @return String array where each element is one line of the banner
     */
    public static String[] buildBannerLines() {

        // UC4: Store all banner lines in a centralized String array
        // Each line is built using String.join() for memory efficiency (from UC3)
        String[] bannerLines = new String[7];

        bannerLines[0] = "=".repeat(44); // top border
        bannerLines[1] = String.join("   ", " OOO ", " OOO ", "PPPP ", "SSSS ");
        bannerLines[2] = String.join("   ", "O   O", "O   O", "P   P", "S    ");
        bannerLines[3] = String.join("   ", "O   O", "O   O", "PPPP ", " SSS ");
        bannerLines[4] = String.join("   ", "O   O", "O   O", "P    ", "    S");
        bannerLines[5] = String.join("   ", " OOO ", " OOO ", "P    ", "SSSS ");
        bannerLines[6] = "=".repeat(44); // bottom border

        return bannerLines;
    }

    /**
     * Prints the banner by iterating over the String array using an enhanced for-loop.
     * UC4 replaces multiple individual print statements with a single reusable loop.
     *
     * @param bannerLines the array of banner lines to print
     */
    public static void printBanner(String[] bannerLines) {

        // UC4: Enhanced for-loop replaces repetitive individual print statements
        for (String line : bannerLines) {
            System.out.println(line);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== UC4: OOPS Banner with String Array + Enhanced For-Loop =====");
        System.out.println();

        // Step 1: Build the banner — stored in a String array
        String[] bannerLines = buildBannerLines();

        // Step 2: Print the banner — using a loop (no repetitive print statements)
        printBanner(bannerLines);

        System.out.println();

        // Demonstrate modularity — easily reuse to print the banner multiple times
        System.out.println("Banner printed again to show reusability:");
        System.out.println();
        printBanner(bannerLines);

        System.out.println();
        System.out.println("--- UC4 Key Improvements over UC3 ---");
        System.out.println("1. Banner lines stored in a String[] array (centralized data structure)");
        System.out.println("2. Enhanced for-loop replaces repetitive individual print statements");
        System.out.println("3. String.join() retained for memory efficiency");
        System.out.println("4. printBanner() is reusable — call it anywhere without duplicating code");
        System.out.println("5. Adding/changing a banner line only requires editing the array");
    }
}
