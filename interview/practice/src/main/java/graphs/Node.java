package graphs;

public class Node {
    private char id;
    private char[] neighbours;

    public Node(char id, char[] neighbours) {
        this.id = id;
        this.neighbours = neighbours;
    }

    public char getId() {
        return id;
    }

    public char[] getNeighbours() {
        return neighbours;
    }
}
