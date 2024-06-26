package Faculdade.POO.ProgramasAvulsos;
import javax.swing.JOptionPane;
public class trasFrente {
    public static void main(String[] args) {
        String msg = (String)JOptionPane.showInputDialog(null, "Forneça uma frase: ", "frase") ;
        String msgr="";
            for(int i=msg.length();i>0;i--){
               msgr=(msgr+(msg.charAt(i-1))); 
            }
            JOptionPane.showMessageDialog(null, "Frase fornecida: "+msg+"\nFrase de trás para frente: "+msgr);
    
        }      
    }
