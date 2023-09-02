package org.creditoRural.exceptions;

public class EntidadeExistenteException extends RuntimeException{

    public EntidadeExistenteException(){
        super("Entidade já existente");
    }
}
