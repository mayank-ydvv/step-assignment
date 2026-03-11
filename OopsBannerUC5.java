/**
 * UC5 - Array Initialisation
 *
 * Drawback of UC4:
 * - UC4 declared the array first, then populated each element individually
 *   using separate assignment statements (bannerLines[0] = ..., bannerLines[1] = ...).
 * - This is verbose and less concise.
 *
 * UC5 Solution:
 * - Combine array declaration AND initialization with String.join() calls
 *   in a single streamlined statement using array initializer syntax {}.
 * - Eliminates the need for separate population statements entirely.
 *
 * Key Java Concepts Used:
 * - Array initializer syntax (declare + populate in one statement)
 * - String.join() embedded directly inside the array initializer
 * - Enhanced for-loop for clean output traversal
 */
public class OopsBannerUC5 {

    /**
     * Builds the "OOPS" banner using a single array declaration + initialization statement.
     * String.join() calls are embedded directly inside the array initializer {}.
     *
     * UC4 way (verbose):
     *   String[] lines = new String[7];
     *   lines[0] = "...";
     *   lines[1] = String.join(...);
     *   ...
     *
     * UC5 way (concise):
     *   String[] lines = { "...", String.join(...), String.join(...), ... };
     *
     * @return String array of banner lines, declared and initialized in one statement
     */
    public static String[] buildBannerLines() {

        // UC5: Single statement — array declaration + initialization with String.join() inline
        String[] bannerLines = {
            "=".repeat(44),
            String.join("   ", " OOO ", " OOO ", "PPPP ", "SSSS "),
            String.join("   ", "O   O", "O   O", "P   P", "S    "),
            String.join("   ", "O   O", "O   O", "PPPP ", " SSS "),
            String.join("   ", "O   O", "O   O", "P    ", "    S"),
            String.join("   ", " OOO ", " OOO ", "P    ", "SSSS "),
            "=".repeat(44)
        };

        return bannerLines;
    }

    /**
     * Prints each line of the banner using an enhanced for-loop.
     *
     * @param bannerLines the initialized array of banner lines
     */
    public static void printBanner(String[] bannerLines) {
        // Enhanced for-loop — clean, readable output traversal
        for (String line : bannerLines) {
            System.out.println(line);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== UC5: OOPS Banner with Array Initialisation =====");
        System.out.println();

        // Single call to build (array declared + initialised in one statement inside)
        String[] bannerLines = buildBannerLines();

        // Print using enhanced for-loop
        printBanner(bannerLines);

        System.out.println();
        System.out.println("--- UC5 Key Improvements over UC4 ---");
        System.out.println("UC4: Array declared first, then each element assigned separately.");
        System.out.println("UC5: Array declared AND initialized in one concise statement.");
        System.out.println("     String.join() calls embedded directly in the array initializer {}.");
        System.out.println("     No separate assignment lines needed — cleaner and more readable.");
    }
}
