package entities;

public class I001010 extends Instrucao {

	public I001010(int COD) {
		super(COD);
		super.setResultado("MBR <- raiz_quadrada(MBR)");
		Registrador.modifyIr(getCOD(),getOp1(),getOp2());
	}

	@Override
	public void tarefa() {
		Registrador.setMar((int) Registrador.getMbr());
		Registrador.setMbr(Math.sqrt(Registrador.getMbr()));
		Registrador.increasePc();
	}
	@Override
	public String toString() {
		return String.format("MBR <- raiz_quadrada(MBR)");
	}
	@Override
	public String operacaoDeDados() {
		return String.format("VALOR DO MBR: \n%06f \nREALIZANDO OPERAÇÃO... \nVALOR NO MBR APÓS OPERAÇÃO:\n%06f\n"
				, Registrador.getMbr()*Registrador.getMbr(),Registrador.getMbr());
	}
}
