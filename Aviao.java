public class Aviao extends Aeronave {
  
  //atributos
  public Passageiro[][] lugares;

  //método construtor - COM ERRO
  Aviao(String modelo, int fileira, int acento)
  {
    super.modelo = modelo;
  }

  //demais métodos
  public Passageiro[][] getPassageiro(int fileira, int acento)
  {
    return lugares;
  }
  public boolean verificaLugarOcupado(int fileira, int acento)
  {
    return true;
  }
  public void setPassageiro(int fileira, int acento, Passageiro lugares)
  {
    
  }
}