/**
 * UC4: Display "Hello" with Multiple Command-Line Arguments
 *
 * Description:
 *   The app accepts multiple names as command-line arguments and displays
 *   a personalized greeting for ALL names. If no names are provided,
 *   it defaults to "World".
 *
 * Branch: feature/UC4-display-multiple-names
 *
 * How to compile and run:
 *   javac HelloApp.java
 *   java HelloApp                    --> Hello, World!
 *   java HelloApp Alice              --> Hello, Alice!
 *   java HelloApp Alice Bob Charlie  --> Hello, Alice!
 *                                        Hello, Bob!
 *                                        Hello, Charlie!
 *
 * Maven:
 *   mvn compile
 *   mvn exec:java -Dexec.mainClass="HelloApp"
 *   mvn exec:java -Dexec.mainClass="HelloApp" -Dexec.args="Alice Bob Charlie"
 */
public class HelloApp {

    public static void main(String[] args) {

        // UC4: Check if any command-line arguments were provided
        if (args.length == 0) {
            // No arguments provided — default to "World"
            System.out.println("Hello, World!");
        } else {
            // Loop through ALL provided names and greet each one
            for (String name : args) {
                System.out.println("Hello, " + name + "!");
            }
        }
    }
}
