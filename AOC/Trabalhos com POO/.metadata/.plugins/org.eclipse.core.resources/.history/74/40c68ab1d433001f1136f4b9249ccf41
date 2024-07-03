package entities;


public class I001000 extends Instrucao{
	public I001000(int COD,int op1) {
		super(COD);
		super.setOp1(op1);
		super.setResultado("JUMP IF Z to #lin");
		Registrador.modifyIr(getCOD(),getOp1(),getOp2());
	}
	
	@Override
	public void tarefa() {
		if(Registrador.getMbr()==0) {			
			Registrador.setPc(getOp1());
			super.jumpConcluded = true;
		}
		if (!super.jumpConcluded) {
			Registrador.increasePc();
		}
	}
	@Override
	public String toString() {
		return String.format("JUMP IF Z to %d",super.getOp1());
	}
	@Override
	public String operacaoDeDados() {
		if (Registrador.getMbr()==0) {
			return String.format("PULANDO SE MBR = 0 PARA OPERAÇÃO NA LINHA: \n%06d \nPULO CONCLUÍDO!", Registrador.getPc());
		}
		else return String.format("PULANDO SE MBR = 0 PARA OPERAÇÃO NA LINHA: \n%06d \nPULO NÃO PÔDE SER CONCLUÍDO!", getOp1());
	}
}
