package padroescomportamentais.observer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ClienteTest {

    @Test
    void deveNotificarUmCliente() {
        Produto ps5 = new Produto("Playstation 5", 4500.00); // Começa com estoque 0

        Cliente cliente1 = new Cliente("Ana");

        cliente1.adicionarNaListaDeEspera(ps5);

        ps5.atualizarEstoque(10);

        assertEquals("Olá Ana! O produto que você queria (Playstation 5) voltou ao estoque!", cliente1.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientes() {
        Produto iphone = new Produto("iPhone 15 Pro", 8999.00);

        Cliente cliente1 = new Cliente("Bruno");
        Cliente cliente2 = new Cliente("Carla");

        cliente1.adicionarNaListaDeEspera(iphone);
        cliente2.adicionarNaListaDeEspera(iphone);

        iphone.atualizarEstoque(5);

        assertEquals("Olá Bruno! O produto que você queria (iPhone 15 Pro) voltou ao estoque!", cliente1.getUltimaNotificacao());
        assertEquals("Olá Carla! O produto que você queria (iPhone 15 Pro) voltou ao estoque!", cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCliente() {
        Produto notebook = new Produto("Notebook Gamer", 6500.00);

        Cliente cliente1 = new Cliente("Daniel");

        notebook.atualizarEstoque(2);

        assertNull(cliente1.getUltimaNotificacao());
    }

    @Test
    void deveNotificarApenasClienteDoProdutoEspecifico() {
        Produto produtoA = new Produto("Fone Bluetooth", 300.00);
        Produto produtoB = new Produto("Teclado Mecânico", 550.00);

        Cliente clienteA = new Cliente("Eduarda");
        Cliente clienteB = new Cliente("Felipe");

        clienteA.adicionarNaListaDeEspera(produtoA);
        clienteB.adicionarNaListaDeEspera(produtoB);

        produtoA.atualizarEstoque(20);

        assertEquals("Olá Eduarda! O produto que você queria (Fone Bluetooth) voltou ao estoque!", clienteA.getUltimaNotificacao());

        assertNull(clienteB.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarSeEstoqueJaExistia() {

        Produto mouse = new Produto("Mouse Gamer", 350.00);
        mouse.atualizarEstoque(10);

        Cliente cliente1 = new Cliente("Gabriela");
        cliente1.adicionarNaListaDeEspera(mouse);

        mouse.atualizarEstoque(20);

        assertNull(cliente1.getUltimaNotificacao());
    }
}