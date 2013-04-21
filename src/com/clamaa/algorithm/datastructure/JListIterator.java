package com.clamaa.algorithm.datastructure;

/**
 * User: clamaa
 * Date: 4/20/13
 */
public class JListIterator<T> {

    private JLink<T> current;
    private JLink<T> previous;
    private JLinkList<T> linkList;

    public JListIterator(JLinkList<T> linkList) {
        this.linkList = linkList;
        reset();
    }

    public void reset() {
        current = linkList.getFirst();
        previous = null;
    }

    public boolean atEnd() {
        return current.getLink() == null;
    }

    public void nextLink() {
        previous = current;
        current = current.getLink();
    }

    public JLink<T> getCurrent() {
        return current;
    }

    public void insertAfter(T data) {
        JLink<T> newLink = new JLink<T>(data);
        if (linkList.isEmpty()) {
            linkList.setFirst(newLink);
            current = newLink;
        } else {
            newLink.setLink(current.getLink());
            current.setLink(newLink);
            nextLink();
        }
    }

    public void insertBefore(T data) {
        JLink<T> newLink = new JLink<T>(data);
        if (previous == null) {
            newLink.setLink(linkList.getFirst());
            linkList.setFirst(newLink);
            reset();
        } else {
            previous.setLink(newLink);
            newLink.setLink(current);
            current = newLink;
        }
    }

    public T deleteCurrent() {
        T data = current.getData();
        if (previous == null) {
            linkList.setFirst(current.getLink());
            reset();
        } else {
            previous.setLink(current.getLink());
            if (atEnd()) {
                reset();
            } else {
                current = current.getLink();
            }
        }
        return data;
    }
}
