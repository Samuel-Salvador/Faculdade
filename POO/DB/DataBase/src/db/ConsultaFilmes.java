package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
public class ConsultaFilmes {
    public static void main(String[] args) {
        final String DRIVER = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/planejamentopessoal?useTimezone=true&serverTimezone=UTC";
        try {
            Class.forName (DRIVER);
            Connection connection = DriverManager.getConnection(URL, "root", "sss290601");
            String sql = "SELECT codigo, titulo_pt FROM filmes WHERE codigo > ? AND codigo < ? ORDER BY codigo";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "800");
            statement.setString(2, "840");
            ResultSet resultSet = statement.executeQuery();
            System.out.println("CÓDIGO TÍTULO");
            System.out.println("______      _______________________________________");
            while (resultSet.next()) {
                String codigo = resultSet.getString("codigo");
                String titulo = resultSet.getString("titulo_pt");
                System.out.println(codigo + "	" + titulo);
            }

            resultSet.close ();
            statement.close ();
            connection.close ();
        }catch (ClassNotFoundException erro) {
            JOptionPane.showMessageDialog(null, "Driver não encontrado!\n" + erro.toString());
        }catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Problemas na conexão com a fonte" + erro.toString());
        }
    }
}