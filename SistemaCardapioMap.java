package Manu.Millys;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaCardapioMap implements SistemaCardapio {
    private Map<String, Double> sobremesas;
    private Map<String, Double> salgados;
    private Map<String, Double> bebidas;

    public SistemaCardapioMap() {
        sobremesas = new HashMap<>();
        salgados = new HashMap<>();
        bebidas = new HashMap<>();
    }

    @Override
    public void adicionarSobremesa(String nome, double preco) {
        sobremesas.put(nome, preco);
    }

    @Override
    public void removerSobremesa(String nome) {
        sobremesas.remove(nome);
    }

    @Override
    public void adicionarSalgado(String nome, double preco) {
        salgados.put(nome, preco);
    }

    @Override
    public void removerSalgado(String nome) {
        salgados.remove(nome);
    }

    @Override
    public void adicionarBebida(String nome, double preco) {
        bebidas.put(nome, preco);
    }

    @Override
    public void removerBebida(String nome) {
        bebidas.remove(nome);
    }

    @Override
    public double calcularPrecoTotal() {
        double total = 0.0;
        for (double preco : sobremesas.values()) {
            total += preco;
        }
        for (double preco : salgados.values()) {
            total += preco;
        }
        for (double preco : bebidas.values()) {
            total += preco;
        }
        return total;
    }

    @Override
    public List<String> listarItens() {
        List<String> itens = new ArrayList<>();
        itens.addAll(sobremesas.keySet());
        itens.addAll(salgados.keySet());
        itens.addAll(bebidas.keySet());
        return itens;
    }

    @Override
    public double obterPrecoItem(String selectedItem) {
        return 0;
    }
}
