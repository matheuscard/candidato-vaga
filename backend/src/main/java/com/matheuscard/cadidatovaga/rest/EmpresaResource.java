/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matheuscard.cadidatovaga.rest;


import com.matheuscard.cadidatovaga.dao.DAO;
import com.matheuscard.cadidatovaga.model.Empresa;
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

@Path("/empresa")
@Transactional
public class EmpresaResource {

    @Inject
    private DAO<Empresa> dao;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Empresa findById(@PathParam("id") long id) {
        return dao.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public long insert(Empresa empresa) {
        return dao.save(empresa);
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean update(Empresa empresa) {
        //Se retornou um id maior que 0, é porque uma empresa foi salva no BD
        return dao.save(empresa) > 0;
    }

    @DELETE
    @Path("{id}")
    public boolean delete(@PathParam("id") long id) {
        return dao.delete(id);
    }
    @GET
    @Path("/estado/{estado}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Empresa> findEmpresaByEstado(@PathParam("estado") long id){
        return dao.findByObject("estado",id);
    }
    @GET
    @Path("/cidade/{cidade}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Empresa> findEmpresaByCidade(@PathParam("cidade") long id){
        return dao.findByObject("cidade",id);
    }
    @GET
    @Path("/vaga/{vaga}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Empresa> findEmpresaByVaga(@PathParam("vaga") long id){
        return dao.findByObject("vaga",id);
    }
    @GET
    @Path("/nome/{nome}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Empresa> findEmpresaByNome(@PathParam("nome") String nome){
        return dao.findByFieldList("nome", nome);
    }
    @GET
    @Path("/lista/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Empresa> listAll(){
        return dao.findAll();
    }
 
    @GET
    @Path("/login/{login}/{senha}")
    @Produces(MediaType.APPLICATION_JSON)
    public Empresa findEmpresaLoginSenha(@PathParam("login")
            String login,@PathParam("senha") String senha){
        return dao.finByFields("login", login, "senha", senha);
    }
    @GET
    @Path("/login/{login}")
    @Produces(MediaType.APPLICATION_JSON)
    public Empresa findEmpresaLogin(@PathParam("login")
            String login){
        return dao.findByField("login", login);
    }

}
