package desafio1.objetos.util.desafio1.objetos.util.exception;

/**
 *
 * @author nammur
 */
public class ErroSist extends Exception{

    public ErroSist(String message) {
        super(message);
    }
     public ErroSist(String message, Throwable cause){
         super(message, cause);
    }
}
