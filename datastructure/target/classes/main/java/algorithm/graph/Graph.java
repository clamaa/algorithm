package algorithm.graph;

import algorithm.datastructure.JPriorityQueue;
import algorithm.datastructure.JQueue;
import algorithm.datastructure.JStack;

/**
 * User: clamaa
 * Date: 4/24/13
 */
public class Graph {

    private static final int MAX_VERT = 20;
    private static final int INFINITY = 10000;

    private Vertex[] vertexes;
    /**
     * Adjacency Matrix
     */
    private int[][] adjMat;
    /**
     * current number of vertices
     */
    private int nVert;
    private JStack<Integer> stack;
    private JQueue<Integer> queue;

    /**
     * Identify whether the graph is directional.
     */
    private boolean directional;

    /**
     * Use this priority queue to generate minimal tree with weight.
     */
    private JPriorityQueue<Edge> priorityQueue;

    public Graph() {
        vertexes = new Vertex[MAX_VERT];
        adjMat = new int[MAX_VERT][MAX_VERT];
        nVert = 0;
        for (int i = 0; i < MAX_VERT; i++) {
            for (int j = 0; j < MAX_VERT; j++) {
                adjMat[i][j] = 0;
            }
        }
        stack = new JStack<Integer>(nVert);
        queue = new JQueue<Integer>(nVert);
        directional = false;

    }

    public Graph(boolean directional) {
        this();
        directional = true;
    }

    public void addVertex(char label) {
        vertexes[nVert++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        this.addEdge(start, end, 1);
    }

    public void addEdge(int start, int end, int weight) {
        adjMat[start][end] = weight;
        if (!directional) {
            adjMat[end][start] = weight;
        }
    }

    public void displayVertex(int index) {
        System.out.println(vertexes[index].getLabel());
    }

    public void deepFirstSearch() {
        vertexes[0].setWasVisited(true);
        displayVertex(0);
        stack.push(Integer.valueOf(0));

        while (!stack.isEmpty()) {
            int v = getAdjUnvisitedVertex(stack.peek());
            if (v == -1) {
                stack.pop();
            } else {
                vertexes[v].setWasVisited(true);
                displayVertex(v);
                stack.push(v);
            }
        }

        for (int i = 0; i < nVert; i++) {
            vertexes[i].setWasVisited(false);
        }

    }

    private int getAdjUnvisitedVertex(int v) {
        for (int i = 0; i < nVert; i++) {
            if (adjMat[v][i] == 1 && vertexes[i].isWasVisited()) {
                return i;
            }
        }
        return -1;
    }

    public void breathFirstSearch() {
        vertexes[0].setWasVisited(true);
        displayVertex(0);
        queue.insert(0);

        int v2;
        while (!queue.isEmpty()) {
            int v1 = queue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexes[v2].setWasVisited(true);
                displayVertex(v2);
                queue.insert(v2);
            }
        }

        for (int i = 0; i < nVert; i++) {
            vertexes[i].setWasVisited(false);
        }
    }

    /**
     * Use deep first alogorithm to generate.
     */
    public void minSpanningTree() {
        vertexes[0].setWasVisited(true);
        stack.push(0);

        while (!stack.isEmpty()) {
            int currentVertex = stack.peek();
            int v = getAdjUnvisitedVertex(currentVertex);
            if (v == -1) {
                stack.pop();
            } else {
                vertexes[v].setWasVisited(true);
                stack.push(v);

                displayVertex(currentVertex);
                displayVertex(v);

                System.out.print(" ");
            }
        }
        for (int i = 0; i < nVert; i++) {
            vertexes[i].setWasVisited(false);
        }
    }

    public void topologicalSort() {
        char[] sortedArray = new char[MAX_VERT];
        int originVerts = nVert;

        while (nVert > 0) {
            int currentVertex = noSuccessors();
            if (currentVertex == -1) {
                System.out.println("ERROR: Graph has cycles");
            }
            sortedArray[nVert - 1] = vertexes[currentVertex].getLabel();
            deleteVertex(currentVertex);
        }

        System.out.println("Topologically sort order:");
        for (int j = 0; j < originVerts; j++) {
            System.out.print(sortedArray[j]);
        }
        System.out.println();
    }

    private int noSuccessors() {
        boolean isEdge;
        for (int row = 0; row < nVert; row++) {
            isEdge = false;
            for (int col = 0; col < nVert; col++) {
                if (adjMat[row][col] > 0) {
                    isEdge = true;
                    break;
                }
            }
            if (!isEdge) {
                return row;
            }
        }
        return -1;
    }

    private void deleteVertex(int delVert) {
        if (delVert != nVert - 1) {
            for (int j = delVert; j < nVert - 1; j++) {
                vertexes[j] = vertexes[j + 1];
            }
            for (int row = delVert; row < nVert - 1; row++) {
                moveRowUp(row, nVert);
            }
            for (int col = delVert; col < nVert - 1; col++) {
                moveColLeft(col, nVert - 1);
            }
        }
    }

    private void moveRowUp(int row, int length) {
        for (int col = 0; col < length; col++) {
            adjMat[row][col] = adjMat[row + 1][col];
        }
    }

    private void moveColLeft(int col, int length) {
        for (int row = 0; row < length; row++) {
            adjMat[row][col] = adjMat[row][col + 1];
        }
    }

    /**
     * Generate the minimal tree
     * Used only when the tree with
     */
    public void minimalGeneratedTree() {
        int currentVert = 0;
        int nTree = 0;
        while (nTree < nVert - 1) {
            vertexes[currentVert].setInTree(true);
            nTree++;

            for (int j = 0; j < nVert; j++) {
                if (j == currentVert) {
                    continue;
                }
                if (vertexes[j].isInTree()) {
                    continue;
                }
                int distance = adjMat[currentVert][j];
                if (distance == INFINITY) {
                    continue;
                }
                putInPriorityQueue(j, distance, currentVert);
            }

            if (priorityQueue.size() == 0) {
                System.out.println("Graph no connected!");
                return;
            }

            Edge edge = priorityQueue.removeMin();
            int sourceVert = edge.getSourceVert();
            currentVert = edge.getTargetVert();

            System.out.print(vertexes[sourceVert].getLabel());
            System.out.print(vertexes[currentVert].getLabel() + " ");
        }

        //reset
        for (int j = 0; j < nVert; j++) {
            vertexes[j].setInTree(false);
        }
    }

    private void putInPriorityQueue(int newVert, int newDist, int currentVert) {
        int queueIndex = find(newVert);
        if (queueIndex == -1) {
            Edge edge = priorityQueue.peekAtN(queueIndex);
            int oldDist = edge.getWeight();
            if (oldDist > newDist) {
                priorityQueue.removeAtN(queueIndex);
                Edge newEdge = new Edge(currentVert, newVert, newDist);
                priorityQueue.insert(newEdge);
            }
        } else {
            Edge newEdge = new Edge(currentVert, newVert, newDist);
            priorityQueue.insert(newEdge);
        }
    }

    public int find(int findIndex) {
        for (int j = 0; j < priorityQueue.size(); j++) {
            if (priorityQueue.getElementAt(j).getTargetVert() == findIndex) {
                return j;
            }
        }
        return -1;
    }


}
