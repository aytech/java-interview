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
}
