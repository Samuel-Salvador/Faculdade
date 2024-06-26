package entities;

public class I000001 extends Instrucao {

	public I000001(int COD, int op1) {
		super(COD);
		super.setOp1(op1);
		super.setResultado("MBR <- #pos");
		Registrador.modifyIr(getCOD(),getOp1(),getOp2());
	}

	@Override
	public void tarefa() {
		Registrador.setMar(getOp1());
		Memory.putMemoryOnMbr();		
		Registrador.increasePc();
	}

	@Override
	public String toString() {
		return String.format("MBR <- %d",super.getOp1());
	}
	
	@Override
	public String operacaoDeDados() {
		return String.format("VALOR DO MBR: \n%06f \nVALOR NA MEMÓRIA: \n%06d \nVALOR NO MBR APÓS OPERAÇÃO:\n%06d\n"
				+ "O VALOR FOI ARMAZENADO!", Registrador.getMbr(),getOp1(),getOp1());
	}
}
