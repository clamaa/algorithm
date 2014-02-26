package algorithm.application;

/**
 * User: mazhqa
 * Date: 14-2-26
 */
public class FibonacciNonRecursive {

    public long fibonacci(int value) {
        long x = 0, y = 1;
        for (int i = 0; i <= value; i++) {
            y = x + y;
            x = y - x;
        }
        return y;
    }

}
