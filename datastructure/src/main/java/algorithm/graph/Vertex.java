package algorithm.graph;

/**
 * User: clamaa
 * Date: 4/24/13
 */
public class Vertex {

    private char label;
    private boolean wasVisited;

    private boolean inTree;

    public Vertex(char label){
        this.label = label;
        this.wasVisited = false;
        this.inTree = false;
    }

    public char getLabel() {
        return label;
    }

    public void setLabel(char label) {
        this.label = label;
    }

    public boolean isWasVisited() {
        return wasVisited;
    }

    public void setWasVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }

    public boolean isInTree() {
        return inTree;
    }

    public void setInTree(boolean inTree) {
        this.inTree = inTree;
    }
}
