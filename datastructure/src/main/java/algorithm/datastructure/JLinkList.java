package algorithm.datastructure;

/**
 * User: clamaa
 * Date: 13-4-15
 */
public class JLinkList<T> {

    private JLink<T> first;

    public JLinkList(){
        first = null;
    }

    public void setFirst(JLink<T> first){
        this.first = first;
    }

    public JLink<T> getFirst(){
        return first;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insertFirst(T data) {
        JLink link = new JLink(data);
        first.setLink(link);
        first = link;
    }

    public JLink deleteFirst(){
        JLink temp = first;
        first = first.getLink();
        return temp;
    }

    public JLink findLink(T data){
        if(isEmpty()){
            return null;
        }
        JLink current = first;
        while (!current.getData().equals(data)){
            if(current.getLink() != null){
                current = current.getLink();
            } else {
                return null;
            }
        }
        return current;
    }

    public JLink deleteLink(T data){
        if(isEmpty()){
            return null;
        }
        JLink previous = first;
        JLink current = first;
        while (!current.getData().equals(data)){
            if(current.getLink() != null){
                previous = current;
                current = current.getLink();
            } else {
                return null;
            }
        }
        if(current == first){
            first = first.getLink();
        } else {
            previous.setLink(current.getLink());
        }
        return current;
    }

}
