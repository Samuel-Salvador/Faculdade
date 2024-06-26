package Faculdade.POO.Metodos;
import javax.swing.JOptionPane;
public class Mes {
    public static void main(String[] args) {
        int mes=0,codigo=0;
        Object[] idioma={"Português","Inglês"};
        String cod_s=(String)(JOptionPane.showInputDialog(null,"Selecione o idioma: ","Idioma",JOptionPane.PLAIN_MESSAGE,null,idioma,"Português"));
        if(cod_s=="Português"){
            codigo=1;
        }else if (cod_s==null){
            JOptionPane.showMessageDialog(null,"Você apertou 'Cancel'");
        }else {codigo=2;}
        if (cod_s!=null){
            mes=Integer.parseInt(JOptionPane.showInputDialog(null,"Forneça o número do mês"));
        }
        getMesPorExtenso(mes, codigo);
    }
    public static void getMesPorExtenso(int mes,int codigo){
        String[] meses_p={"Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
        String[] meses_i={"January","February","March","April","May","June","July","August","September","October","November","December"};
        if(codigo==1){
            JOptionPane.showMessageDialog(null,"Idioma: Português\nMês: "+mes+" - "+meses_p[mes-1]);
        }else if(codigo==2){
            JOptionPane.showMessageDialog(null,"Idioma: Inglês\nMês: "+mes+" - "+meses_i[mes-1]);
        }
    }
}
