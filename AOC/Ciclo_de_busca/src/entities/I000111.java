package entities;


public class I000111 extends Instrucao{
	public I000111(int COD,int op1) {
		super(COD);
		super.setOp1(op1);
		super.setResultado("JUMP to #lin");
		Registrador.modifyIr(getCOD(),getOp1(),getOp2());
	}
	
	@Override
	public void tarefa() {
		super.jumpConcluded = true;
		Registrador.setPc(getOp1());
	}
	@Override
	public String toString() {
		return String.format("JUMP to %d",super.getOp1());
	}
	@Override
	public String operacaoDeDados() {
		return String.format("PULANDO PARA OPERAÇÃO NA LINHA: \n%06d \nPULO CONCLUÍDO!", Registrador.getPc());
	}
}
