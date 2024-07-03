package entities;

public class I001100 extends Instrucao{
	private boolean exit;
	public I001100(int COD) {
		super(COD);
		Registrador.modifyIr(getCOD(),getOp1(),getOp2());
		super.setResultado("NOP");
	}

	@Override
	public void tarefa() {
		exit=true;
		if(exit==true) {			
			Registrador.increasePc();
		}
	}
	@Override
	public String toString() {
		return String.format("NOP");
	}
	@Override
	public String operacaoDeDados() {
		return String.format("ENCERRANDO OPERAÇÕES...\nOPERAÇÕES ENCERRADAS!\n");
		
	}
	
}
