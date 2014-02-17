package algorithm.sort;

/**
 * User: clamaa
 * Date: 4/20/13
 */
public class MergeSort<T extends Comparable> extends AbstractSortAlgorithm<T> {

    @Override
    public void sort(T[] toSortArray) {
        T[] workSpace = (T[]) new Object[toSortArray.length];
        recursiveSort(workSpace, toSortArray, 0, toSortArray.length - 1);
    }

    private void recursiveSort(T[] workSpace, T[] toSortArray, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;
            recursiveSort(workSpace, toSortArray, lowerBound, mid);
            recursiveSort(workSpace, toSortArray, mid + 1, upperBound);
            merge(workSpace, toSortArray, lowerBound, mid + 1, upperBound);
        }
    }

    private void merge(T[] workSpace, T[] toSortArray, int lowPtr, int highPtr, int upperBound) {
        int index = 0;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int number = upperBound - lowerBound + 1;
        while (lowPtr <= mid && highPtr <= upperBound) {
            if (toSortArray[lowPtr].compareTo(toSortArray[highPtr]) < 0) {
                workSpace[index++] = toSortArray[lowPtr++];
            } else {
                workSpace[index++] = toSortArray[highPtr++];
            }
        }

        while (lowPtr <= mid) {
            workSpace[index++] = toSortArray[lowPtr++];
        }
        while (highPtr <= upperBound) {
            workSpace[index++] = toSortArray[highPtr++];
        }
        for (index = 0; index < number; index++) {
            toSortArray[index + lowerBound] = workSpace[index];
        }
    }
}
