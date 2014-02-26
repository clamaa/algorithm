package algorithm.sort;

/**
 * User: clamaa
 * Date: 13-4-14
 */
public class InsertSort<T extends Comparable<T>> extends AbstractSortAlgorithm<T> {

    @Override
    public void sort(T[] toSortArray) {
        int in, out;
        for (out = 0; out < toSortArray.length; out++) {
            T current = toSortArray[out];
            in = out;
            //to save the memory but add the complexity
            while (in > 0 && toSortArray[in - 1].compareTo(current) >= 0) {
                toSortArray[in] = toSortArray[in - 1];
                in--;
            }
            toSortArray[in] = current;
        }
    }
}
