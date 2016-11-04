package trabCampeonato;

public class TimeCamp {
	private int pontos, totalGols, saldo;
	private String id;

	public TimeCamp() {

	}

	public TimeCamp(String newId, int newPontos, int newSaldo, int newGols) {
		this.id = newId;
		this.pontos = newPontos;
		this.saldo = newSaldo;
		this.totalGols = newGols;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public int getTotalGols() {
		return totalGols;
	}

	public void setTotalGols(int totalGols) {
		this.totalGols = totalGols;
	}

	public int getSaldo() {
		return saldo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		// return "Time: " + getId() + " Pontos: " + getPontos() +
		// " Saldo de Gols: " + getSaldo() + " Gols: " + getTotalGols();
		return getId();
	}
}
