package algorithm.graph;

/**
 * User: clamaa
 * Date: 4/30/13
 */
public class Edge implements Comparable<Edge> {

    private int sourceVert;
    private int targetVert;
    private int weight;

    public Edge(int sourceVert, int targetVert, int weight) {
        this.sourceVert = sourceVert;
        this.targetVert = targetVert;
        this.weight = weight;
    }

    public int getSourceVert() {
        return sourceVert;
    }

    public int getTargetVert() {
        return targetVert;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge edge) {
        return this.weight == edge.weight ? 0 : this.weight > edge.weight ? 1 : -1;
    }
}
