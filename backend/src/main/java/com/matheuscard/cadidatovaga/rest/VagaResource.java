/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matheuscard.cadidatovaga.rest;


import com.matheuscard.cadidatovaga.dao.DAO;
import com.matheuscard.cadidatovaga.model.Vaga;
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

@Path("/vaga")
@Transactional
public class VagaResource {

    @Inject
    private DAO<Vaga> dao;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Vaga findById(@PathParam("id") long id) {
        return dao.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public long insert(Vaga vaga) {
        return dao.save(vaga);
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean update(Vaga vaga) {
        //Se retornou um id maior que 0, é porque uma vaga foi salva no BD
        return dao.save(vaga) > 0;
    }

    @DELETE
    @Path("{id}")
    public boolean delete(@PathParam("id") long id) {
        return dao.delete(id);
    }

    @GET
    @Path("/lista/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vaga> findAll(){
        return dao.findAll();
    }
    @GET
    @Path("/lista/cargo/{cargo}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vaga> findVagasByCargo(@PathParam("cargo") long id){
        return dao.findByObject("cargo", id);
    }
    @GET
    @Path("/lista/empresa/{empresa}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vaga> findVagasByEmpresa(@PathParam("empresa") long id){
        return dao.findByObject("empresa", id);
    }
    @GET
    @Path("/lista/estado/{estado}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vaga> findVagasByEstado(@PathParam("estado") long id){
        return dao.findByObject("estado", id);
    }
    @GET
    @Path("/lista/cidade/{cidade}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vaga> findVagasByCidade(@PathParam("cidade") long id){
        return dao.findByObject("cidade", id);
    }
    @GET
    @Path("/lista/candidato/{candidato}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vaga> findVagasByCandidato(@PathParam("candidato") long id){
        return dao.findByObject("candidato", id);
    }

}
