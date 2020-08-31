package desafio1.objetos.bean;

import desafio1.objetos.dao.CartaDAO;
import desafio1.objetos.entidade.Carta;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author nammur
 */
@ManagedBean
@SessionScoped
public class CartaBean extends CrudBean<Carta,CartaDAO> {

    private CartaDAO cartaDAO;
    
    @Override
    public CartaDAO getDAO() {
        if(cartaDAO == null){
            cartaDAO = new CartaDAO();
        }
        return cartaDAO;
    }

    @Override
    public Carta criarEntidade() {
        return new Carta();
    }

}
