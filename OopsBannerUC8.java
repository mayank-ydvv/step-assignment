import java.util.HashMap;

/**
 * UC8 - HashMap for Centralized Character Pattern Storage
 *
 * Drawback of UC7:
 * - UC7 manually created CharacterPatternMap objects and retrieved them via linear search.
 * - Cumbersome and error-prone when scaling to more characters.
 *
 * UC8 Solution:
 * - Use a HashMap<Character, String[]> to store character-to-pattern mappings.
 * - HashMap provides O(1) key-based lookup — no manual searching needed.
 * - Centralized pattern registry: easy to add/remove characters without changing display logic.
 * - Separation of pattern storage and display logic (advanced OOP principle).
 *
 * Key Java Concepts Used:
 * - HashMap<Character, String[]> for pattern storage and retrieval
 * - HashMap.put() to register character patterns
 * - HashMap.get() for efficient pattern lookup
 * - StringBuilder for row assembly within nested loops
 * - Separation of concerns: storage vs display logic
 */
public class OopsBannerUC8 {

    // ---------------------------------------------------------------
    // Pattern Registry — HashMap stores all character-to-pattern mappings
    // ---------------------------------------------------------------

    /**
     * Builds and returns a HashMap containing ASCII art patterns for each character.
     * Key   = Character (e.g. 'O', 'P', 'S')
     * Value = String[] of 5 rows forming the ASCII art
     *
     * UC8 key concept: centralized registry replaces scattered helper methods.
     * Adding a new character = one new HashMap.put() call. No other code changes needed.
     *
     * @return HashMap<Character, String[]> pattern registry
     */
    public static HashMap<Character, String[]> buildPatternRegistry() {

        HashMap<Character, String[]> registry = new HashMap<>();

        // Register pattern for 'O'
        registry.put('O', new String[]{
            " OOO ",
            "O   O",
            "O   O",
            "O   O",
            " OOO "
        });

        // Register pattern for 'P'
        registry.put('P', new String[]{
            "PPPP ",
            "P   P",
            "PPPP ",
            "P    ",
            "P    "
        });

        // Register pattern for 'S'
        registry.put('S', new String[]{
            "SSSS ",
            "S    ",
            " SSS ",
            "    S",
            "SSSS "
        });

        return registry;
    }

    // ---------------------------------------------------------------
    // Banner Builder — uses HashMap.get() for pattern retrieval
    // ---------------------------------------------------------------

    /**
     * Builds the OOPS banner using the pattern registry.
     * For each row of the banner, looks up each character's pattern via HashMap.get()
     * and assembles the row using StringBuilder.
     *
     * @param word     the word to render as a banner (e.g. "OOPS")
     * @param registry the HashMap containing character-to-pattern mappings
     * @return String[] of complete banner lines
     */
    public static String[] buildBannerLines(String word,
                                             HashMap<Character, String[]> registry) {

        int height = 5; // each ASCII character pattern is 5 rows tall
        String border = "=".repeat(word.length() * 9);

        String[] bannerLines = new String[height + 2];
        bannerLines[0] = border;

        // Outer loop: iterate over each row (0 to 4)
        for (int row = 0; row < height; row++) {
            StringBuilder sb = new StringBuilder();

            // Inner loop: iterate over each character in the word
            for (int col = 0; col < word.length(); col++) {
                char ch = word.charAt(col);

                // UC8 key: HashMap.get() retrieves pattern in O(1) — no linear search
                String[] pattern = registry.get(ch);

                if (pattern != null) {
                    sb.append(pattern[row]);
                } else {
                    sb.append("?????"); // fallback if character not in registry
                }

                if (col < word.length() - 1) {
                    sb.append("   "); // spacing between characters
                }
            }

            bannerLines[row + 1] = sb.toString();
        }

        bannerLines[height + 1] = border;
        return bannerLines;
    }

    /**
     * Prints each line of the banner using an enhanced for-loop.
     *
     * @param bannerLines the assembled banner lines
     */
    public static void printBanner(String[] bannerLines) {
        for (String line : bannerLines) {
            System.out.println(line);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== UC8: OOPS Banner with HashMap Pattern Registry =====");
        System.out.println();

        // Step 1: Build the centralized HashMap pattern registry
        HashMap<Character, String[]> registry = buildPatternRegistry();

        // Step 2: Build the banner for "OOPS" using HashMap lookups
        String[] bannerLines = buildBannerLines("OOPS", registry);

        // Step 3: Print the banner
        printBanner(bannerLines);

        System.out.println();

        // Demonstrate scalability — render a different word using the same registry
        System.out.println("Scalability demo — rendering 'POOP' with the same registry:");
        System.out.println();
        printBanner(buildBannerLines("POOP", registry));

        System.out.println();
        System.out.println("--- UC8 Key Improvements over UC7 ---");
        System.out.println("UC7: Manual CharacterPatternMap objects + linear search to retrieve.");
        System.out.println("UC8: HashMap<Character, String[]> — O(1) key-based pattern lookup.");
        System.out.println("     registry.put('O', pattern) registers a character.");
        System.out.println("     registry.get(ch) retrieves it instantly — no searching.");
        System.out.println("     Display logic (buildBannerLines) works for ANY word in registry.");
        System.out.println("     Adding new characters = one put() call, zero logic changes.");
        System.out.println("     Separation of storage and display — advanced OOP principle.");
    }
}
