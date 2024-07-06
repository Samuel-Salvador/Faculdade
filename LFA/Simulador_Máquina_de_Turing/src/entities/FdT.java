package entities;

public class FdT {
	private int estadoPertence;
	private int estadoProximo;
	private Character lerNaFita;
	private Character trocarNaFita;
	private Character direcao;

	public FdT(int estadoPertence) {
		this.estadoPertence = estadoPertence;
	}
	public FdT(int estadoPertence, int estadoProximo, Character lerNaFita, Character trocarNaFita, Character direcao) {
		super();
		this.estadoPertence = estadoPertence;
		this.estadoProximo = estadoProximo;
		this.lerNaFita = lerNaFita;
		this.trocarNaFita = trocarNaFita;
		this.direcao = direcao;
	}

	public int getEstadoPertence() {
		return estadoPertence;
	}

	public void setEstadoPertence(int estadoPertence) {
		this.estadoPertence = estadoPertence;
	}

	public int getEstadoProximo() {
		return estadoProximo;
	}

	public void setEstadoProximo(int estadoProximo) {
		this.estadoProximo = estadoProximo;
	}

	public Character getLerNaFita() {
		return lerNaFita;
	}

	public void setLerNaFita(Character lerNaFita) {
		this.lerNaFita = lerNaFita;
	}

	public Character getTrocarNaFita() {
		return trocarNaFita;
	}

	public void setTrocarNaFita(Character trocarNaFita) {
		this.trocarNaFita = trocarNaFita;
	}

	public Character getDirecao() {
		return direcao;
	}

	public void setDirecao(Character direcao) {
		this.direcao = direcao;
	}

	
	

}
