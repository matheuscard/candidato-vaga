/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matheuscard.cadidatovaga.rest;


import com.matheuscard.cadidatovaga.dao.DAO;
import com.matheuscard.cadidatovaga.model.Cargo;
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

@Path("/cargo")
@Transactional
public class CargoResource {

    @Inject
    private DAO<Cargo> dao;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cargo findById(@PathParam("id") long id) {
        return dao.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public long insert(Cargo cargo) {
        return dao.save(cargo);
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean update(Cargo cargo) {
        //Se retornou um id maior que 0, é porque um cargo foi salvo no BD
        return dao.save(cargo) > 0;
    }

    @DELETE
    @Path("{id}")
    public boolean delete(@PathParam("id") long id) {
        return dao.delete(id);
    }
    @GET
    @Path("/lista/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cargo> listAll(){
        return dao.findAll();
    }

}
