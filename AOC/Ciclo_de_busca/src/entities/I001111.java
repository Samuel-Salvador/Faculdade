package entities;

public class I001111 extends Instrucao {

	public I001111(int COD, int op1) {
		super(COD);
		super.setOp1(op1);
		super.setResultado("#pos <- MBR");
		Registrador.modifyIr(getCOD(),getOp1(),getOp2());
	}

	@Override
	public void tarefa() {
		Registrador.setMar(getOp1());
		Memory.putMbrOnMemory();	
		Registrador.increasePc();
	}
	@Override
	public String toString() {
		return String.format("%d <- MBR", getOp1());
	}
	@Override
	public String operacaoDeDados() {
		return String.format("VALOR DO MBR: \n%06f \nVALOR DO ENDEREÇO APÓS OPERAÇÃO:\n%06f\nO VALOR FOI ARMAZENADO!\n"
				, Registrador.getMbr(),Registrador.getMbr());
	}
}
