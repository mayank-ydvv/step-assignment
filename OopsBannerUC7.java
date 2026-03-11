/**
 * UC7 - Object-Oriented Structure with CharacterPattern Class
 *
 * Drawback of UC6:
 * - UC6 used separate static helper methods for each character (getO, getP, getS).
 * - Requires explicit method calls for every character in the word.
 * - Lacks centralized pattern management — hard to scale when adding new characters.
 *
 * UC7 Solution:
 * - Create a dedicated inner static class: CharacterPatternMap
 * - Encapsulates a character and its corresponding ASCII art pattern together.
 * - Uses constructors and getters for proper OOP data management.
 * - Uses StringBuilder for efficient banner row assembly.
 * - Follows Single Responsibility Principle and abstraction.
 *
 * Key Java Concepts Used:
 * - Static inner class (CharacterPatternMap)
 * - Constructor and getter methods
 * - StringBuilder for efficient string building
 * - Object-Oriented encapsulation, reusability, scalability
 * - Single Responsibility Principle (SRP)
 */
public class OopsBannerUC7 {

    // ---------------------------------------------------------------
    // Static Inner Class — CharacterPatternMap
    // Encapsulates a single character and its ASCII art pattern.
    // UC7 key concept: replaces fragmented static helper methods.
    // ---------------------------------------------------------------

    static class CharacterPatternMap {

        private char character;       // The letter this pattern represents (e.g. 'O')
        private String[] pattern;     // ASCII art lines for this character (5 rows)

        /**
         * Constructor — binds a character to its ASCII art pattern.
         *
         * @param character the letter this object represents
         * @param pattern   String array of 5 lines forming the ASCII art
         */
        public CharacterPatternMap(char character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        /**
         * Getter for the character.
         * @return the letter this pattern represents
         */
        public char getCharacter() {
            return character;
        }

        /**
         * Getter for a specific row of the ASCII pattern.
         * @param row index of the row (0-4)
         * @return the String for that row
         */
        public String getPatternRow(int row) {
            return pattern[row];
        }

        /**
         * Getter for the total number of rows in the pattern.
         * @return number of rows
         */
        public int getPatternHeight() {
            return pattern.length;
        }
    }

    // ---------------------------------------------------------------
    // Banner Builder — uses CharacterPatternMap objects
    // ---------------------------------------------------------------

    /**
     * Creates and returns the array of CharacterPatternMap objects for "OOPS".
     * Each object encapsulates a character + its ASCII pattern.
     * DRY: 'O' is defined once as a pattern, but used for both O's in OOPS.
     *
     * @return CharacterPatternMap[] for the word "OOPS"
     */
    public static CharacterPatternMap[] createOopsPatterns() {

        // Define each unique character pattern once
        String[] patternO = {
            " OOO ",
            "O   O",
            "O   O",
            "O   O",
            " OOO "
        };

        String[] patternP = {
            "PPPP ",
            "P   P",
            "PPPP ",
            "P    ",
            "P    "
        };

        String[] patternS = {
            "SSSS ",
            "S    ",
            " SSS ",
            "    S",
            "SSSS "
        };

        // Map each character in "OOPS" to its pattern object
        // DRY: 'O' pattern reused for both O positions
        CharacterPatternMap[] oopsPatterns = {
            new CharacterPatternMap('O', patternO),
            new CharacterPatternMap('O', patternO),
            new CharacterPatternMap('P', patternP),
            new CharacterPatternMap('S', patternS)
        };

        return oopsPatterns;
    }

    /**
     * Builds the full banner by iterating over rows and using StringBuilder
     * to efficiently assemble each horizontal row across all characters.
     *
     * @param patterns the CharacterPatternMap array for "OOPS"
     * @return String[] of complete banner lines ready to print
     */
    public static String[] buildBannerLines(CharacterPatternMap[] patterns) {

        int height = patterns[0].getPatternHeight(); // 5 rows
        String border = "=".repeat(44);

        // Total lines = border + 5 pattern rows + border
        String[] bannerLines = new String[height + 2];
        bannerLines[0] = border;

        // UC7: StringBuilder assembles each row efficiently
        for (int row = 0; row < height; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < patterns.length; col++) {
                sb.append(patterns[col].getPatternRow(row));
                if (col < patterns.length - 1) {
                    sb.append("   "); // spacing between characters
                }
            }
            bannerLines[row + 1] = sb.toString();
        }

        bannerLines[height + 1] = border;
        return bannerLines;
    }

    /**
     * Prints the banner using an enhanced for-loop.
     *
     * @param bannerLines assembled banner lines
     */
    public static void printBanner(String[] bannerLines) {
        for (String line : bannerLines) {
            System.out.println(line);
        }
    }

    public static void main(String[] args) {

        System.out.println("===== UC7: OOPS Banner with CharacterPatternMap Class =====");
        System.out.println();

        // Step 1: Create CharacterPatternMap objects for "OOPS"
        CharacterPatternMap[] patterns = createOopsPatterns();

        // Step 2: Build banner using StringBuilder row assembly
        String[] bannerLines = buildBannerLines(patterns);

        // Step 3: Print banner using enhanced for-loop
        printBanner(bannerLines);

        System.out.println();
        System.out.println("--- UC7 Key Improvements over UC6 ---");
        System.out.println("UC6: Separate static methods per character (getO, getP, getS).");
        System.out.println("UC7: CharacterPatternMap class encapsulates char + pattern together.");
        System.out.println("     Constructor binds character to its ASCII art pattern.");
        System.out.println("     Getters (getCharacter, getPatternRow) provide controlled access.");
        System.out.println("     StringBuilder efficiently assembles each banner row.");
        System.out.println("     Single Responsibility Principle: each class has one job.");
        System.out.println("     Easily scalable — add new characters without changing core logic.");
    }
}
