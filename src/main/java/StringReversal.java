import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Implement a function that reverses a string.
 * For example, given the string "This is a string", the function should return "gnirts a si sihT".
 * Solution:
 * - see commented code, do not present to candidate
 * - more examples at https://www.baeldung.com/java-reverse-string
 */
public class StringReversal {

    public static void main(String[] args) {
        String src = "This is a string";
        String expectedResult = "gnirts a si sihT";
        String result = reverse(src);
        System.out.println("String was reversed: " + result.equals(expectedResult));
        // Solutions
        String resultTraditional = reverseTraditionalLoop(src);
        System.out.println("String was reversed using traditional loop: " + resultTraditional.equals(expectedResult));

        String resultSB = reverseUsingStringBuilder(src);
        System.out.println("String was reversed using StringBuilder: " + resultSB.equals(expectedResult));

        String resultStream = reverseStream(src);
        System.out.println("String was reversed using Stream: " + resultStream.equals(expectedResult));

        String resultStreamOf = reverseStreamOf(src);
        System.out.println("String was reversed using Stream.of: " + resultStreamOf.equals(expectedResult));

        String resultStringChars = reverseStringChars(src);
        System.out.println("String was reversed using String.chars: " + resultStringChars.equals(expectedResult));

        String resultWordsOrder = reverseWordsOrder(src);
        System.out.println("String words were reversed: " + resultWordsOrder.equals("string a is This"));
    }

    private static String reverse(String src) {
        char[] arr = src.toCharArray();
        // TODO your implementation here (solution code)
        return String.valueOf(arr);
    }

    private static String reverseTraditionalLoop(String src) {
        char[] arr = src.toCharArray();
        for (int i = src.length() - 1; i >= 0; i--) {
            arr[src.length() - 1 - i] = src.charAt(i);
        }
        return String.valueOf(arr);
    }

    private static String reverseUsingStringBuilder(String src) {
        return new StringBuilder(src).reverse().toString();
    }

    private static String reverseStream(String src) {
        if (src == null) {
            return null;
        }

        char[] charArray = src.toCharArray();
        return IntStream.range(0, src.length())
                .mapToObj(i -> charArray[src.length() - i - 1])
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    private static String reverseStreamOf(String src) {
        if (src == null) {
            return null;
        }
        return Stream.of(src)
                .map(string -> new StringBuilder(string).reverse())
                .collect(Collectors.joining());
    }

    private static String reverseStringChars(String src) {
        if (src == null) {
            return null;
        }
        return src.chars()
                .mapToObj(c -> (char) c)
                .reduce("", (a, b) -> b + a, (a2, b2) -> b2 + a2);
    }

    private static String reverseWordsOrder(String src) {
        if (src == null) {
            return null;
        }
        StringBuilder output = new StringBuilder();
        String[] words = src.split(" ");

        for (int i = words.length - 1; i >= 0; i--) {
            output.append(words[i]);
            output.append(" ");
        }

        return output.toString().trim();
    }
}
