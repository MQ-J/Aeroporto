public class Aeronave {

  //atributo
  protected String modelo;

  //método construtor
  public Aeronave(String modelo)
  {
    this.modelo = modelo;
  }

  //demais métodos
  public String getModelo()
  {
    return modelo;
  }
  public void setModelo(String modelo)
  {
    this.modelo = modelo;
  }
}