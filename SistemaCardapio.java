package Manu.Millys;
import java.util.List;
public interface SistemaCardapio {
    void adicionarSobremesa(String nome, double preco);
    void removerSobremesa(String nome);
    void adicionarSalgado(String nome, double preco);
    void removerSalgado(String nome);
    void adicionarBebida(String nome, double preco);
    void removerBebida(String nome);
    double calcularPrecoTotal();
    List<String> listarItens();
    double obterPrecoItem(String selectedItem);
}
