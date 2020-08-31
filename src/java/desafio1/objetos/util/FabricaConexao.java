package desafio1.objetos.util;

import desafio1.objetos.util.desafio1.objetos.util.exception.ErroSist;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author nammur
 */
public class FabricaConexao {
    
    private static Connection conexao;
    private static final String URL_CONEXAO = "jdbc:mysql://localhost/mydb";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public static Connection getConexao() throws ErroSist {
        if(conexao == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexao = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
            } catch (SQLException ex) {
                throw new ErroSist("Não foi possivel conectar ao DB", ex);
            } catch (ClassNotFoundException ex) {
                throw new ErroSist("Driver não encontrado", ex);
            }
        }
        return conexao;
    }
    public static void fecharConexao()throws ErroSist{
        if(conexao != null){
            try {
                conexao.close();
                conexao=null;
            } catch (SQLException ex) {
                throw new ErroSist("Erro ao fechar conexão com o DB", ex);
            }
        }
    }     
    
}
