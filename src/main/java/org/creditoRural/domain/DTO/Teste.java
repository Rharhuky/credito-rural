package org.creditoRural.domain.DTO;

import org.creditoRural.DAO.PessoaDAO;
import org.creditoRural.DAO.PropriedadeDAO;
import org.creditoRural.domain.Pessoa;

public class Teste {

    public static void main(String[] args) {

//    PropriedadeDTO propriedadeDTO =  PropriedadeDTO.getBuilder()
//            .setPessoaId(5L)
//            .build();
//
//        PropriedadeDAO propriedadeDAO = new PropriedadeDAO();
//        propriedadeDAO.openConnexion()
//                .openTransaction();
//
//        propriedadeDAO.updateById(4L, propriedadeDTO)
//                .commitTransaction()
//                .closeConnexion();

        PessoaDAO dao = new PessoaDAO();
        Pessoa p =dao.openConnexion()
                .findById(5L);

        System.out.println(p.getPropriedades());


    }
}
