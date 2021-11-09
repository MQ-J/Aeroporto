public class Passageiro {

  //atributos
  private String nome;
  private String cpf;

  //método construtor
  Passageiro(String nome, String cpf)
  {
    this.nome = nome;
    this.cpf = cpf;
  }

  //demais métodos
  public String getNome()
  {
    return nome;
  }
  public String getcpf()
  {
    return cpf;
  }
}