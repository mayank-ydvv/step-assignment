/**
 * UC3: Display "Hello" with Command-Line Argument or Default Message
 *
 * Description:
 *   The app accepts a user's name as a command-line argument and displays
 *   a personalized greeting. If no name is provided, it defaults to "World".
 *
 * Branch: feature/UC3-display-name-default
 *
 * How to compile and run:
 *   javac HelloApp.java
 *   java HelloApp          --> Hello, World!
 *   java HelloApp Alice    --> Hello, Alice!
 *
 * Maven:
 *   mvn compile
 *   mvn exec:java -Dexec.mainClass="HelloApp"
 *   mvn exec:java -Dexec.mainClass="HelloApp" -Dexec.args="Alice"
 */
public class HelloApp {

    public static void main(String[] args) {

        // UC3: Check if a command-line argument was provided
        // If args array has at least one element, use args[0] as the name
        // Otherwise, default to "World"
        String name = (args.length > 0) ? args[0] : "World";

        // Display the personalized greeting
        System.out.println("Hello, " + name + "!");
    }
}
