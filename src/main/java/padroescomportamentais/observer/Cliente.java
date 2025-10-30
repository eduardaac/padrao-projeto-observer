package padroescomportamentais.observer;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    // 2. Método para se registrar no Subject (ser avisado)
    public void adicionarNaListaDeEspera(Produto produto) {
        produto.addObserver(this);
    }

    @Override
    public void update(Observable produtoObservado, Object arg) {

        String nomeProduto = (String) arg;

        this.ultimaNotificacao = "Olá " + this.nome + "! O produto que você queria (" + nomeProduto + ") voltou ao estoque!";
        // System.out.println(this.ultimaNotificacao);
    }
}