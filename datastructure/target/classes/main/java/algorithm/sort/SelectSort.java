package algorithm.sort;

/**
 * User: clamaa
 * Date: 13-4-14
 */
public class SelectSort<T extends Comparable<T>> extends AbstractSortAlgorithm<T> {

    @Override
    public void sort(T[] toSortArray) {
        int in, out;
        int sortArrayLength = toSortArray.length;
        for(out = sortArrayLength - 1; out > 1; out --){
            int highest = 0;
            for(in = 1; in <= out; in++){
                if(toSortArray[highest].compareTo(toSortArray[in]) < 0){
                    highest = in;
                }
            }
            swap(toSortArray, highest, out);
        }
    }
}
