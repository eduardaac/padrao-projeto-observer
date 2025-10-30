package padroescomportamentais.observer;

import java.util.Observable;

// 1. O "Subject" (Observado)
public class Produto extends Observable {

    private String nome;
    private double preco;
    private int quantidadeEstoque;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = 0; // O produto começa esgotado
    }

    // 2. O método que dispara a notificação
    public void atualizarEstoque(int novaQuantidade) {
        boolean estavaEsgotado = (this.quantidadeEstoque == 0);
        this.quantidadeEstoque = novaQuantidade;

        // A notificação só ocorre se o produto ESTAVA esgotado e AGORA tem estoque
        if (estavaEsgotado && this.quantidadeEstoque > 0) {
            setChanged(); // Marca que houve mudança
            // Notifica os observadores, passando o nome do produto como argumento
            notifyObservers(this.nome);
        }
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }

    public int getQuantidadeEstoque() {
        return this.quantidadeEstoque;
    }
}