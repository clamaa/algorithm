package algorithm.tree;

/**
 * User: clamaa
 * Date: 4/24/13
 */
public class JHeap<T extends Comparable> {
    private JHeapNode<T>[] heapArray;
    private int maxSize;
    private int currentSize;

    public JHeap(int maxSize) {
        this.maxSize = maxSize;
        heapArray = new JHeapNode[maxSize];
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean insert(T key) {
        if (currentSize == maxSize) {
            return false;
        }
        JHeapNode<T> node = new JHeapNode<T>(key);
        heapArray[currentSize] = node;
        trickleUp(currentSize++);
        return true;
    }

    private void trickleUp(int index) {
        int parent = (index - 1) / 2;
        JHeapNode<T> bottom = heapArray[parent];
        while (index > 0 && heapArray[parent].getKey().compareTo(bottom.getKey()) < 0) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (index - 1) / 2;
        }
        heapArray[index] = bottom;
    }

    public JHeapNode<T> remove() {
        JHeapNode<T> root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    private void trickleDown(int index) {
        int largerChild;
        JHeapNode<T> top = heapArray[index];
        while (index < currentSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;
            if (rightChild < currentSize && heapArray[leftChild].getKey().compareTo(heapArray[rightChild].getKey()) < 0) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }
            if (top.getKey().compareTo(heapArray[largerChild].getKey()) >= 0) {
                break;
            }
            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
    }

    public boolean change(int index, T newValue) {
        if (index < 0 || index >= currentSize) {
            return false;
        }
        T oldValue = heapArray[index].getKey();
        heapArray[index].setKey(newValue);
        if(oldValue.compareTo(newValue) < 0){
            trickleUp(index);
        } else {
            trickleDown(index);
        }
        return true;
    }

}
