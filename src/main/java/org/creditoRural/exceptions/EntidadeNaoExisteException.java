package org.creditoRural.exceptions;

import org.creditoRural.domain.Entidade;

public class EntidadeNaoExisteException extends RuntimeException{

    public EntidadeNaoExisteException(String classe, Object id ) {
        super("Não há ocorrências em " +
                classe +
                " de id " + id);


    }


}
