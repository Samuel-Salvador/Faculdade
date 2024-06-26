package entities;

public class I000010 extends Instrucao {

	public I000010(int COD, int op1, int op2) {
		super(COD);
		super.setOp1(op1);
		super.setOp2(op2);
		super.setResultado("#pos <- #dado");
		Registrador.modifyIr(getCOD(),getOp1(),getOp2());
	}

	@Override
	public void tarefa() {
		Registrador.setMar(getOp1());
		Registrador.setMbr(getOp2());
		Memory.putMbrOnMemory();
		Registrador.increasePc();
	}
	@Override
	public String toString() {
		return String.format("%d <- %d",super.getOp1(),super.getOp2());
	}
	@Override
	public String operacaoDeDados() {
		return String.format("ARMAZENANDO: \n%06d \nNA POSIÇÃO: \n%06d \nCALCULANDO ENDEREÇO DO OPERANDO:\nENDEREÇO: %06d\n"
				+ "ARMAZENANDO O OPERANDO: \nMAR: %06d \nO VALOR FOI ARMAZENADO!", getOp2(),getOp1(),getOp1(),getOp1());
	}
}
