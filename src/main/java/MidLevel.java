import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

// https://codeinterview.io/blog/java-coding-interview-questions/
public class MidLevel {
    public static void main(String[] args) {
        System.out.println("Mid level engineer - task one (thread synchronisation): ");
        midLevelQuestionOne();
        System.out.println("\nMid level engineer - task two (method overloading): ");
        midLevelQuestionTwo();
        System.out.println("\nMid level engineer - task four (CompletableFuture + Factorial): ");
        System.out.println(calculateFactorials(List.of(1, 2, 3, 4)));

//        midLevelQuestionFour();
    }

    /**
     * Task for middle level engineer
     * - What is wrong with the following code?
     * - Fix the code
     * - Solution:
     *      - add synchronized to the increment and count methods
     *      - wait for both threads to finish before printing the count
     *      - See <a href="https://www.geeksforgeeks.org/synchronization-in-java/">...</a>
     */
    private static void midLevelQuestionOne() {
        Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        t1.start();
        t2.start();

        System.out.println("Counter: " + counter.getCount());
    }

    /**
     * Task for middle level engineer
     * - What is the output of the following code?
     */
    private static void midLevelQuestionTwo() {
        int a = 5;
        Integer b = 10;
        print(a);
        print(b);
    }

    /**
     * Task for middle level engineer
     * - Write a Java method that takes a list of integer as input and returns a list
     * of their factorials using CompletableFuture for asynchronous computation.
     * Method signature should be like the method below
     * - @note: Implementation should be done by the interviewee
     */
    public static List<BigInteger> calculateFactorials(List<Integer> input) {
        Factorial factorial = new Factorial();
        try {
            return CompletableFuture.supplyAsync(() -> {
                List<BigInteger> factorials = new ArrayList<>();
                for (Integer num : input) {
                    factorials.add(factorial.factorialBigInteger(num));
                }
                return factorials;
            }).get();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException: " + e.getMessage());
        } catch (ExecutionException e) {
            System.out.println("ExecutionException: " + e.getMessage());
        }
        return null;
        // 266 013 456 - fin urad.
    }

    private static void print(int a) {
        System.out.println("int: " + a);
    }

    private static void print(Integer a) {
        System.out.println("Integer: " + a);
    }
}

class Counter {
    private int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
