/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matheuscard.cadidatovaga.dao;

import com.matheuscard.cadidatovaga.model.CadastroVaga;
import java.util.List;
/**
 *
 * @author mathe
 * @param <T>
 */
public interface DAO<T extends CadastroVaga> {
    T findById(long id);
    List<T> findByObject(String fieldName, Object value);
    List<T> findByFieldList(String fieldName, Object value);
    T findByField(String fieldName, Object value);
    T finByFields(String fieldName,Object value,String fieldName2, Object value2);
    boolean delete(T entity);
    boolean delete(long id);
    long save(T entity);
    List<T> findAll();
}
