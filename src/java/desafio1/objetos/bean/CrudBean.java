package desafio1.objetos.bean;

import desafio1.objetos.dao.CrudDAO;
import desafio1.objetos.util.desafio1.objetos.util.exception.ErroSist;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author nammur
 */
public abstract class CrudBean<E, D extends CrudDAO>{
      
    private String estadoTela = "busca";
    
    private E entidade;
    private List<E> entidades;
    
    public abstract D getDAO();
    public abstract E criarEntidade();
    
    public void novo(){
        entidade = criarEntidade();
        mudarParaInsere();
    }
    public void salvar(){
        try {
            getDAO().salvar(entidade);
            entidade = criarEntidade();
            adicionarMsg("Salvo com sucesso", FacesMessage.SEVERITY_INFO);
            mudarParaBusca();
        } catch (ErroSist ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMsg(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }
    public void editar(E entidade){
        this.entidade = entidade;
        mudarParaEdita();
    }
    public void deletar(E entidade){
        try {
            getDAO().deletar(entidade);
            entidades.remove(entidade);
            adicionarMsg("Deletado com sucesso", FacesMessage.SEVERITY_INFO);
        } catch (ErroSist ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMsg(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }
    public void buscar(){
        if(!isBusca()){
            mudarParaBusca();
            return;
        }
        try 
        {
            entidades = getDAO().buscar();
            if(entidades == null || entidades.isEmpty()){
                adicionarMsg("Sem cadastros!", FacesMessage.SEVERITY_WARN);
            }
            
        } catch (ErroSist ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
            adicionarMsg(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }
    
    public void adicionarMsg(String mensagem, FacesMessage.Severity tipoErro){
        FacesMessage fmsg = new FacesMessage(tipoErro, mensagem, null);
        FacesContext.getCurrentInstance().addMessage(null, fmsg);
    }

    public E getEntidade() {
        return entidade;
    }

    public void setEntidade(E entidade) {
        this.entidade = entidade;
    }

    public List<E> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<E> entidades) {
        this.entidades = entidades;
    }
    
    public boolean isInsere(){
        return "insere".equals(estadoTela);
    }
    public boolean isEdita(){
        return "edita".equals(estadoTela);
    }
    public boolean isBusca(){
        return "busca".equals(estadoTela);
    }
    
    public void mudarParaInsere(){
        estadoTela = "insere";
    }
    public void mudarParaEdita(){
        estadoTela = "edita";
    }
    public void mudarParaBusca(){
        estadoTela = "busca";   
    }

}
    