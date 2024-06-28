package entities;
public class I000101 extends Instrucao{
	
	public I000101(int COD, int op1) {
		super(COD);
		super.setOp1(op1);
		super.setResultado("MBR <- MBR * #pos");
		Registrador.modifyIr(getCOD(),getOp1(),getOp2());
	}
	
	@Override
	public void tarefa() {
		Registrador.setMar(getOp1());
		Registrador.setMbr(Registrador.getMbr()*Registrador.valueInMar());	
		Registrador.increasePc();
	}
	@Override
	public String toString() {
		return String.format("MBR <- MBR * %d",super.getOp1());
	}
	@Override
	public String operacaoDeDados() {
		return String.format("VALOR DO MBR: \n%06f \nVALOR DO CONTEÚDO DA POSIÇÃO: \n%06f \nVALOR NO MBR APÓS OPERAÇÃO:\n%06f\n"
				+ "O VALOR FOI ARMAZENADO!", Registrador.getMbr()/Memory.getMemoria()[getOp1()],Memory.getMemoria()[getOp1()],Registrador.getMbr());
	}
}
