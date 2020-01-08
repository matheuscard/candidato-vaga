/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matheuscard.cadidatovaga.rest;


import com.matheuscard.cadidatovaga.dao.DAO;
import com.matheuscard.cadidatovaga.model.Candidato;
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

@Path("/candidato")
@Transactional
public class CandidatoResource {

    @Inject
    private DAO<Candidato> dao;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Candidato findById(@PathParam("id") long id) {
        return dao.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public long insert(Candidato candidato) {
        return dao.save(candidato);
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean update(Candidato candidato) {
        //Se retornou um id maior que 0, é porque candidato foi salvo no BD
        return dao.save(candidato) > 0;
    }
    @GET
    @Path("/lista/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Candidato> findAll(){
        return dao.findAll();
    }
    @DELETE
    @Path("{id}")
    public boolean delete(@PathParam("id") long id) {
        return dao.delete(id);
    }
    @GET
    @Path("/login/{login}")
    @Produces(MediaType.APPLICATION_JSON)
    public Candidato findCandidatoLogin(@PathParam("login")
            String login){
        return dao.findByField("login", login);
    }
    @GET
    @Path("/login/{login}/{senha}")
    @Produces(MediaType.APPLICATION_JSON)
    public Candidato findCandidatoLoginSenha(@PathParam("login")
            String login,@PathParam("senha") String senha){
        return dao.finByFields("login", login, "senha", senha);
    }
    @GET
    @Path("/lista/estado/{estado}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Candidato> findCandidatosByEstado(@PathParam("estado") long id){
        return dao.findByObject("estado", id);
    }
    @GET
    @Path("/lista/cidade/{cidade}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Candidato> findCandidatosByCidade(@PathParam("cidade") long id){
        return dao.findByObject("cidade", id);
    }
    @GET
    @Path("/lista/cargo/{cargo}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Candidato> findCandidatosByCargo(@PathParam("cargo") long id){
        return dao.findByObject("cargo", id);
    }
}
