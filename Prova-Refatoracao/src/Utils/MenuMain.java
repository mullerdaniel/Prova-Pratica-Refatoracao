package Utils;

import Estrategia.PagamentoCredito;
import Estrategia.PagamentoEspecie;
import Estrategia.PagamentoEstrategia;
import Estrategia.PagamentoPIX;
import model.Funcionario;
import model.Prato;
import model.Pedido;
import service.VendaService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuMain {
    // SCANNER
    private static Scanner scanner = new Scanner(System.in);

    private static List<Funcionario> funcionarios = new ArrayList<>(); // LISTAR FUNCIONARIOS
    private static List<Prato> cardapio = new ArrayList<>(); // LISTAR PRATOS
    private static double faturamentoTotal = 0; // FATURAMENTOTOTAL

    private static VendaService vendaService = new VendaService();

    // --------------------------------------------------------------------------------------------------

    // METODO PARA EXIBIR O MENU
    public void exibirMenu() {
        inicializarDados();
        int opcao;

        // LOOP COM DO
        do {
            System.out.println("\n--- TECHFOOD ERP ---");
            System.out.println("1 - Funcionários");
            System.out.println("2 - Cardápio");
            System.out.println("3 - Estoque");
            System.out.println("4 - Venda");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            // AQUI ELE VAI VER QUAL OPÇÃO VOCÊ SELECIONOU E VAI TE MOSTRAR O MENU SEGUNDO A OPÇÃO
            switch (opcao) {
                case 1 -> menuFuncionarios();
                case 2 -> menuCardapio();
                case 3 -> menuEstoque();
                case 4 -> menuVenda();
            }
            // ENQUANTO ESSA OPÇÃO FOR DIFERENTE DE 0 ELE VAI FAZER O LOOP
        } while (opcao != 0);

        System.out.println("Faturamento total: R$ " + faturamentoTotal);
        System.out.println("Saindo do sistema...");
    }

    // AQUI É A INICIALIZAÇÃO DE DADOS.
    private static void inicializarDados() {
        // TODOS OS FUNCIONARIOS COM (NOME, CARGO E SALARIO)
        funcionarios.add(new Funcionario("Lucas", "Gerente", 8000));
        funcionarios.add(new Funcionario("Ana", "Caixa", 2000));
        funcionarios.add(new Funcionario("Beto", "Cozinheiro", 3000));
        funcionarios.add(new Funcionario("Zeca", "Cozinheiro", 3000));
        funcionarios.add(new Funcionario("Vitor", "Garçom", 1800));
        funcionarios.add(new Funcionario("Luan", "Garçom", 1800));
        funcionarios.add(new Funcionario("Dona Flor", "Limpeza", 1600));
        funcionarios.add(new Funcionario("Marcio", "Segurança", 2500));
        funcionarios.add(new Funcionario("Tiago", "Motoboy", 2200));

        // TODAS OPÇÕES DO CARDAPIO COM (NOME, PRECO E ESTOQUE)
        cardapio.add(new Prato("Feijoada Completa", 45, 10));
        cardapio.add(new Prato("Moqueca de Peixe", 65, 5));
        cardapio.add(new Prato("Baião de Dois", 35, 8));
        cardapio.add(new Prato("Acarajé", 25, 15));
        cardapio.add(new Prato("Pato no Tucupi", 80, 3));
        cardapio.add(new Prato("Vaca Atolada", 40, 7));
        cardapio.add(new Prato("Arroz Carreteiro", 30, 12));
        cardapio.add(new Prato("Pão de Queijo Porção", 15, 20));
        cardapio.add(new Prato("Barreado", 50, 6));
        cardapio.add(new Prato("Tacacá", 28, 10));
    }

    // --------------------------------------------------------------------------------------------------

    // MENU FUNCIONARIOS
    private static void menuFuncionarios() {
        System.out.println("1-Listar | 2-Contratar | 3-Demitir | 4-Aumento");
        int opcao = scanner.nextInt(); scanner.nextLine();

        // CASO A OPÇÃO FOR IGUAL A 1
        if (opcao == 1) {
            // FOR PARA FAZER LOOP ENTÃO ENQUANTO I FOR MENOR E QUANTIDADE DE FUNCIONARIOS ELE CONTINUA LISTANDO
            for (int i = 0; i < funcionarios.size(); i++)
                System.out.println(i + " - " + funcionarios.get(i));

            // CASO A OPÇÃO FOR IGUAL A 2
        } else if (opcao == 2) {
            System.out.print("Nome do Funcionario: "); String nome = scanner.nextLine();
            System.out.print("Cargo do Funcionario: "); String cargo = scanner.nextLine();
            System.out.print("Salário do Funcionario: "); double salario = scanner.nextDouble();
            // ELE VAI ADICIONAR UM NOVO FUNCIONARIO COM O NOME, CARGO E SALARIO.
            funcionarios.add(new Funcionario(nome, cargo, salario));

            // CASO A OPÇÃO FOR IGUAL A 3
        } else if (opcao == 3) {
            // VOCÊ VAI SELEECIONAR O CODIGO DO FUNCIONARIO PARA DEMITIR (QUE NO CASO É DELETAR)
            System.out.print("Código: "); int i = scanner.nextInt();
            if (i >= 0 && i < funcionarios.size()) {
                funcionarios.get(i).setNome("DEMITIDO");
                System.out.println("O Funcionário foi demitido.");
            }

            // CASO A OPÇÃO FOR IGUAL A 4
        } else if (opcao == 4) {
            // VOCÊ VAI SELECIONAR O CODIGO DO FUNCIONARIO PARA DAR O AUMENTO PARA ELE
            System.out.print("Código: "); int i = scanner.nextInt();
            System.out.print("Aumento em %: "); double porcentagem = scanner.nextDouble();
            if (i >= 0 && i < funcionarios.size()) {
                Funcionario funcionario = funcionarios.get(i);
                funcionario.setSalario(funcionario.getSalario() * (1 + porcentagem / 100));
                System.out.println("O Novo salário Do Funcionario é de: R$ " + funcionario.getSalario());
            }
        }
    }

    // --------------------------------------------------------------------------------------------------

    // MENU CARDAPIO
    private static void menuCardapio() {
        // LOOP PARA MOSTRAR AS OPÇÕES DO CARDAPIO
        for (int i = 0; i < cardapio.size(); i++)
            System.out.println(i + " - " + cardapio.get(i));

        System.out.println("Cadastrar novo prato? 1-Sim / 0-Não");
        if (scanner.nextInt() == 1) {
            scanner.nextLine();
            System.out.print("Nome do Prato: "); String n = scanner.nextLine();
            System.out.print("Preço do Prato: "); double p = scanner.nextDouble();
            System.out.print("Estoque do Prato: "); int e = scanner.nextInt();
            cardapio.add(new Prato(n, p, e));
            System.out.println("Prato cadastrado!");
        }
    }

    // --------------------------------------------------------------------------------------------------

    // MENU ESTOQUE
    private static void menuEstoque() {
        // LOOP PARA MOSTRAR O ESTOQUE
        for (int i = 0; i < cardapio.size(); i++)
            System.out.println(i + " - " + cardapio.get(i));

        System.out.print("Código do prato: "); int i = scanner.nextInt();
        System.out.print("Quantidade para adicionar: "); int q = scanner.nextInt();
        cardapio.get(i).adicionarEstoque(q);
        System.out.println("Estoque atualizado com sucesso!");
    }

    // --------------------------------------------------------------------------------------------------

    // MENU VENDA
    private static void menuVenda() {
        for (int i = 0; i < cardapio.size(); i++)
            System.out.println(i + " - " + cardapio.get(i));

        System.out.print("Código do prato: "); int i = scanner.nextInt();
        System.out.print("Quantidade: "); int quantidade = scanner.nextInt();
        scanner.nextLine();

        Prato prato = cardapio.get(i);
        if (prato.getEstoque() < quantidade) {
            System.out.println("Estoque insuficiente!");
            return;
        }

        System.out.print("1-Presencial / 2-Entrega: "); boolean entrega = scanner.nextInt() == 2;

        // SELECIONAR QUAL O METODO DE PAGAMENTO
        System.out.println("Pagamento: 1-Crédito / 2-PIX / 3-Espécie");
        int pagamento = scanner.nextInt();
        PagamentoEstrategia estrategia = switch (pagamento) {
            case 1 -> new PagamentoCredito();
            case 2 -> new PagamentoPIX();
            default -> new PagamentoEspecie();
        };

        Pedido pedido = new Pedido(prato, quantidade, entrega, estrategia);
        double total = vendaService.processarVenda(pedido);
        faturamentoTotal += total;

        System.out.println("Venda finalizada! Total: R$ " + total);
    }
}