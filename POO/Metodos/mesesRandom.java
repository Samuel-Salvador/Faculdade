package Faculdade.POO.Metodos;
import javax.swing.JOptionPane;
public class mesesRandom {
    public static void main(String[] args) {
        String[] meses={"Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
        int valor = (int)(Math.random()*11);
        JOptionPane.showMessageDialog(null,"O mês sorteado foi: "+meses[valor]);
    }
}
