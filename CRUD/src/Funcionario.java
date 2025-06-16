// Define a classe Funcionario
public class Funcionario {
    // Atributos privados: identificador, nome e cargo
    private int id;
    private String nome;
    private String cargo;

    // Construtor da classe Funcionario
    public Funcionario(int id, String nome, String cargo) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
    }

    // Métodos de acesso (getters)
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    // Métodos de modificação (setters)
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    // Método toString para exibir o funcionário no console de forma legível
    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome + " | Cargo: " + cargo;
    }
}
