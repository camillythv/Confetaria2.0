package Manu.Millys;
import java.util.ArrayList;
import java.util.List;
public class Pedido {
    private List<PedidoItem> itens;

    public Pedido() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(PedidoItem item) {
        itens.add(item);
    }

    public void removerItem(PedidoItem item) {
        itens.remove(item);
    }

    public List<PedidoItem> getItens() {
        return itens;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (PedidoItem item : itens) {
            total += item.getPreco();
        }
        return total;
    }
}
