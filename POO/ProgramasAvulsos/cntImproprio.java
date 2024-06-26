package Faculdade.POO.ProgramasAvulsos;
import javax.swing.JOptionPane;
public class cntImproprio {
    public static void main(String[] args) {
        String msg = (String)JOptionPane.showInputDialog(null, "Forneça uma frase: ", "frase") ;
        String imp="";
        boolean sn=false;
            for(int i=1;i<msg.length();i++){
                if(msg.charAt(i-1)=='s'){
                    imp=(msg.substring(i-1,i+3));
                    if(imp.charAt(imp.length()-1)!='o'){
                        imp=(msg.substring(i-1,i+5));
                    }
                    if (imp.equals("sexo")||imp.equals("sexual")){
                        sn=true;
                    }
                }
                
            }if(sn==true){
                JOptionPane.showMessageDialog(null, "Conteúdo imprópria");
            
            }else 
            JOptionPane.showMessageDialog(null, "Conteúdo liberado");      
            
    
              
    }
}