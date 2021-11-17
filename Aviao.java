public class Aviao extends Aeronave {
  
  //atributos
  public Passageiro[][] lugares;
  int fileira, acento;
  String modelo = super.modelo;

  //método construtor - COM ERRO
 Aviao.Aviao()
 {

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