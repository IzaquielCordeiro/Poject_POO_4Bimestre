package ClassesBD;

public class vota {
	private int cpfCandidato;
	private int data;
	private int idProjetodelei;
	private boolean voto;

	public int getCpfCandidato() {
		return cpfCandidato;
	}

	public void setCpfCandidato(int cpfCandidato) {
		this.cpfCandidato = cpfCandidato;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getIdProjetodelei() {
		return idProjetodelei;
	}

	public void setIdProjetodelei(int idProjetodelei) {
		this.idProjetodelei = idProjetodelei;
	}

	public boolean isVoto() {
		return voto;
	}

	public void setVoto(boolean voto) {
		this.voto = voto;
	}
}