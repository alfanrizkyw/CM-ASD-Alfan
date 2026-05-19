package CM;

public class NodeAntrian {
    int noAntrian;
    Pembeli pembeli;
    NodeAntrian prev, next;

    public NodeAntrian(NodeAntrian prev, int noAntrian, Pembeli pembeli, NodeAntrian next) {
        this.prev = prev;
        this.noAntrian = noAntrian;
        this.pembeli = pembeli;
        this.next = next;
    }
}