package org.creditoRural.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.validation.ConstraintViolation;
import org.creditoRural.customConstraint.Validacao;
import org.creditoRural.domain.DTO.DTO;
import org.creditoRural.domain.Pessoa;
import org.creditoRural.domain.Propriedade;
import org.creditoRural.exceptions.EntidadeNaoExisteException;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public abstract class DAO<T>  {
    /** TODO
     * CREATE
     * READ
     * UPDATE
     * DELETE
     * Refatorar essa brincadeira
     */

    private static EntityManagerFactory factory;
    protected static EntityManager entityManager;

    private Class<T> entity;

    public DAO(){}

    public DAO(Class<T> entity) {

        this.entity = entity;

    }

    public DAO<T> openConnexion(){

        if(factory == null)
            factory = Persistence.createEntityManagerFactory("creditoRural");

        if(entityManager == null)
            entityManager = factory.createEntityManager();

        return this;
    }

    public DAO<T> closeConnexion(){
        factory.close();
        entityManager.close();

        return this;
    }

    public DAO<T> openTransaction(){

        entityManager.getTransaction().begin();
        return this;

    }

    public DAO<T> commitTransaction(){

        entityManager.getTransaction().commit();
        System.out.println("HOPE???????w");
        return this;

    }
    public DAO<T> persist(T entity){

        Set<ConstraintViolation<T>> constraints = Validacao.validateEntity(entity);
        if( constraints.isEmpty() ){

            System.out.println("Persiste essa porra!");
            entityManager.persist(entity);
        }
        else {
            constraints.forEach((exception) -> System.out.println(exception.getMessage()));
        }

        return this;

    }

    public T findById(Long id){
        
       if(Objects.isNull(entity))
           throw new RuntimeException("CADE O PIX???????????");

       return entityManager.find(entity, id);
    }

    public List<T> findAll(){
        String jpql = "SELECT p FROM " + entity.getName() + " p";

        TypedQuery<T> query = entityManager.createQuery(jpql, entity);
        return query.getResultList();

    }

    //UPDATE - bixo dos inferno viu

    /**
     * Acho que vou precisar de reflection aqui... precisa-se automatizar essa brincadeira, se não fica impossível !!!
     * @param id
     * @param anotherEntity
     * @return
     */

    public DAO<T> updateById(Long id, DTO<T> anotherEntity){
        return this;
    }

    protected DAO<T> update(T entityToMerge){
        entityManager.merge(entityToMerge);
        return this;
    }

    protected DAO<T> detach(T entityToDetach){
        entityManager.detach(entityToDetach);
        return this;
    }

    protected abstract T map(T entityToMap, DTO entityDTO);


    // DELETE - cascade ALLL

    /**
     * Método que delete uma entidade a partir do seu id...
     */
    public DAO<T> deleteById(Long id){

        T aEntity = this.findById(id);

        if(Objects.isNull(aEntity))
            throw new EntidadeNaoExisteException();

        entityManager.remove(aEntity);

        return this;
    }


}
