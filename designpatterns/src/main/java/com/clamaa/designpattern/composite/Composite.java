package com.clamaa.designpattern.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * User: mazhqa
 * Date: 13-5-20
 */
public class Composite implements Component {

    private List<Component> componentList = new ArrayList<Component>();

    @Override
    public Composite getComposite() {
        return this;
    }

    @Override
    public void sampleOperation() {

    }

    public void add(Component component){
        componentList.add(component);
    }

    public void remove(Component component){
        componentList.remove(component);
    }

    public Iterator<Component> iterator(){
        return componentList.iterator();
    }

}
