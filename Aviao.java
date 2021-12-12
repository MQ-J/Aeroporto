public class Aviao extends Aeronave {
  
  //atributos
  public Passageiro[][] lugares;
  int fileiras, assentos;
  String modelo;

  //método construtor - COM ERRO
 Aviao(String modelo, int fileiras, int assentos)
 {
   super(modelo);
   Passageiro lugares[][] = new Passageiro[fileiras][assentos];
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