package org.creditoRural.query;

import org.creditoRural.DAO.PessoaDAO;
import org.creditoRural.domain.Pessoa;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.sql.internal.SQLQueryParser;

import java.util.List;

public class TesteCOnsulta {

    public static void main(String[] args) {

        PessoaDAO dao = new PessoaDAO();
        dao.openConnexion();

        Pessoa e = dao.findPessoaByCPF("10301504");

        System.out.println(e);
        dao.closeConnexion();
        // o problema era na querys.xml. O nome do parmetro deve ser igual ao field....



    }


}
