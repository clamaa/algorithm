package com.clamaa.algorithm.datastructure;

/**
 *
 * User: clamaa
 * Date: 13-4-15
 */
public class JLink<T> {

    private JLink link;
    private T data;

    public JLink(T data){
        this.data = data;
    }

    public JLink getLink() {
        return link;
    }

    public void setLink(JLink link) {
        this.link = link;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
