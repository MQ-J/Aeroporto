public class Aviao extends Aeronave {
	public Passageiro[][] lugares;
	
	public Aviao (String modelo, int fileiras, int assentos) {
		super(modelo);
		lugares = new Passageiro[fileiras][assentos];
	}
	
	public void setPassageiro (int fileira, int assento, Passageiro passageiro) {
		lugares[fileira][assento] = passageiro;
	}
	
	public Passageiro getPassageiro(int fileira, int assento) {
		if (lugares[fileira][assento] != null)
			return lugares[fileira][assento];
		else
		return null;	
	}
	
	public boolean verificaLugarOcupado (int fileira, int assento) {
		if (lugares[fileira][assento] != null)
			return true;
		else
			return false;
	}
}