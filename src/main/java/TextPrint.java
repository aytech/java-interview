import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
/**
 * Task for Junior - Intermediate developer
 * This is the fixed code, original should be:
 * 1. Fix the following program
 * import java.io.*;
 *  public class Main {
 *      public static void main(String[] args) {
 *          writeFile();
 *      }
 *      private static void writeFile() {
 *       PrintWriter out = new PrintWriter(new FileOutputStream("output.txt"));
 *         for (int i = 0; i < 10000; i++) {
 *             out.println(i + ": This is a line of text.");
 *         }
 *      }
 *  }
 * 2. When it's running, add
 *  int numLines = countLines();
 *  System.out.println("Number of lines: " + numLines);
 *  private static int countLines() throws IOException {
 *      LineNumberReader reader = new LineNumberReader(new FileReader("output.txt"));
 *      int count = 0;
 *      while (reader.readLine() != null) {
 *          count++;
 *      }
 *          return count;
 *  }
 * 3. Why are there less than 10000 lines?  How could you fix it?
 * Solution:
 * The reason why lines are not written is because of buffer overflow,
 * so the "out" should be flushed. However, depending on how the exception
 * is handled, the solution will differ:
 *  - If exception is handled by try..catch construct, explicit out.close()
 *    or out.flush() should be called.
 *  - If the exception is handled by try with resources, the flush will happen automatically.
 */
public class TextPrint {

    public static void main(String[] args) {
        writeFile();
    }

    private static void writeFile() {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("output.txt"))) {
            for (int i = 0; i < 10000; i++) {
                out.println(i + ": This is a line of text.");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
