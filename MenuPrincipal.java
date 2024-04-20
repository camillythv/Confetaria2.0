package Manu.Millys;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuPrincipal {
    private JFrame frame;
    private SistemaCardapio cardapio;
    private Pedido pedido;

    public MenuPrincipal() {
        frame = new JFrame("Sistema da Confeitaria");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuCardapio = new JMenu("Cardápio");
        JMenu menuPedidos = new JMenu("Pedidos");
        JMenu menuRelatorios = new JMenu("Relatórios");

        JMenuItem itemAdicionar = new JMenuItem("Adicionar Item");
        JMenuItem itemRemover = new JMenuItem("Remover Item");
        JMenuItem itemAtualizar = new JMenuItem("Atualizar Item");
        JMenuItem itemListar = new JMenuItem("Listar Itens");
        JMenuItem itemFazerPedido = new JMenuItem("Fazer Pedido");
        JMenuItem itemVerPedidos = new JMenuItem("Ver Pedidos");
        JMenuItem itemGerarRelatorio = new JMenuItem("Gerar Relatório");
        JMenuItem itemConfiguracoes = new JMenuItem("Configurações");

        menuCardapio.add(itemAdicionar);
        menuCardapio.add(itemRemover);
        menuCardapio.add(itemAtualizar);
        menuCardapio.add(itemListar);

        menuPedidos.add(itemFazerPedido);
        menuPedidos.add(itemVerPedidos);

        menuRelatorios.add(itemGerarRelatorio);
        menuRelatorios.add(itemConfiguracoes);

        menuBar.add(menuCardapio);
        menuBar.add(menuPedidos);
        menuBar.add(menuRelatorios);

        frame.setJMenuBar(menuBar);

        itemAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Opção selecionada: Adicionar Item");
            }
        });

        itemRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Opção selecionada: Remover Item");
            }
        });

        itemAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Opção selecionada: Atualizar Item");
            }
        });

        itemListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Opção selecionada: Listar Itens");
            }
        });

        itemFazerPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fazerPedido();
            }
        });

        itemVerPedidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verPedidos();
            }
        });

        itemGerarRelatorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Opção selecionada: Gerar Relatório");
            }
        });

        itemConfiguracoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Opção selecionada: Configurações");
            }
        });
    }

    private void fazerPedido() {
        try {
            List<String> itensCardapio = cardapio.listarItens();
            if (itensCardapio.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "O cardápio está vazio. Não há itens disponíveis para fazer pedidos.");
                return;
            }

            String[] opcoes = itensCardapio.toArray(new String[0]);
            String selectedItem = (String) JOptionPane.showInputDialog(frame, "Selecione o item:", "Fazer Pedido",
                    JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
            if (selectedItem != null) {
                double preco = cardapio.obterPrecoItem(selectedItem);
                PedidoItem itemPedido = new PedidoItem(selectedItem, preco);
                pedido.adicionarItem(itemPedido);
                JOptionPane.showMessageDialog(frame, "Item adicionado ao pedido:\n" + selectedItem);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Ocorreu um erro ao fazer o pedido: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void verPedidos() {
        try {
            List<PedidoItem> itensPedido = pedido.getItens();
            if (itensPedido.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "O pedido está vazio. Não há itens no pedido.");
                return;
            }

            StringBuilder mensagem = new StringBuilder("Itens do Pedido:\n");
            for (PedidoItem item : itensPedido) {
                mensagem.append("- ").append(item.getNome()).append("\n");
            }
            mensagem.append("\nTotal do Pedido: R$").append(pedido.calcularTotal());
            JOptionPane.showMessageDialog(frame, mensagem.toString());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Ocorreu um erro ao visualizar os pedidos: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void exibir() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SistemaCardapioMap cardapio = new SistemaCardapioMap();
        MenuPrincipal menu = new MenuPrincipal();
        menu.exibir();
    }
}
