package algorithm.datastructure;

/**
 * User: clamaa
 * Date: 4/20/13
 */
public class JSortedList<T extends Comparable> {

    private JLink<T> first;

    public JSortedList(){
        first = null;
    }

    public JSortedList(JLink[] linkArray){
        first = null;
        for (int i =0;i<linkArray.length;i++){

        }
    }

    public void insert(JLink<T> link){
        JLink<T> previous = null;
        JLink<T> current = first;
        while (current != null && link.getData().compareTo(current.getData()) > 0){
            previous = current;
            current = current.getLink();
        }
        if(previous == null){
            first = link;
        } else {
            previous.setLink(link);
        }
        link.setLink(current);
    }

    public JLink<T> remove(){
        if(first == null){
            return null;
        }
        JLink<T> temp = first;
        first = first.getLink();
        return temp;
    }

    public boolean isEmpty(){
        return first == null;
    }

}
