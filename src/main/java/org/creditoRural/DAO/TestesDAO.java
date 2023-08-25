package org.creditoRural.DAO;

import org.creditoRural.domain.Propriedade;

import java.util.List;

public class TestesDAO {

    public static void main(String[] args) {

        PropriedadeDAO propriedadeDAO = new PropriedadeDAO();
        propriedadeDAO.openConnexion();
        List<Propriedade> p = propriedadeDAO.findAll();
//        propriedadeDAO.closeConnexion();

        p.forEach(System.out::println);


    }


}

