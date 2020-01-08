/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matheuscard.cadidatovaga.config;

import com.matheuscard.cadidatovaga.dao.DAO;
import com.matheuscard.cadidatovaga.dao.JpaDAO;
import com.matheuscard.cadidatovaga.model.CadastroVaga;
import java.lang.reflect.ParameterizedType;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author mathe
 */

public class Producers {
    @Produces
    @PersistenceContext
    private EntityManager em;
    
    
    @Produces
    public <T extends CadastroVaga> DAO<T> getDao(InjectionPoint ip){
        ParameterizedType t = (ParameterizedType) ip.getType();
        Class classe = (Class) t.getActualTypeArguments()[0];
        return new JpaDAO(em, classe);
    }
}
