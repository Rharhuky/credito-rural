package org.creditoRural.testeConexao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.logging.Logger;

public class TesteConexaoComBD {

    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("creditoRural");
    static EntityManager entityManager;

    static Logger logger = Logger.getLogger("Testando a brincadeira");

    public static void main(String[] args) throws InterruptedException {

        abrirConexao();

//        inserirRegistro();
//
//        sleep(3000); // espera por 3 segundos
//
//        consultandoRegistro();

        fecharConexao();

    }

    static void inserirRegistro(){

//        logger.info("Criando tabela ou inserindo registro");
//
//        Pessoa pessoa = new Pessoa("Caramboliudo");
//        entityManager.getTransaction().begin();
//        entityManager.persist(pessoa);
//        entityManager.getTransaction().commit();
//
//        logger.info("Registro inserido");

    }

    static void consultandoRegistro(){

//        Pessoa pessoa = entityManager.find(Pessoa.class, 1L);
//
//        if(Objects.isNull(pessoa))
//            logger.info("Tem parada errada aí irmão");
//        else
//            System.out.println(pessoa);
    }

    static void abrirConexao(){
        logger.info("---------- Abrindo conexao ----------");

        entityManager = factory.createEntityManager();
    }

    static void fecharConexao(){

        factory.close();
        entityManager.close();
        logger.info("---------- fechando conexao ----------");

    }
}
