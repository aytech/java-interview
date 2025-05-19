public class BeginnerLevel {
    public static void main(String[] args) {
        System.out.println("Beginner - task one: ");
        beginnerQuestionOne();
        System.out.println("\nBeginner - task two: ");
        beginnerQuestionTwo();
        System.out.println("\nBeginner - task three: ");
        beginnerQuestionThree();
        System.out.println("\nBeginner - task four: ");
        beginnerQuestionFour();
        System.out.println("\nBeginner - task five: ");
        beginnerQuestionFive();
        System.out.println("\nBeginner - task six: ");
        beginnerQuestionSix();
    }

    /**
     * Task for Junior developer
     * - What is the output of the following code?
     **/
    private static void beginnerQuestionOne() {
        int x = 10;
        if (x > 5) {
            int y = 20;
            System.out.println(x + y);
        }
        System.out.println(x);
    }

    /**
     * Task for a Junior developer, uncomment on the interview
     * - What is wrong with the following code?
     */
    private static void beginnerQuestionTwo() {
        // int[] numbers = {1, 2, 3, 4, 5};
        // System.out.println(numbers[5]);
        System.out.println("\tNo output, fix code with the interviewee");
    }

    /**
     * Task for a Junior developer, uncomment on the interview
     * - What is wrong with the following code?
     */
    private static void beginnerQuestionThree() {
        // int x = 3.14;
        //System.out.println(x);
        System.out.println("\tNo output, fix code with the interviewee");
    }

    /**
     * Task for Junior developer
     * - What is the output of the following code?
     */
    private static void beginnerQuestionFour() {
        int dayOfWeek = 3;
        String day = switch (dayOfWeek) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            default -> "Unknown";
        };
        System.out.println(day);
    }

    /**
     * Task for Junior developer
     * - What is wrong with the following code?
     */
    private static void beginnerQuestionFive() {
        String s1 = "Java";
        String s2 = "Java";
        if (s1 == s2) {
            System.out.println("Strings are equal");
        } else {
            System.out.println("Strings are not equal");
        }
    }

    /**
     * Task for Junior developer
     * - Find issue with the following code
     */
    private static void beginnerQuestionSix() {
        // String text;
        // int length = text.length();
        // System.out.println("The length of the text is: " + length);
        System.out.println("\tNo output, fix code with the interviewee");
    }
}
