package org.creditoRural.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.validation.ConstraintViolation;
import org.creditoRural.domain.customConstraint.Validacao;

import java.util.Set;

public abstract class DAO<T>  {

    private static EntityManagerFactory factory;
    protected static EntityManager entityManager;

    private Class<T> entidade;

    public DAO(){}

    public DAO(Class<T> entity) {

        this.entidade = entity;
        abrirConexao();

    }

    private DAO<T> abrirConexao(){

        if(factory == null)
            factory = Persistence.createEntityManagerFactory("creditoRural");

        if(entityManager == null)
            entityManager = factory.createEntityManager();

        return this;

    }

    public void fecharConexao(){
        factory.close();
        entityManager.close();
    }

    public DAO<T> abrirTransacao(){

        entityManager.getTransaction().begin();
        return this;

    }

    public DAO<T> fecharTransacao(){

        entityManager.getTransaction().commit();
        return this;

    }

    public DAO<T> persistir(T entity) throws IllegalArgumentException{

        Set<ConstraintViolation<T>> constraints = Validacao.validateEntity(entity);
        if( ! constraints.isEmpty() ){
            constraints.forEach((exception) -> System.out.println(exception.getMessage()));
            throw new IllegalArgumentException();
        }

        entityManager.persist(entity);
        return this;

    }




}
