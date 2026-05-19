package CM;

public class NodePesanan {
    Pesanan pesanan;
    NodePesanan prev, next;

    public NodePesanan(NodePesanan prev, Pesanan pesanan, NodePesanan next) {
        this.prev = prev;
        this.pesanan = pesanan;
        this.next = next;
    }
}
