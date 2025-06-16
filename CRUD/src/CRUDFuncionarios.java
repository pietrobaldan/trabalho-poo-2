import java.util.ArrayList;
import java.util.Scanner;

public class CRUDFuncionarios {

    // Lista que armazena os funcionários cadastrados em memória
    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        // Loop principal que exibe o menu e recebe a opção do usuário
        do {
            System.out.println("\n=== Menu CRUD de Funcionários ===");
            System.out.println("1 - Cadastrar funcionário");
            System.out.println("2 - Listar funcionários");
            System.out.println("3 - Atualizar funcionário");
            System.out.println("4 - Excluir funcionário");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do teclado

            // Tratamento da opção escolhida
            switch (opcao) {
                case 1:
                    cadastrarFuncionario(scanner); // Chama o método para cadastro
                    break;
                case 2:
                    listarFuncionarios(); // Exibe lista de funcionários
                    break;
                case 3:
                    atualizarFuncionario(scanner); // Atualiza dados de funcionário
                    break;
                case 4:
                    excluirFuncionario(scanner); // Remove funcionário
                    break;
                case 5:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida."); // Opção não reconhecida
            }
        } while (opcao != 5); // Continua enquanto não escolher sair

        scanner.close(); // Fecha o scanner para liberar recursos
    }

    // Método para cadastrar um funcionário, recebendo dados do usuário
    private static void cadastrarFuncionario(Scanner scanner) {
        System.out.print("Digite o ID do funcionário: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do teclado

        // Verifica se o ID já está em uso para evitar duplicidade
        if (buscarPorId(id) != null) {
            System.out.println("Já existe um funcionário com esse ID. Tente novamente.");
            return; // Sai do método se ID duplicado
        }

        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o cargo do funcionário: ");
        String cargo = scanner.nextLine();

        // Cria um novo objeto Funcionario com os dados informados
        Funcionario novo = new Funcionario(id, nome, cargo);
        funcionarios.add(novo); // Adiciona na lista
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    // Método que exibe todos os funcionários cadastrados
    private static void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            // Percorre a lista e imprime cada funcionário
            for (Funcionario f : funcionarios) {
                System.out.println(f);
            }
        }
    }

    // Método para atualizar dados de um funcionário existente
    private static void atualizarFuncionario(Scanner scanner) {
        System.out.print("Digite o ID do funcionário a atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpa buffer

        Funcionario f = buscarPorId(id); // Busca funcionário pelo ID
        if (f != null) {
            System.out.print("Novo nome: ");
            String novoNome = scanner.nextLine();

            System.out.print("Novo cargo: ");
            String novoCargo = scanner.nextLine();

            // Atualiza os dados do funcionário
            f.setNome(novoNome);
            f.setCargo(novoCargo);

            System.out.println("Funcionário atualizado com sucesso!");
        } else {
            System.out.println("Funcionário não encontrado."); // Caso não ache pelo ID
        }
    }

    // Método para excluir um funcionário da lista
    private static void excluirFuncionario(Scanner scanner) {
        System.out.print("Digite o ID do funcionário a excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpa buffer

        Funcionario f = buscarPorId(id); // Busca funcionário pelo ID
        if (f != null) {
            funcionarios.remove(f); // Remove da lista
            System.out.println("Funcionário excluído com sucesso!");
        } else {
            System.out.println("Funcionário não encontrado."); // Caso não ache pelo ID
        }
    }

    // Método auxiliar que busca um funcionário pelo ID e retorna o objeto
    private static Funcionario buscarPorId(int id) {
        for (Funcionario f : funcionarios) {
            if (f.getId() == id) {
                return f; // Retorna o funcionário encontrado
            }
        }
        return null; // Retorna null se não encontrar nenhum
    }
}
