package algorithm.tree;

/**
 * User: clamaa
 * Date: 4/24/13
 */
public class JHeapNode<T extends Comparable> {

    private T key;

    public JHeapNode(T key) {
        this.key = key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }
}
