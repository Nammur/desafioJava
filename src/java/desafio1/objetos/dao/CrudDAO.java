package desafio1.objetos.dao;

import desafio1.objetos.util.desafio1.objetos.util.exception.ErroSist;
import java.util.List;

/**
 *
 * @author nammur
 */
public interface CrudDAO<E>{
    public void salvar(E entidade) throws ErroSist;
    public void deletar(E entidade) throws ErroSist;
    public List<E> buscar() throws ErroSist;
    
}
