package entities;
public class I001011 extends Instrucao{
	
	public I001011(int COD) {
		super(COD);
		super.setResultado("MBR <- -MBR");
		Registrador.modifyIr(getCOD(),getOp1(),getOp2());
	}
	
	@Override
	public void tarefa() {
		Registrador.setMar((int)Registrador.getMbr());
		Registrador.setMbr(-Registrador.getMbr());	
		Registrador.increasePc();
	}
	@Override
	public String toString() {
		return String.format("%.2f <- -%.2f",-Registrador.getMbr(),Registrador.getMbr());
	}
	@Override
	public String operacaoDeDados() {
		return String.format("VALOR DO MBR: \n%06f \nREALIZANDO OPERAÇÃO... \nVALOR NO MBR APÓS OPERAÇÃO:\n%06f\n"
				, -Registrador.getMbr(),Registrador.getMbr());
	}
}
