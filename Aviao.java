public class Aviao extends Aeronave {
  
  //atributos
  public Passageiro[][] lugares;
  int fileiras, assentos;

  //método construtor
 Aviao(String modelo, int fileiras, int assentos)
 {
   super(modelo);
   Passageiro lugares[][] = new Passageiro[fileiras][assentos];
 }

  //demais métodos
  public Passageiro[][] getPassageiro(int fileira, int acentos)
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