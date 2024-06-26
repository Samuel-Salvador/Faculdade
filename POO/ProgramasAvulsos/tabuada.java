package Faculdade.POO.ProgramasAvulsos;
import javax.swing.JOptionPane;
public class tabuada {
    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Forneça um numero: ", "numero"));
        String janela="";
        for(int i=0;i<=10;i++){
            int res= n*i;
    
            janela=janela+"\n"+String.valueOf(n)+" x "+String.valueOf(i)+" = "+String.valueOf(res);
            }
            JOptionPane.showMessageDialog(null, janela);
    
    }
}
