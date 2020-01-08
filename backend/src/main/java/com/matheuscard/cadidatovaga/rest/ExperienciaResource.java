/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matheuscard.cadidatovaga.rest;


import com.matheuscard.cadidatovaga.dao.DAO;
import com.matheuscard.cadidatovaga.model.Experiencia;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author mathe
 */

@Path("/experiencia")
@Transactional
public class ExperienciaResource {

    @Inject
    private DAO<Experiencia> dao;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Experiencia findById(@PathParam("id") long id) {
        return dao.findById(id);
    }
    @GET
    @Path("lista/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Experiencia> findAll() {
        return dao.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public long insert(Experiencia exProf) {
        return dao.save(exProf);
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean update(Experiencia exProf) {
        //Se retornou um id maior que 0, é porque uma experiência profissional foi salva no BD
        return dao.save(exProf) > 0;
    }

    @DELETE
    @Path("{id}")
    public boolean delete(@PathParam("id") long id) {
        return dao.delete(id);
    }
    
    @GET
    @Path("lista/candidato/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Experiencia> findByCandidato(@PathParam("id") long id) {
        return dao.findByObject("candidato", id);
    }
}
