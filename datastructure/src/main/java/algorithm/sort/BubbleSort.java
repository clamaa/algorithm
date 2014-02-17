package algorithm.sort;

/**
 * User: clamaa
 * Date: 13-4-14
 * Time: 下午4:35
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSortAlgorithm<T> {

    @Override
    public void sort(T[] toSortArray) {
        int out, in;
        int elementsLength = toSortArray.length;
        for (out = elementsLength - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (toSortArray[in].compareTo(toSortArray[in + 1]) > 0) {
                    swap(toSortArray, in, in + 1);
                }
            }
        }
    }
}
