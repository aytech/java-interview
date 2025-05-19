import com.google.common.math.BigIntegerMath;
import org.apache.commons.math3.util.CombinatoricsUtils;

import java.math.BigInteger;
import java.util.stream.LongStream;

// https://www.baeldung.com/java-calculate-factorial
public class Factorial {
    /**
     * Task for middle level engineer
     * - Calculates factorial using a simple loop.
     * - Works for numbers up to 20, further numbers do not fit into long.
     * @param n Integer to calculate factorial for
     * @return Factorial of n
     */
    long factorialSimpleLoop(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    /**
     * Task for middle level engineer
     * - Calculates factorial using Java 8 Streams.
     * - Works for numbers up to 20, further numbers do not fit into long.
     * @param n Integer to calculate factorial for
     * @return Factorial of n
     */
    public static long factorialSteam(int n) {
        return LongStream.rangeClosed(1, n).reduce(1, (x, y) -> x * y);
    }

    /**
     * Task for middle level engineer
     * - Calculates factorial using recursion.
     * - Works for numbers up to 20, further numbers do not fit into long.
     * @param n Integer to calculate factorial for
     * @return Factorial of n
     */
    public static long factorialRecursion(int n) {
        if (n <= 2) {
            return n;
        }
        return n * factorialRecursion(n - 1);
    }
    /**
     * Task for middle level engineer
     * - Calculates factorial using Apache Commons Math.
     * - Works for numbers up to 20, further numbers do not fit into long.
     * @param n Integer to calculate factorial for
     * @return Factorial of n
     */
    public static long factorialApacheCommonsMath(int n) {
        return CombinatoricsUtils.factorial(n);
    }

    /**
     * Task for middle level engineer
     * - Calculates factorial using BigInteger.
     * - Works for numbers greater than 20.
     * @param n Integer to calculate factorial for
     * @return Factorial of n
     */
    BigInteger factorialBigInteger(int n) {
        BigInteger fact = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }

    /**
     * Task for middle level engineer
     * - Calculates factorial using Guava.
     * - Works for numbers greater than 20.
     * @param n Integer to calculate factorial for
     * @return Factorial of n
     */
    public static BigInteger factorialGuava(int n) {
        return BigIntegerMath.factorial(n);
    }
}
