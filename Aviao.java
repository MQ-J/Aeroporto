public class Aviao extends Aeronave {

  //atributos
	public Passageiro[][] lugares;
	int fileiras, assentos;
  
  //método construtor
	public Aviao (String modelo, int fileiras, int assentos) {
		super(modelo);
		lugares = new Passageiro[fileiras][assentos];
	}
	
  //método set
	public void setPassageiro (int fileira, int assento, Passageiro passageiro) {
		lugares[fileira][assento] = passageiro;
	}
	
  //método get
	public Passageiro getPassageiro(int fileira, int assento) {
		if (lugares[fileira][assento] != null)
			return lugares[fileira][assento];
		else
		return null;	
	}
	
  //método de verificar lugar disponível
	public boolean verificaLugarOcupado (int fileira, int assento) {
		if (lugares[fileira][assento] != null)
			return true;
		else
			return false;
	}
}