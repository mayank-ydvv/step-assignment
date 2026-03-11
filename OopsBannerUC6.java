/**
 * UC6 - Static Functions / Modular Programming
 *
 * Drawback of UC5:
 * - Inline array initialization still hardcodes all pattern strings directly.
 * - Reduces modularity — if you want to reuse or change a character's pattern,
 *   you have to hunt through the array and edit raw strings.
 *
 * UC6 Solution:
 * - Define dedicated static helper methods for each character: getO(), getP(), getS()
 * - Each method returns a String[] of lines for that character's ASCII pattern.
 * - These methods are invoked during array declaration to build the full banner.
 * - Follows the DRY (Don't Repeat Yourself) principle — "O" appears twice in
 *   "OOPS" but is defined only once in getO().
 *
 * Key Java Concepts Used:
 * - Static helper methods (encapsulation of character patterns)
 * - DRY principle (reuse getO() for both O's in OOPS)
 * - Loop-based rendering with enhanced for-loop
 * - Modular code composition and abstraction
 */
public class OopsBannerUC6 {

    // ---------------------------------------------------------------
    // Static Helper Methods — one per character
    // Each returns a String[] where each element is one row of the
    // character's ASCII art pattern (5 rows tall)
    // ---------------------------------------------------------------

    /**
     * Returns the ASCII art pattern for the letter 'O' as a String array.
     * DRY principle: defined once, reused for both O's in "OOPS".
     *
     * @return String[] of 5 lines representing 'O'
     */
    public static String[] getO() {
        return new String[] {
            " OOO ",
            "O   O",
            "O   O",
            "O   O",
            " OOO "
        };
    }

    /**
     * Returns the ASCII art pattern for the letter 'P' as a String array.
     *
     * @return String[] of 5 lines representing 'P'
     */
    public static String[] getP() {
        return new String[] {
            "PPPP ",
            "P   P",
            "PPPP ",
            "P    ",
            "P    "
        };
    }

    /**
     * Returns the ASCII art pattern for the letter 'S' as a String array.
     *
     * @return String[] of 5 lines representing 'S'
     */
    public static String[] getS() {
        return new String[] {
            "SSSS ",
            "S    ",
            " SSS ",
            "    S",
            "SSSS "
        };
    }

    // ---------------------------------------------------------------
    // Banner Builder — invokes static helper methods during population
    // ---------------------------------------------------------------

    /**
     * Builds the full "OOPS" banner by combining the character arrays row by row.
     * Invokes static helper methods getO(), getP(), getS() to retrieve patterns.
     * Uses String.join() to assemble each row across all 4 characters.
     *
     * @return String[] where each element is one complete horizontal row of the banner
     */
    public static String[] buildBannerLines() {

        // Retrieve each character's pattern via static helper methods (UC6 key concept)
        String[] o = getO();   // reused twice — DRY principle
        String[] p = getP();
        String[] s = getS();

        // Build the banner row by row — combine O, O, P, S side by side using String.join()
        String[] bannerLines = {
            "=".repeat(44),
            String.join("   ", o[0], o[0], p[0], s[0]),
            String.join("   ", o[1], o[1], p[1], s[1]),
            String.join("   ", o[2], o[2], p[2], s[2]),
            String.join("   ", o[3], o[3], p[3], s[3]),
            String.join("   ", o[4], o[4], p[4], s[4]),
            "=".repeat(44)
        };

        return bannerLines;
    }

    /**
     * Prints each line of the banner using an enhanced for-loop.
     *
     * @param bannerLines the fully assembled banner lines
     */
    public static void printBanner(String[] bannerLines) {
        for (String line : bannerLines) {
            System.out.println(line);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== UC6: OOPS Banner with Static Helper Methods =====");
        System.out.println();

        // Build and print the banner
        String[] bannerLines = buildBannerLines();
        printBanner(bannerLines);

        System.out.println();
        System.out.println("--- UC6 Key Improvements over UC5 ---");
        System.out.println("UC5: All patterns hardcoded inline in the array initializer.");
        System.out.println("UC6: Each character has its own static helper method.");
        System.out.println("     getO(), getP(), getS() encapsulate ASCII patterns.");
        System.out.println("     DRY principle: getO() is defined once, reused for both O's in OOPS.");
        System.out.println("     Changing a character only requires editing its own method.");
        System.out.println("     Better abstraction, modularity, and code composition.");
    }
}
