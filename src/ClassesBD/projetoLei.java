package ClassesBD;

public class projetoLei {
	private int id;
	private int cpfSanciona;
	private int cpfCandidatoCriacao;
	private String nome;
	private String descricao;
	private int dataSanciona;
	private int dataCriacao;
	private boolean aprovada;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCpfSanciona() {
		return cpfSanciona;
	}

	public void setCpfSanciona(int cpfSanciona) {
		this.cpfSanciona = cpfSanciona;
	}

	public int getCpfCandidatoCriacao() {
		return cpfCandidatoCriacao;
	}

	public void setCpfCandidatoCriacao(int cpfCandidatoCriacao) {
		this.cpfCandidatoCriacao = cpfCandidatoCriacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getDataSanciona() {
		return dataSanciona;
	}

	public void setDataSanciona(int dataSanciona) {
		this.dataSanciona = dataSanciona;
	}

	public int getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(int dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public boolean isAprovada() {
		return aprovada;
	}

	public void setAprovada(boolean aprovada) {
		this.aprovada = aprovada;
	}

	public boolean isDesicaoSanciona() {
		return desicaoSanciona;
	}

	public void setDesicaoSanciona(boolean desicaoSanciona) {
		this.desicaoSanciona = desicaoSanciona;
	}

	private boolean desicaoSanciona;
}
