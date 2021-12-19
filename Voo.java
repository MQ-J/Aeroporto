public class Voo {

  //atributos
  private Aviao aeronave;
  private int nro;
  private String data, hora;

  //método construtor
  public Voo(Aviao aeronave, int nro, String data, String hora)
  {
    this.aeronave = aeronave;
    this.nro = nro;
    this.data = data;
    this.hora = hora;
  }

  //demais métodos
  public Aviao getAeronave()
  {
    return aeronave;
  }
  public int getNro()
  {
    return nro;
  }
  public String getData()
  {
    return data;
  }
  public String getHora()
  {
    return hora;
  }
}