/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matheuscard.cadidatovaga.dao;

import com.matheuscard.cadidatovaga.model.CadastroVaga;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author mathe
 */


public class JpaDAO<T extends CadastroVaga> implements DAO<T> {
    private final EntityManager em;
    private final Class<T> classe;

    public JpaDAO(EntityManager em, Class<T> classe){
        this.em = em;
        this.classe = classe;
    }

    @Override
    public T findById(long id) {
        return em.find(classe, id);
    }

    @Override
    public boolean delete(T entity) {
        em.remove(entity);
        return true;
    }

    @Override
    public boolean delete(long id) {
        T entity = findById(id);
        return delete(entity);
    }

    @Override
    public long save(T entity) {
        if(entity.getId() > 0)
            em.merge(entity);
        else em.persist(entity);

        return entity.getId();
    }

    @Override
    public List<T> findByObject(String fieldName, Object value) {
        final String jpql = "select o from " + classe.getSimpleName() + " o " +
                            " where o." + fieldName + ".id = :" + fieldName;
        TypedQuery<T> query = em.createQuery(jpql, classe);
        query.setParameter(fieldName,value);
        return query.getResultList();
    }
    @Override
    public T findByField(String fieldName, Object value) {
        final String jpql = "select o from " + classe.getSimpleName() + " o " +
                            " where o." + fieldName + " = :" + fieldName;
        TypedQuery<T> query = em.createQuery(jpql, classe);
        query.setParameter(fieldName,value);
        return query.getSingleResult();
    }

    @Override
    public List<T> findAll() {
//     final String jpql = "select e from Empresa e ";
//        TypedQuery<T> query = em.createQuery(jpql, classe);
//        
//        return query.getResultList();
        final String jpql = "select o from " + classe.getSimpleName() + " o ";
        TypedQuery<T> query = em.createQuery(jpql, classe);
        return query.getResultList();
    }

    @Override
    public T finByFields(String fieldName, Object value, String fieldName2, Object value2) {
        final String jpql = "select o from " + classe.getSimpleName() + " o " +
                            " where o." + fieldName + " = :" + fieldName +" and o."+fieldName2 + " = :"+fieldName2;
        TypedQuery<T> query = em.createQuery(jpql, classe);
        query.setParameter(fieldName,value);
        query.setParameter(fieldName2, value2);
        return query.getSingleResult();
    }

    @Override
    public List<T> findByFieldList(String fieldName, Object value) {
        final String jpql = "select o from " + classe.getSimpleName() + " o " +
                            " where o." + fieldName + " = :" + fieldName;
        TypedQuery<T> query = em.createQuery(jpql, classe);
        query.setParameter(fieldName,value);
        return query.getResultList();
    }



}
