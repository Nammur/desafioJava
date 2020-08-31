package desafio1.objetos.dao;

import desafio1.objetos.entidade.Carta;
import desafio1.objetos.util.FabricaConexao;
import desafio1.objetos.util.desafio1.objetos.util.exception.ErroSist;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nammur
 */
public class CartaDAO implements CrudDAO<Carta>{
    
    @Override
    public void salvar(Carta carta) throws ErroSist{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            if(carta.getQuantidade() == null || carta.getDataCompra() == null || "".equals(carta.getColecao())
                || "".equals(carta.getTipoCarta()) || "".equals(carta.getCor()) || "".equals(carta.getTitulo()))
            {
                throw new ErroSist("Preencha todos os campos");
            }
            if(carta.getId() == null){
                ps = conexao.prepareStatement("INSERT INTO `carta` (`titulo`,`colecao`,`cor`,`dataCompra`,`precoCompra`,`quantidade`,`tipoCarta`) VALUES (?,?,?,?,?,?,?)");
            }
            else{
                ps = conexao.prepareStatement("UPDATE `carta` SET `titulo` = ?, `colecao` = ?, `cor` = ?, `dataCompra` = ?, `precoCompra` = ?, `quantidade` = ?, `tipoCarta` = ? WHERE `idCarta` = ?");
                ps.setInt(8, carta.getId());
            }
            ps.setString(1, carta.getTitulo());
            ps.setString(2, carta.getColecao());
            ps.setString(3, carta.getCor());
            ps.setDate(4, new Date(carta.getDataCompra().getTime()));
            ps.setFloat(5, carta.getPrecoCompra());
            ps.setInt(6, carta.getQuantidade());
            ps.setString(7, carta.getTipoCarta());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            throw new ErroSist("Erro ao tentar salvar", ex);
        }
    }
    
    @Override
    public List<Carta> buscar() throws ErroSist{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM `carta`");
            ResultSet resultSet = ps.executeQuery();
            List<Carta> cartas =  new ArrayList<>();
            while(resultSet.next()){
                Carta carta = new Carta();
                carta.setId(resultSet.getInt("idcarta"));
                carta.setTitulo(resultSet.getString("titulo"));
                carta.setColecao(resultSet.getString("colecao"));
                carta.setCor(resultSet.getString("cor"));
                carta.setDataCompra(resultSet.getDate("dataCompra"));
                carta.setPrecoCompra(resultSet.getFloat("precoCompra"));
                carta.setQuantidade(resultSet.getInt("quantidade"));
                carta.setTipoCarta(resultSet.getString("tipoCarta"));
                cartas.add(carta);
            }            
            FabricaConexao.fecharConexao();
            return cartas;
        } catch (SQLException ex) {
            throw new ErroSist("Erro ao tentar buscar", ex);
        }          
    }
    
    @Override
    public void deletar(Carta carta) throws ErroSist{
        try {
            Connection conexao = FabricaConexao.getConexao();           
            PreparedStatement ps = conexao.prepareStatement("DELETE FROM `carta` WHERE `idCarta` = ?");
            ps.setInt(1,carta.getId());
            ps.execute();
        } catch (SQLException ex) {
            throw new ErroSist("Erro ao deletar o carta", ex);
        }
    }
}
