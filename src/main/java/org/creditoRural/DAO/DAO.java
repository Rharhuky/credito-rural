package org.creditoRural.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.validation.ConstraintViolation;
import org.creditoRural.customConstraint.Validacao;
import org.creditoRural.domain.DTO.DTO;
import org.creditoRural.exceptions.EntidadeNaoExisteException;

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

        try {
            entityManager.getTransaction().commit();

        }
        catch(Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }

        return this;

    }
    public DAO<T> persist(T entity){

        Set<ConstraintViolation<T>> constraints = Validacao.validateEntity(entity);
        if( constraints.isEmpty() ){
            entityManager.persist(entity);
        }
        else {
            constraints.forEach((exception) -> System.out.println(exception.getMessage()));
        }

        return this;

    }

    public T findById(Long id){//problem??? TODO

        if(Objects.isNull(entity))
            throw new RuntimeException("Entidade nao informada");
        T aEntity = entityManager.find(entity, id);

        if(Objects.isNull(aEntity))
            throw new EntidadeNaoExisteException(entity.getName(), id);

        return aEntity;
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

    /**
     * Merge
     * @param entityToMerge
     * @return
     */
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
     * Método que deleta uma entidade a partir do seu id...
     */
    public DAO<T> deleteById(Long id){

        T aEntity = this.findById(id);

        if(Objects.isNull(aEntity))
            throw new EntidadeNaoExisteException(entity.getName(), id);

        entityManager.remove(aEntity);

        return this;
    }

    /**
     * Deletar todos registros de uma entidade T.
     * @return DAO
     */
    public DAO<T> deleteAll(){

        List<T> entities = this.findAll();
        entities.forEach((anEntity) -> entityManager.remove(anEntity));
        return this;
    }


}
